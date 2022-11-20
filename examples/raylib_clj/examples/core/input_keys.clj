(ns raylib-clj.examples.core.input-keys
  (:require [raylib-clj.raylib :as rl]))

(def screen-height 800)
(def screen-width 450)

(def ball-position-init {:x (/ screen-width 2)
                          :y (/ screen-height 2)})
(def ball-position (atom ball-position-init))
(def delta 2.2)

(defn move [bp ax dl]
  (assoc bp ax (+ dl (ax bp))))

(defn -main [& args]
  (reset! ball-position ball-position-init)
  (rl/init-window screen-width screen-height "raylib [core] example - keyboard input")
  (rl/set-target-fps 60)
  (while (not (rl/window-should-close?))
    ;; For some reason arrow keys are always down for me, I think b/c of this:
    ;; https://github.com/raysan5/raylib/issues/2718
    ;; (cond (rl/is-key-pressed? rl/key-l) (swap! ball-position move :x delta))
    (cond (rl/is-key-pressed? rl/key-w) (tap> ["pressed"
                                               (rl/is-key-down? rl/key-w)
                                               (rl/is-key-up? rl/key-w)])
          (rl/is-key-released? rl/key-w) (tap> ["released"
                                               (rl/is-key-down? rl/key-w)
                                               (rl/is-key-up? rl/key-w)]))
    ;; (tap> [(rl/is-key-down? rl/key-a)
    ;;        (rl/is-key-up? rl/key-a)
    ;;        (rl/is-key-pressed? rl/key-a)
    ;;        (rl/is-key-released? rl/key-a)])
    (rl/begin-drawing)
    (rl/clear-background rl/raywhite)
    (rl/draw-circle-v @ball-position 50 rl/maroon)
    (rl/end-drawing))
  (rl/close-window))

(comment
  (-main)
  (tap> (meta rl/is-key-down?))
  (tap> rl/key-right)
  (rl/is-key-released? rl/key-escape)
  (require '[vlaaad.reveal :as r])
  (r/tap-log)

  (require '[coffi.mem :as mem])

  (tap> (mem/deserialize (mem/serialize {:x 0 :y 0} ::rl/Vector2) ::rl/Vector2)))
