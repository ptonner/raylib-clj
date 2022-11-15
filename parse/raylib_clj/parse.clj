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
   "double" ::mem/double
   "void" ::mem/void
   "void *" ::mem/pointer
   "char" ::mem/char
   "bool" :raylib-clj.raylib/bool
   "char *" ::mem/c-string
   "const char *" ::mem/c-string})

(defn ->type [t]
  (let [t (str/trim t)
        pointer? (str/ends-with? t "*")]
    (or (type-lookup t)
        (and pointer? [::mem/pointer (->type (subs t 0 (- (count t) 1)))])
        (keyword "raylib-clj.raylib" (str/replace t " " "-")))))

(comment
  ;; Test unsigned types
  (tap> (->type "unsigned int"))
  (tap> (->type "unsigned char"))
  ;; Test pointer types
  (tap> (->type "char *"))
  (tap> (->type "float *"))
  (tap> (->type "Rectangle *")))

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

(def type-re #"(\w+\s)+\*?")
(def endline-comment #"\s*// (?<comment>\V*)")
(def field-line (re-pattern (str #"\s*"
                                 "(?<argtype>" type-re ")"
                                 #"(?<fieldname>\w+);"
                                 endline-comment
                                 #"\v")))
(def struct-start #"\s*typedef struct (?<name>\w+)\s*\{\s*\v")
(def struct-end #"\s*\}\s*(?<rename>\w+);")
(def struct-re (re-pattern (str struct-start
                                "(" field-line ")*"
                                struct-end)))

(defn struct-from-match [[s name & _]]
  `(~'defalias ~(keyword "raylib-clj.raylib" name)
    [:coffi.mem/struct ~(into [] (for [[_ type _ fieldname & _] (re-seq field-line s)]
                                   (vector (keyword fieldname) (->type type))))]))

(comment
  (tap> (struct-from-match (re-find struct-re
                                    "typedef struct Font {
    int baseSize;           // Base size (default chars height)
    int glyphCount;         // Number of glyph characters
    int glyphPadding;       // Padding around the glyph characters
    Texture2D texture;      // Texture atlas containing the glyphs
    Rectangle *recs;        // Rectangles in texture for the glyphs
    GlyphInfo *glyphs;      // Glyphs info data
} Font;"))))

(defn parse-structs [s]
  (for [m (re-seq struct-re s)]
    (struct-from-match m)))

(comment
  (tap> (parse-structs (slurp "tmp.h"))))

;; Functions ------------------------------------------------------------------

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

  (tap> (map fn-from-match
             (re-seq fxn-re (slurp "tmp.h"))))
  (tap> (map fn-from-match
             (re-seq fxn-re
                     "RLAPI void ShowCursor(void);                                      // Shows cursor
RLAPI void HideCursor(void);                                      // Hides cursor
RLAPI bool IsCursorHidden(void);                                  // Check if cursor is not visible
RLAPI void EnableCursor(void);                                    // Enables cursor (unlock cursor)
RLAPI void DisableCursor(void);                                   // Disables cursor (lock cursor)
RLAPI bool IsCursorOnScreen(void);                                // Check if cursor is on the screen"))))
