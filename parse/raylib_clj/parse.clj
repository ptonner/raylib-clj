(ns raylib-clj.parse
  (:require [clojure.string :as str]
            [clojure.edn :refer [read-string]]
            [camel-snake-kebab.core :as csk]))

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

  (enum-parse
   "   NPATCH_NINE_PATCH = 0,          // Npatch layout: 3x3 tiles
    NPATCH_THREE_PATCH_VERTICAL,    // Npatch layout: 1x3 tiles
    NPATCH_THREE_PATCH_HORIZONTAL   // Npatch layout: 3x1 tiles"))
