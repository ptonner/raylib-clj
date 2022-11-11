(ns raylib-clj.examples
  (:require [raylib-clj.raylib :as rl]))

(comment
  ;; Basic window
  (let [H 800
        W 800]
    (rl/init-window W H "raylib [core] example - basic window")
    (rl/set-target-fps 60)
    (while (not (rl/window-should-close))
      (rl/begin-drawing)
      ;; (rl/clear-background rl/)
      (rl/end-drawing))
    (rl/close-window)))
