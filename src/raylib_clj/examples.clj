(ns raylib-clj.examples
  (:require [raylib-clj.raylib :as rl]))

(comment
  ;; Basic window
  (let [H 800
        W 800]
    (rl/init-window W H "raylib [core] example - basic window")
    (rl/set-target-fps 60)
    (while (not (rl/window-should-close?))
      (rl/begin-drawing)
      (rl/clear-background rl/raywhite)
      (rl/draw-rectangle-rec {:x 0.0 :y 100.0 :width 100.0 :height 100.0}
                             {:r 0 :g 0 :b 0 :a 255})
      (rl/end-drawing))
    (rl/close-window))

  ;; eject!
  (rl/close-window))
