(ns raylib-clj.parse
  "Parse the raylib API in the form of json, producing a `coffi`-based clojure API."
  (:require [clojure.string :as str]
            [clojure.spec.alpha :as s]
            [clojure.edn :refer [read-string]]
            [camel-snake-kebab.core :as csk]
            [charred.api :as charred]
            [zprint.core :as zp]
            [coffi.mem :as mem]))

(s/def ::description string?)
(s/def ::name string?)
(s/def ::type string?)

(s/def ::param-name (s/and string? #(= % (str/lower-case %))))
(s/def ::param (s/keys :req-un [::type ::param-name]))
(s/def ::params (s/coll-of ::param))

(s/def :fn/name string?)
(s/def :fn/returnType string?)
(s/def ::function
  (s/keys :req-un [:fn/name ::description ::params :fn/returnType]))

(s/def ::api (s/keys :req-un [::function]))

(def api
  "The raylib API preprocessed into a json.

  The json was taken from [[https://github.com/raysan5/raylib/tree/master/parser]]"
  (charred/read-json (slurp "parse/resources/raylib_api.json") :key-fn keyword))

(comment (require '[vlaaad.reveal :as r]) (r/tap-log))

(defn ->raylib-keyword
  "Convert the provided name to a keyword in the `raylib` namespace."
  [nm]
  (keyword "raylib-clj.raylib" nm))

(defn ->type
  "Parse the provided type `t` into a valid `coffi` type identifier."
  [t]
  (cond (= t "void *") ::mem/pointer
        (= t "const void *") ::mem/pointer
        (re-find #"char \*$" t) ::mem/c-string
        (= (last t) \*) [::mem/pointer
                         (->type (str/trim (subs t 0 (- (count t) 1))))]
        (re-find #"^unsigned" t) (->raylib-keyword (str/replace t " " "-"))
        (Character/isUpperCase (first t)) (->raylib-keyword t)
        (= t "bool") (->raylib-keyword t)
        :else (keyword "coffi.mem" t)))

(defn ->defcfn
  [& {:keys [name description returnType params]}]
  (let [cname (symbol
                (csk/->kebab-case (str name
                                       ;; Add "?" to query functions
                                       (when (= "bool" returnType) "?"))))]
    `(~'defcfn
      ~cname
      ~description
      ~name
      [~@(map ->type (map :type params))]
      ~(->type returnType))))

(def function-filters
  (every-pred
    ;; skip varargs
    (fn [f] (not (some #(= (:type %) "...") (:params f))))
    ;; skip callbacks
    #(not (re-find #"Callback$" (:name %)))))

(comment (tap> (filter function-filters [{:name "ABCallback"} {:name "ABC"}])))

(defn parse-functions
  []
  (spit "parsed/functions.clj"
        (str/join "\n\n"
                  (map (comp #(str/replace % ":coffi.mem" "::mem")
                             #(str/replace % ":raylib-clj.raylib/" "::")
                             zp/zprint-str
                             ->defcfn)
                    (filter ;; (fn [f] (not (some #(= (:type %) "...") (:params
                            ;; f))))
                      function-filters
                      (:functions api))))))

(defn ->defstruct
  [& {:keys [name description fields]}]
  (let [cname (->raylib-keyword name)]
    `(~'defalias
      ~cname
      (~'layout/with-c-layout
       [::mem/struct
        [~@(map #(vector (keyword (:name %)) (->type (:type %))) fields)]]))))

(defn alias->defstruct
  [& {:keys [:type :name]}]
  (let [cname (->raylib-keyword name)
        ctype (->raylib-keyword type)]
    `(~'defalias ~cname ~ctype)))

(comment (tap> (map (comp #(str/replace % ":coffi.mem" "::mem")
                          #(str/replace % ":raylib-clj.raylib/" "::")
                          zp/zprint-str
                          alias->defstruct)
                 (:aliases api))))

(defn parse-structs
  []
  (spit "parsed/structs.clj"
        (str (str/join "\n\n"
                       (map (comp #(str/replace % ":coffi.mem" "::mem")
                                  #(str/replace % ":raylib-clj.raylib/" "::")
                                  zp/zprint-str
                                  alias->defstruct)
                         (:aliases api)))
             (str/join "\n\n"
                       (map (comp #(str/replace % ":coffi.mem" "::mem")
                                  #(str/replace % ":raylib-clj.raylib/" "::")
                                  zp/zprint-str
                                  ->defstruct)
                         (:structs api))))))

(comment (tap> api)
         (tap> (for [t ["Vector2" "void" "int" "unsigned int" "Camera *"
                        "Camera **" "const char *" "unsigned char *" "char *"]]
                 [t (->type t)]))
         (tap> (map ->defcfn (take 10 (:functions api))))
         (tap> (->defstruct (first (:structs api))))
         (tap> (map ->defstruct (:structs api)))
         (parse-structs)
         (parse-functions))
