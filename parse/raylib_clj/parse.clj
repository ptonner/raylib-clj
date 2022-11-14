(ns raylib-clj.parse
  (:require [clojure.string :as str]
            [clojure.edn :refer [read-string]]
            [camel-snake-kebab.core :as csk]))

(comment
  (require '[vlaaad.reveal :as r])
  (r/tap-log)
  ,)

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

(def comment #"\s*// (?<comment>\V*)")
(def field-line (re-pattern (str #"\s*(?<type>(\w+\s)+)(?<fieldname>(\w|\*)+);" comment #"\v")))
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
  (def structs "// Color, 4 components, R8G8B8A8 (32bit)
typedef struct Color {
    unsigned char r;        // Color red value
    unsigned char g;        // Color green value
    unsigned char b;        // Color blue value
    unsigned char a;        // Color alpha value
} Color;

// Rectangle, 4 components
typedef struct Rectangle {
    float x;                // Rectangle top-left corner position x
    float y;                // Rectangle top-left corner position y
    float width;            // Rectangle width
    float height;           // Rectangle height
} Rectangle;

// Image, pixel data stored in CPU memory (RAM)
typedef struct Image {
    void *data;             // Image raw data
    int width;              // Image base width
    int height;             // Image base height
    int mipmaps;            // Mipmap levels, 1 by default
    int format;             // Data format (PixelFormat type)
} Image;")
  (tap> (parse-structs structs)))

(comment

  (tap> (let [name "A"] `(~(keyword 'raylib-clj.raylib name))))

  (keyword "a" "b")
  (tap> (re-find comment-pattern "// abc-123"))
  (def struct "typedef struct Rectangle {
    float x;                // Rectangle top-left corner position x
    float y;                // Rectangle top-left corner position y
    float width;            // Rectangle width
    float height;           // Rectangle height
} Rectangle;")

  (tap> (re-seq field-line struct))
  (tap> (re-seq struct-re struct))


  (tap> (re-seq struct-re struct))
  (tap> (-> (doto (re-matcher struct-re struct)
              re-find)
            re-groups))
  (tap> (re-find struct-re "typedef struct Rectangle {
    float x;                // Rectangle top-left corner position x
    float y;                // Rectangle top-left corner position y
    float width;            // Rectangle width
    float height;           // Rectangle height
} Rectangle;"))
  (tap> #'re-groups)


  (tap> (clojure.java.javadoc/javadoc java.util.regex.Pattern)))
