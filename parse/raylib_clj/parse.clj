(ns raylib-clj.parse
  (:require [clojure.string :as str]
            [clojure.edn :refer [read-string]]
            [camel-snake-kebab.core :as csk]
            [charred.api :as charred]
            [zprint.core :as zp]
            [coffi.mem :as mem]))

(def api (charred/read-json (slurp "parse/resources/raylib_api.json")
                            :key-fn keyword))

(comment
  (require '[vlaaad.reveal :as r])
  (r/tap-log)
  ,)

(defn ->raylib-keyword [nm]
  (keyword "raylib-clj.raylib" nm))

(defn ->type [t]
  (cond (= t "void *") ::mem/pointer
        (re-find #"char \*$" t) ::mem/c-string
        (= (last t) \*) [::mem/pointer (->type (str/trim (subs t 0 (- (count t) 1))))]
        (re-find #"^unsigned" t) (->raylib-keyword (str/replace t " " "-"))
        (Character/isUpperCase (first t)) (->raylib-keyword t)
        :else (keyword "coffi.mem" t)))

(defn ->defcfn [& {:keys [name description returnType params]}]
  (let [cname (symbol (csk/->kebab-case (str name
                                             ;; Add "?" to query functions
                                             (when (= "bool" returnType) "?"))))]
    `(~'defcfn ~cname ~description ~name
       [~@(map ->type (map :type params))]
       ~(->type returnType))))

(defn parse-functions []
  (spit "parsed/functions.clj"
        (str/join "\n\n"
                  (map (comp #(str/replace % ":coffi.mem" "::mem")
                             #(str/replace % ":raylib-clj.raylib/" "::")
                             zp/zprint-str
                             ->defcfn)
                       (:functions api)))))

(defn ->defstruct [{:keys [name description fields]}]
  (let [cname (->raylib-keyword name)]
    `(~'defalias ~cname
      (~'layout/with-c-layout
       [::mem/struct
        [~@(map #(vector (keyword (:name %)) (->type (:type %)))
                fields)]]))))

(defn parse-structs []
  (spit "parsed/structs.clj"
        (str/join "\n\n"
                  (map (comp #(str/replace % ":coffi.mem" "::mem")
                             #(str/replace % ":raylib-clj.raylib/" "::")
                             zp/zprint-str
                             ->defstruct)
                       (:structs api)))))

(comment
  (def lookup
    {:functions (into {} (map #(vector (keyword (:name %)) %) (:functions api)))
     :structs (into {} (map #(vector (keyword (:name %)) %) (:structs api)))})
  (tap> (:structs lookup))
  (tap> (zp/zprint-str '(() ())))
  (tap> (last "fdsa*"))
  (tap> (:functions api))
  (tap> (for [t ["Vector2"
                 "void"
                 "int"
                 "unsigned int"
                 "Camera *"
                 "Camera **"
                 "const char *"
                 "unsigned char *"
                 "char *"]]
          [t (->type t)]))
  (tap> (map ->defcfn (take 10 (:functions api))))
  (tap> (->defstruct (first (:structs api))))
  (tap> (map ->defstruct (:structs api)))

  (parse-functions)
  (parse-structs))
