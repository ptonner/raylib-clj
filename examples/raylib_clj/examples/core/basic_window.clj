(ns raylib-clj.examples.core.basic-window
  (:require [raylib-clj.raylib :as rl]))

(defn -main [& args]
  ;; Basic window
  (let [H 450
        W 800]
    (rl/init-window W H "raylib [core] example - basic window")
    (rl/set-target-fps 60)
    (while (not (rl/window-should-close?))
      (rl/begin-drawing)
      (rl/clear-background rl/raywhite)
      (rl/draw-text "Congrats! You created your first window!", 190, 200, 20, rl/lightgray)
      (rl/end-drawing))
    (rl/close-window)))

(comment
  (-main))
