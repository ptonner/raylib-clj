(ns raylib-clj.raylib
  (:require [coffi.ffi :as ffi :refer [defcfn]]
            [coffi.mem :as mem :refer [defalias]]))

(ffi/load-library "lib/libraylib.so")

;; Util

(defmethod mem/primitive-type ::bool
  [_type]
  ::mem/int)

(defmethod mem/serialize* ::bool
  [obj _type _scope]
  (int (if obj 1 0)))

(defmethod mem/deserialize* ::bool
  [obj _type]
  (not (zero? obj)))

(defalias ::Color
  [::mem/struct
   [[:r ::mem/char]
    [:g ::mem/char]
    [:b ::mem/char]
    [:a ::mem/char]]])

;; Constants

(def raywhite {:r 245 :g 245 :b 245 :a 255})

;; Enums -----------------------------------------------------------------------

;; System/Window config flags
(def flag-vsync-hint
  "Set to try enabling V-Sync on GPU" 0x00000040)

;; FLAG_FULLSCREEN_MODE    = 0x00000002,   // Set to run program in fullscreen
;; FLAG_WINDOW_RESIZABLE   = 0x00000004,   // Set to allow resizable window
;; FLAG_WINDOW_UNDECORATED = 0x00000008,   // Set to disable window decoration (frame and buttons)
;; FLAG_WINDOW_HIDDEN      = 0x00000080,   // Set to hide window
;; FLAG_WINDOW_MINIMIZED   = 0x00000200,   // Set to minimize window (iconify)
;; FLAG_WINDOW_MAXIMIZED   = 0x00000400,   // Set to maximize window (expanded to monitor)
;; FLAG_WINDOW_UNFOCUSED   = 0x00000800,   // Set to window non focused
;; FLAG_WINDOW_TOPMOST     = 0x00001000,   // Set to window always on top
;; FLAG_WINDOW_ALWAYS_RUN  = 0x00000100,   // Set to allow windows running while minimized
;; FLAG_WINDOW_TRANSPARENT = 0x00000010,   // Set to allow transparent framebuffer
;; FLAG_WINDOW_HIGHDPI     = 0x00002000,   // Set to support HighDPI
;; FLAG_WINDOW_MOUSE_PASSTHROUGH = 0x00004000, // Set to support mouse passthrough, only supported when FLAG_WINDOW_UNDECORATED
;; FLAG_MSAA_4X_HINT       = 0x00000020,   // Set to try enabling MSAA 4X
;; FLAG_INTERLACED_HINT    = 0x00010000    // Set to try enabling interlaced video format (for V3D)

;; Functions -------------------------------------------------------------------

;; Window

(defcfn init-window "Initialize window"
  InitWindow [::mem/int ::mem/int ::mem/c-string] ::mem/void)

(defcfn close-window "Close window"
  CloseWindow [] ::mem/void)

(defcfn window-should-close? "Window should close?"
  WindowShouldClose [] ::bool)

(defcfn is-window-ready?
  "Check if window has been initialized successfully"
  IsWindowReady [] ::bool)

(defcfn is-window-fullscreen?
  "Check if window is currently fullscreen"
  IsWindowFullscreen [] ::bool)

(defcfn is-window-hidden?
  "Check if window is currently hidden (only PLATFORM_DESKTOP)"
  IsWindowHidden [] ::bool)

(defcfn is-window-minimized?
  "Check if window is currently minimized (only PLATFORM_DESKTOP)"
  IsWindowMinimized [] ::bool)

(defcfn is-window-maximized?
  "Check if window is currently maximized (only PLATFORM_DESKTOP)"
  IsWindowMaximized [] ::bool)

(defcfn is-window-focused?
  "Check if window is currently focused (only PLATFORM_DESKTOP)"
  IsWindowFocused [] ::bool)

(defcfn is-window-resized?
  "Check if window has been resized last frame"
  IsWindowResized [] ::bool)

;; RLAPI bool IsWindowState(unsigned int flag);                      // Check if one specific window flag is enabled
(defcfn is-window-state?
  "Check if one specific window flag is enabled"
  IsWindowState [::int] ::bool)

;; RLAPI void SetWindowState(unsigned int flags);                    // Set window configuration state using flags (only PLATFORM_DESKTOP)
;; RLAPI void ClearWindowState(unsigned int flags);                  // Clear window configuration state flags
;; RLAPI void ToggleFullscreen(void);                                // Toggle window state: fullscreen/windowed (only PLATFORM_DESKTOP)
;; RLAPI void MaximizeWindow(void);                                  // Set window state: maximized, if resizable (only PLATFORM_DESKTOP)
;; RLAPI void MinimizeWindow(void);                                  // Set window state: minimized, if resizable (only PLATFORM_DESKTOP)
;; RLAPI void RestoreWindow(void);                                   // Set window state: not minimized/maximized (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowIcon(Image image);                            // Set icon for window (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowTitle(const char *title);                     // Set title for window (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowPosition(int x, int y);                       // Set window position on screen (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowMonitor(int monitor);                         // Set monitor for the current window (fullscreen mode)
;; RLAPI void SetWindowMinSize(int width, int height);               // Set window minimum dimensions (for FLAG_WINDOW_RESIZABLE)
;; RLAPI void SetWindowSize(int width, int height);                  // Set window dimensions
;; RLAPI void SetWindowOpacity(float opacity);                       // Set window opacity [0.0f..1.0f] (only PLATFORM_DESKTOP)
;; RLAPI void *GetWindowHandle(void);                                // Get native window handle
;; RLAPI int GetScreenWidth(void);                                   // Get current screen width
;; RLAPI int GetScreenHeight(void);                                  // Get current screen height
;; RLAPI int GetRenderWidth(void);                                   // Get current render width (it considers HiDPI)
;; RLAPI int GetRenderHeight(void);                                  // Get current render height (it considers HiDPI)
;; RLAPI int GetMonitorCount(void);                                  // Get number of connected monitors
;; RLAPI int GetCurrentMonitor(void);                                // Get current connected monitor
;; RLAPI Vector2 GetMonitorPosition(int monitor);                    // Get specified monitor position
;; RLAPI int GetMonitorWidth(int monitor);                           // Get specified monitor width (current video mode used by monitor)
;; RLAPI int GetMonitorHeight(int monitor);                          // Get specified monitor height (current video mode used by monitor)
;; RLAPI int GetMonitorPhysicalWidth(int monitor);                   // Get specified monitor physical width in millimetres
;; RLAPI int GetMonitorPhysicalHeight(int monitor);                  // Get specified monitor physical height in millimetres
;; RLAPI int GetMonitorRefreshRate(int monitor);                     // Get specified monitor refresh rate
;; RLAPI Vector2 GetWindowPosition(void);                            // Get window position XY on monitor
;; RLAPI Vector2 GetWindowScaleDPI(void);                            // Get window scale DPI factor
;; RLAPI const char *GetMonitorName(int monitor);                    // Get the human-readable, UTF-8 encoded name of the primary monitor
;; RLAPI void SetClipboardText(const char *text);                    // Set clipboard text content
;; RLAPI const char *GetClipboardText(void);                         // Get clipboard text content
;; RLAPI void EnableEventWaiting(void);                              // Enable waiting for events on EndDrawing(), no automatic event polling
;; RLAPI void DisableEventWaiting(void);                             // Disable waiting for events on EndDrawing(), automatic events polling


(defcfn set-target-fps "Set target FPS"
  SetTargetFPS [::mem/int] ::mem/void)

(defcfn begin-drawing "Begin drawing"
  BeginDrawing [] ::mem/void)

(defcfn end-drawing "End drawing"
  EndDrawing [] ::mem/void)

(defcfn clear-background "Clear the background"
  ClearBackground [::Color] ::mem/void)

(defcfn get-random-value "Get random value"
  GetRandomValue [::mem/int ::mem/int] ::mem/int)
