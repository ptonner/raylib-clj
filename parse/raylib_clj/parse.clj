(ns raylib-clj.parse
  (:require [clojure.string :as str]
            [clojure.edn :refer [read-string]]
            [camel-snake-kebab.core :as csk]
            [coffi.mem :as mem]))

(comment
  (require '[vlaaad.reveal :as r])
  (r/tap-log)
  ,)

;; Util

(def type-lookup
  {"int" ::mem/int
   "float" ::mem/float
   "void" ::mem/void
   "char" ::mem/char
   "bool" :raylib-clj.raylib/bool
   "unsigned int" ::mem/long
   "char *" ::mem/c-string
   "const char *" ::mem/c-string})

(defn ->type [t]
  (let [t (str/trim t)]
    (or (type-lookup t)
        (keyword "raylib-clj.raylib" t))))

;; Enums

(def enum-re
  "Regex matching an individual line of an enum field."
  #"\s*(?<name>\w+)(\s+= (?<value>.*))?,?\s*// (?<doc>.*)\v?")

(defn- enum-from-match [m]
  (let [[_ nm _ value doc] m]
    `(~(symbol (csk/->kebab-case nm))
       ~doc ~(read-string value))))

(defn- enum-parse-str [s]
  (str/replace s enum-re #(str (enum-from-match %) "\n\n")))

(defn- enum-parse [s]
  (apply concat
         (for [m (re-seq enum-re s)]
           (enum-from-match m))))

(comment

  (tap>
   (enum-parse
    "   NPATCH_NINE_PATCH = 0,          // Npatch layout: 3x3 tiles
    NPATCH_THREE_PATCH_VERTICAL,    // Npatch layout: 1x3 tiles
    NPATCH_THREE_PATCH_HORIZONTAL   // Npatch layout: 3x1 tiles")))

;; Structs --------------------------------------------------------------------

(def endline-comment #"\s*// (?<comment>\V*)")
(def field-line (re-pattern (str #"\s*(?<type>(\w+\s)+)(?<fieldname>(\w|\*)+);" endline-comment #"\v")))
(def struct-start #"\s*typedef struct (?<name>\w+)\s*\{\s*\v")
(def struct-end #"\s*\}\s*(?<rename>\w+);")
(def struct-re (re-pattern (str struct-start
                                "(" field-line ")*"
                                struct-end)))

(defn struct-from-match [[s name & _]]
  `(~'defalias ~(keyword "raylib-clj.raylib" name)
    [:coffi.mem/struct ~(into [] (for [[_ type _ fieldname & _] (re-seq field-line s)]
                                   (vector (keyword fieldname) (keyword "coffi.mem" (str/replace (str/trim type) " " "-")))))]))

(comment
  (def struct "typedef struct Rectangle {
    float x;                // Rectangle top-left corner position x
    float y;                // Rectangle top-left corner position y
    float width;            // Rectangle width
    float height;           // Rectangle height
} Rectangle;")
  (def struct "typedef struct Color {
    unsigned char r;        // Color red value
    unsigned char g;        // Color green value
    unsigned char b;        // Color blue value
    unsigned char a;        // Color alpha value
} Color;")
  (def struct "typedef struct Image {
    void *data;             // Image raw data
    int width;              // Image base width
    int height;             // Image base height
    int mipmaps;            // Mipmap levels, 1 by default
    int format;             // Data format (PixelFormat type)
} Image;")
  (tap> (struct-from-match (re-find struct-re struct))))

(defn parse-structs [s]
  (for [m (re-seq struct-re s)]
    (struct-from-match m)))

(comment
  (def structs "typedef struct Vector2 {
    float x;                // Vector x component
    float y;                // Vector y component
} Vector2;

// Vector3, 3 components
typedef struct Vector3 {
    float x;                // Vector x component
    float y;                // Vector y component
    float z;                // Vector z component
} Vector3;

// Vector4, 4 components
typedef struct Vector4 {
    float x;                // Vector x component
    float y;                // Vector y component
    float z;                // Vector z component
    float w;                // Vector w component
} Vector4;")
  (tap> (parse-structs structs)))

;; Functions ------------------------------------------------------------------

(def type-re #"(\w+\s)+\*?")
(def argument (re-pattern (str "(?<argtype>" type-re ")" #"(?<argname>\w+)(, )?")))
(def fxn-re (re-pattern (str #"RLAPI "
                             (str "(?<rettype>" type-re "\\s?)")
                             #"(?<name>\w+)\("
                             "((" argument ")+" "|void)"
                             #"\);"
                             endline-comment)))

(defn fn-from-match [[s rettype _ name args & rest]]
  (let [doc (last rest)]
    `(~'defcfn
      ;; Clojure function name
      ~(symbol (csk/->kebab-case (str name (when (= rettype "bool ") "?"))))
      ;; Documentation and native function name
      ~(str/trim doc) ~(symbol name)
      ;; Argument types
      ~(if (= "void" args)
         []
         (into [] (map (fn [[_ typ & _]] (->type typ))
                       (re-seq argument args))))
      ;; Return type
      ~(->type rettype))))

(comment
  (tap> fxn-re)
  (tap> (re-seq argument "int width, int height, const char *title"))
  (tap> (map fn-from-match (re-seq fxn-re "RLAPI bool IsWindowResized(void);                                 // Check if window has been resized last frame
RLAPI Vector2 GetWindowPosition(void);                            // Get window position XY on monitor
RLAPI const char *GetClipboardText(void);                         // Get clipboard text content
")))
  true
  (tap> (map fn-from-match
             (re-seq fxn-re "RLAPI void InitWindow(int width, int height, const char *title);  // Initialize window and OpenGL context
RLAPI bool WindowShouldClose(void);                               // Check if KEY_ESCAPE pressed or Close icon pressed
RLAPI void CloseWindow(void);                                     // Close window and unload OpenGL context
RLAPI bool IsWindowReady(void);                                   // Check if window has been initialized successfully
RLAPI bool IsWindowFullscreen(void);                              // Check if window is currently fullscreen
RLAPI bool IsWindowHidden(void);                                  // Check if window is currently hidden (only PLATFORM_DESKTOP)
RLAPI bool IsWindowMinimized(void);                               // Check if window is currently minimized (only PLATFORM_DESKTOP)
RLAPI bool IsWindowMaximized(void);                               // Check if window is currently maximized (only PLATFORM_DESKTOP)
RLAPI bool IsWindowFocused(void);                                 // Check if window is currently focused (only PLATFORM_DESKTOP)
RLAPI bool IsWindowResized(void);                                 // Check if window has been resized last frame
RLAPI bool IsWindowState(unsigned int flag);                      // Check if one specific window flag is enabled
RLAPI void SetWindowState(unsigned int flags);                    // Set window configuration state using flags (only PLATFORM_DESKTOP)
RLAPI void ClearWindowState(unsigned int flags);                  // Clear window configuration state flags
RLAPI void ToggleFullscreen(void);                                // Toggle window state: fullscreen/windowed (only PLATFORM_DESKTOP)
RLAPI void MaximizeWindow(void);                                  // Set window state: maximized, if resizable (only PLATFORM_DESKTOP)
RLAPI void MinimizeWindow(void);                                  // Set window state: minimized, if resizable (only PLATFORM_DESKTOP)
RLAPI void RestoreWindow(void);                                   // Set window state: not minimized/maximized (only PLATFORM_DESKTOP)
RLAPI void SetWindowIcon(Image image);                            // Set icon for window (only PLATFORM_DESKTOP)
RLAPI void SetWindowTitle(const char *title);                     // Set title for window (only PLATFORM_DESKTOP)
RLAPI void SetWindowPosition(int x, int y);                       // Set window position on screen (only PLATFORM_DESKTOP)
RLAPI void SetWindowMonitor(int monitor);                         // Set monitor for the current window (fullscreen mode)
RLAPI void SetWindowMinSize(int width, int height);               // Set window minimum dimensions (for FLAG_WINDOW_RESIZABLE)
RLAPI void SetWindowSize(int width, int height);                  // Set window dimensions
RLAPI void SetWindowOpacity(float opacity);                       // Set window opacity [0.0f..1.0f] (only PLATFORM_DESKTOP)
RLAPI void *GetWindowHandle(void);                                // Get native window handle
RLAPI int GetScreenWidth(void);                                   // Get current screen width
RLAPI int GetScreenHeight(void);                                  // Get current screen height
RLAPI int GetRenderWidth(void);                                   // Get current render width (it considers HiDPI)
RLAPI int GetRenderHeight(void);                                  // Get current render height (it considers HiDPI)
RLAPI int GetMonitorCount(void);                                  // Get number of connected monitors
RLAPI int GetCurrentMonitor(void);                                // Get current connected monitor
RLAPI Vector2 GetMonitorPosition(int monitor);                    // Get specified monitor position
RLAPI int GetMonitorWidth(int monitor);                           // Get specified monitor width (current video mode used by monitor)
RLAPI int GetMonitorHeight(int monitor);                          // Get specified monitor height (current video mode used by monitor)
RLAPI int GetMonitorPhysicalWidth(int monitor);                   // Get specified monitor physical width in millimetres
RLAPI int GetMonitorPhysicalHeight(int monitor);                  // Get specified monitor physical height in millimetres
RLAPI int GetMonitorRefreshRate(int monitor);                     // Get specified monitor refresh rate
RLAPI Vector2 GetWindowPosition(void);                            // Get window position XY on monitor
RLAPI Vector2 GetWindowScaleDPI(void);                            // Get window scale DPI factor
RLAPI const char *GetMonitorName(int monitor);                    // Get the human-readable, UTF-8 encoded name of the primary monitor
RLAPI void SetClipboardText(const char *text);                    // Set clipboard text content
RLAPI const char *GetClipboardText(void);                         // Get clipboard text content
RLAPI void EnableEventWaiting(void);                              // Enable waiting for events on EndDrawing(), no automatic event polling
RLAPI void DisableEventWaiting(void);                             // Disable waiting for events on EndDrawing(), automatic events polling"))))
