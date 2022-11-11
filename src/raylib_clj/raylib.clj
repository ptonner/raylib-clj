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

;; Functions

(defcfn init-window "Initialize window"
  InitWindow [::mem/int ::mem/int ::mem/c-string] ::mem/void)

(defcfn set-target-fps "Set target FPS"
  SetTargetFPS [::mem/int] ::mem/void)

(defcfn begin-drawing "Begin drawing"
  BeginDrawing [] ::mem/void)

(defcfn end-drawing "End drawing"
  EndDrawing [] ::mem/void)

(defcfn close-window "Close window"
  CloseWindow [] ::mem/void)

(defcfn window-should-close "Window should close?"
  WindowShouldClose [] ::bool)
