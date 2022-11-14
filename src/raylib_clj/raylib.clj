(ns raylib-clj.raylib
  (:require [coffi.ffi :as ffi :refer [defcfn]]
            [coffi.mem :as mem :refer [defalias]]))

(ffi/load-library "lib/libraylib.so")

;; Util

(defmethod mem/primitive-type ::bool [_type] ::mem/int)

(defmethod mem/serialize* ::bool [obj _type _scope] (int (if obj 1 0)))

(defmethod mem/deserialize* ::bool [obj _type] (not (zero? obj)))

;; Structs

(comment (tap> (ns-publics 'coffi.mem)) (tap> ::mem/struct))

;; (defalias ::Color
;;           [::mem/struct
;;            [[:r ::mem/char] [:g ::mem/char] [:b ::mem/char] [:a
;;            ::mem/char]]])

(defalias :raylib-clj.raylib/Color
          [:coffi.mem/struct
           [[:r :coffi.mem/char] [:g :coffi.mem/char] [:b :coffi.mem/char]
            [:a :coffi.mem/char]]])

(defalias :raylib-clj.raylib/Rectangle
          [:coffi.mem/struct
           [[:x :coffi.mem/float] [:y :coffi.mem/float]
            [:width :coffi.mem/float] [:height :coffi.mem/float]]])

;; (defalias :raylib-clj.raylib/Image
;;   [:coffi.mem/struct
;;    [[:*data :coffi.mem/void] [:width :coffi.mem/int]
;;     [:height :coffi.mem/int] [:mipmaps :coffi.mem/int]
;;     [:format :coffi.mem/int]]])

;; Constants

(def raywhite {:r 245, :g 245, :b 245, :a 255})

;; Enums ----------------------------------------------------------------------

(defmacro defenum
  [& args]
  (loop [args (partition 3 args)
         code []
         val nil]
    (if-let [[[name doc v] & args] args]
      (recur args
             (conj code `(def ~name ~doc ~(or v val)))
             (if v (inc v) (inc val)))
      `(do ~@(apply list code)))))

;; System/Window config flags
(defenum
  flag-vsync-hint
  "Set to try enabling V-Sync on GPU"
  64
  flag-fullscreen-mode
  "Set to run program in fullscreen"
  2
  flag-window-resizable
  "Set to allow resizable window"
  4
  flag-window-undecorated
  "Set to disable window decoration (frame and buttons)"
  8
  flag-window-hidden
  "Set to hide window"
  128
  flag-window-minimized
  "Set to minimize window (iconify)"
  512
  flag-window-maximized
  "Set to maximize window (expanded to monitor)"
  1024
  flag-window-unfocused
  "Set to window non focused"
  2048
  flag-window-topmost
  "Set to window always on top"
  4096
  flag-window-always-run
  "Set to allow windows running while minimized"
  256
  flag-window-transparent
  "Set to allow transparent framebuffer"
  16
  flag-window-highdpi
  "Set to support HighDPI"
  8192
  flag-window-mouse-passthrough
  "Set to support mouse passthrough, only supported when FLAG_WINDOW_UNDECORATED"
  16384
  flag-msaa-4-x-hint
  "Set to try enabling MSAA 4X"
  32 flag-interlaced-hint
  "Set to try enabling interlaced video format (for V3D)" 65536)

;; Trave log level
(defenum
  log-all
  "Display all logs"
  0
  log-trace
  "Trace logging, intended for internal use only"
  nil
  log-debug
  "Debug logging, used for internal debugging, it should be disabled on release builds"
  nil
  log-info
  "Info logging, used for program execution info"
  nil
  log-warning
  "Warning logging, used on recoverable failures"
  nil
  log-error
  "Error logging, used on unrecoverable failures"
  nil
  log-fatal
  "Fatal logging, used to abort program: exit(EXIT_FAILURE)"
  nil
  log-none
  "Disable logging"
  nil)

;; Keyboard keys (US keyboard layout)
(defenum
  key-null
  "Key: NULL, used for no key pressed"
  0
  key-apostrophe
  "Key: '"
  39
  key-comma
  "Key: ,"
  44
  key-minus
  "Key: -"
  45
  key-period
  "Key: ."
  46
  key-slash
  "Key: /"
  47
  key-zero
  "Key: 0"
  48
  key-one
  "Key: 1"
  49
  key-two
  "Key: 2"
  50
  key-three
  "Key: 3"
  51
  key-four
  "Key: 4"
  52
  key-five
  "Key: 5"
  53
  key-six
  "Key: 6"
  54
  key-seven
  "Key: 7"
  55
  key-eight
  "Key: 8"
  56
  key-nine
  "Key: 9"
  57
  key-semicolon
  "Key: ;"
  59
  key-equal
  "Key: ="
  61
  key-a
  "Key: A | a"
  65
  key-b
  "Key: B | b"
  66
  key-c
  "Key: C | c"
  67
  key-d
  "Key: D | d"
  68
  key-e
  "Key: E | e"
  69
  key-f
  "Key: F | f"
  70
  key-g
  "Key: G | g"
  71
  key-h
  "Key: H | h"
  72
  key-i
  "Key: I | i"
  73
  key-j
  "Key: J | j"
  74
  key-k
  "Key: K | k"
  75
  key-l
  "Key: L | l"
  76
  key-m
  "Key: M | m"
  77
  key-n
  "Key: N | n"
  78
  key-o
  "Key: O | o"
  79
  key-p
  "Key: P | p"
  80
  key-q
  "Key: Q | q"
  81
  key-r
  "Key: R | r"
  82
  key-s
  "Key: S | s"
  83
  key-t
  "Key: T | t"
  84
  key-u
  "Key: U | u"
  85
  key-v
  "Key: V | v"
  86
  key-w
  "Key: W | w"
  87
  key-x
  "Key: X | x"
  88
  key-y
  "Key: Y | y"
  89
  key-z
  "Key: Z | z"
  90
  key-left-bracket
  "Key: ["
  91
  key-backslash
  "Key: \"\\\""
  92
  key-right-bracket
  "Key: ]"
  93
  key-grave
  "Key: `"
  96
  key-space
  "Key: Space"
  32
  key-escape
  "Key: Esc"
  256
  key-enter
  "Key: Enter"
  257
  key-tab
  "Key: Tab"
  258
  key-backspace
  "Key: Backspace"
  259
  key-insert
  "Key: Ins"
  260
  key-delete
  "Key: Del"
  261
  key-right
  "Key: Cursor right"
  262
  key-left
  "Key: Cursor left"
  263
  key-down
  "Key: Cursor down"
  264
  key-up
  "Key: Cursor up"
  265
  key-page-up
  "Key: Page up"
  266
  key-page-down
  "Key: Page down"
  267
  key-home
  "Key: Home"
  268
  key-end
  "Key: End"
  269
  key-caps-lock
  "Key: Caps lock"
  280
  key-scroll-lock
  "Key: Scroll down"
  281
  key-num-lock
  "Key: Num lock"
  282
  key-print-screen
  "Key: Print screen"
  283
  key-pause
  "Key: Pause"
  284
  key-f-1
  "Key: F1"
  290
  key-f-2
  "Key: F2"
  291
  key-f-3
  "Key: F3"
  292
  key-f-4
  "Key: F4"
  293
  key-f-5
  "Key: F5"
  294
  key-f-6
  "Key: F6"
  295
  key-f-7
  "Key: F7"
  296
  key-f-8
  "Key: F8"
  297
  key-f-9
  "Key: F9"
  298
  key-f-10
  "Key: F10"
  299
  key-f-11
  "Key: F11"
  300
  key-f-12
  "Key: F12"
  301
  key-left-shift
  "Key: Shift left"
  340
  key-left-control
  "Key: Control left"
  341
  key-left-alt
  "Key: Alt left"
  342
  key-left-super
  "Key: Super left"
  343
  key-right-shift
  "Key: Shift right"
  344
  key-right-control
  "Key: Control right"
  345
  key-right-alt
  "Key: Alt right"
  346
  key-right-super
  "Key: Super right"
  347
  key-kb-menu
  "Key: KB menu"
  348
  key-kp-0
  "Key: Keypad 0"
  320
  key-kp-1
  "Key: Keypad 1"
  321
  key-kp-2
  "Key: Keypad 2"
  322
  key-kp-3
  "Key: Keypad 3"
  323
  key-kp-4
  "Key: Keypad 4"
  324
  key-kp-5
  "Key: Keypad 5"
  325
  key-kp-6
  "Key: Keypad 6"
  326
  key-kp-7
  "Key: Keypad 7"
  327
  key-kp-8
  "Key: Keypad 8"
  328
  key-kp-9
  "Key: Keypad 9"
  329
  key-kp-decimal
  "Key: Keypad ."
  330
  key-kp-divide
  "Key: Keypad /"
  331
  key-kp-multiply
  "Key: Keypad *"
  332
  key-kp-subtract
  "Key: Keypad -"
  333
  key-kp-add
  "Key: Keypad +"
  334
  key-kp-enter
  "Key: Keypad Enter"
  335
  key-kp-equal
  "Key: Keypad ="
  336
  key-back
  "Key: Android back button"
  4
  key-menu
  "Key: Android menu button"
  82
  key-volume-up
  "Key: Android volume up button"
  24 key-volume-down
  "Key: Android volume down button" 25)

;; Mouse buttons
(defenum mouse-button-left
         "Mouse button left"
         0
         mouse-button-right
         "Mouse button right"
         1
         mouse-button-middle
         "Mouse button middle (pressed wheel)"
         2
         mouse-button-side
         "Mouse button side (advanced mouse device)"
         3
         mouse-button-extra
         "Mouse button extra (advanced mouse device)"
         4
         mouse-button-forward
         "Mouse button forward (advanced mouse device)"
         5 mouse-button-back
         "Mouse button back (advanced mouse device)" 6)

;; Mouse cursor
(defenum mouse-cursor-default
         "Default pointer shape"
         0
         mouse-cursor-arrow
         "Arrow shape"
         1
         mouse-cursor-ibeam
         "Text writing cursor shape"
         2
         mouse-cursor-crosshair
         "Cross shape"
         3
         mouse-cursor-pointing-hand
         "Pointing hand cursor"
         4
         mouse-cursor-resize-ew
         "Horizontal resize/move arrow shape"
         5
         mouse-cursor-resize-ns
         "Vertical resize/move arrow shape"
         6
         mouse-cursor-resize-nwse
         "Top-left to bottom-right diagonal resize/move arrow shape"
         7
         mouse-cursor-resize-nesw
         "The top-right to bottom-left diagonal resize/move arrow shape"
         8
         mouse-cursor-resize-all
         "The omni-directional resize/move cursor shape"
         9 mouse-cursor-not-allowed
         "The operation-not-allowed shape" 10)

;; Gamepad buttons
(defenum
  gamepad-button-unknown
  "Unknown button, just for error checking"
  0
  gamepad-button-left-face-up
  "Gamepad left DPAD up button"
  nil
  gamepad-button-left-face-right
  "Gamepad left DPAD right button"
  nil
  gamepad-button-left-face-down
  "Gamepad left DPAD down button"
  nil
  gamepad-button-left-face-left
  "Gamepad left DPAD left button"
  nil
  gamepad-button-right-face-up
  "Gamepad right button up (i.e. PS3: Triangle, Xbox: Y)"
  nil
  gamepad-button-right-face-right
  "Gamepad right button right (i.e. PS3: Square, Xbox: X)"
  nil
  gamepad-button-right-face-down
  "Gamepad right button down (i.e. PS3: Cross, Xbox: A)"
  nil
  gamepad-button-right-face-left
  "Gamepad right button left (i.e. PS3: Circle, Xbox: B)"
  nil
  gamepad-button-left-trigger-1
  "Gamepad top/back trigger left (first), it could be a trailing button"
  nil
  gamepad-button-left-trigger-2
  "Gamepad top/back trigger left (second), it could be a trailing button"
  nil
  gamepad-button-right-trigger-1
  "Gamepad top/back trigger right (one), it could be a trailing button"
  nil
  gamepad-button-right-trigger-2
  "Gamepad top/back trigger right (second), it could be a trailing button"
  nil
  gamepad-button-middle-left
  "Gamepad center buttons, left one (i.e. PS3: Select)"
  nil
  gamepad-button-middle
  "Gamepad center buttons, middle one (i.e. PS3: PS, Xbox: XBOX)"
  nil
  gamepad-button-middle-right
  "Gamepad center buttons, right one (i.e. PS3: Start)"
  nil
  gamepad-button-left-thumb
  "Gamepad joystick pressed button left"
  nil
  gamepad-button-right-thumb
  "Gamepad joystick pressed button right"
  nil)

;; Gamepad axis
(defenum gamepad-axis-left-x
         "Gamepad left stick X axis"
         0
         gamepad-axis-left-y
         "Gamepad left stick Y axis"
         1
         gamepad-axis-right-x
         "Gamepad right stick X axis"
         2
         gamepad-axis-right-y
         "Gamepad right stick Y axis"
         3
         gamepad-axis-left-trigger
         "Gamepad back trigger left, pressure level: [1..-1]"
         4 gamepad-axis-right-trigger
         "Gamepad back trigger right, pressure level: [1..-1]" 5)

;; Material map index
(defenum material-map-albedo
         "Albedo material (same as: MATERIAL_MAP_DIFFUSE)"
         0
         material-map-metalness
         "Metalness material (same as: MATERIAL_MAP_SPECULAR)"
         nil
         material-map-normal
         "Normal material"
         nil
         material-map-roughness
         "Roughness material"
         nil
         material-map-occlusion
         "Ambient occlusion material"
         nil
         material-map-emission
         "Emission material"
         nil
         material-map-height
         "Heightmap material"
         nil
         material-map-cubemap
         "Cubemap material (NOTE: Uses GL_TEXTURE_CUBE_MAP)"
         nil
         material-map-irradiance
         "Irradiance material (NOTE: Uses GL_TEXTURE_CUBE_MAP)"
         nil
         material-map-prefilter
         "Prefilter material (NOTE: Uses GL_TEXTURE_CUBE_MAP)"
         nil
         material-map-brdf
         "Brdf material"
         nil)

;; Shader location index
(defenum
  shader-loc-vertex-position
  "Shader location: vertex attribute: position"
  0
  shader-loc-vertex-texcoord-01
  "Shader location: vertex attribute: texcoord01"
  nil
  shader-loc-vertex-texcoord-02
  "Shader location: vertex attribute: texcoord02"
  nil
  shader-loc-vertex-normal
  "Shader location: vertex attribute: normal"
  nil
  shader-loc-vertex-tangent
  "Shader location: vertex attribute: tangent"
  nil
  shader-loc-vertex-color
  "Shader location: vertex attribute: color"
  nil
  shader-loc-matrix-mvp
  "Shader location: matrix uniform: model-view-projection"
  nil
  shader-loc-matrix-view
  "Shader location: matrix uniform: view (camera transform)"
  nil
  shader-loc-matrix-projection
  "Shader location: matrix uniform: projection"
  nil
  shader-loc-matrix-model
  "Shader location: matrix uniform: model (transform)"
  nil
  shader-loc-matrix-normal
  "Shader location: matrix uniform: normal"
  nil
  shader-loc-vector-view
  "Shader location: vector uniform: view"
  nil
  shader-loc-color-diffuse
  "Shader location: vector uniform: diffuse color"
  nil
  shader-loc-color-specular
  "Shader location: vector uniform: specular color"
  nil
  shader-loc-color-ambient
  "Shader location: vector uniform: ambient color"
  nil
  shader-loc-map-albedo
  "Shader location: sampler2d texture: albedo (same as: SHADER_LOC_MAP_DIFFUSE)"
  nil
  shader-loc-map-metalness
  "Shader location: sampler2d texture: metalness (same as: SHADER_LOC_MAP_SPECULAR)"
  nil
  shader-loc-map-normal
  "Shader location: sampler2d texture: normal"
  nil
  shader-loc-map-roughness
  "Shader location: sampler2d texture: roughness"
  nil
  shader-loc-map-occlusion
  "Shader location: sampler2d texture: occlusion"
  nil
  shader-loc-map-emission
  "Shader location: sampler2d texture: emission"
  nil
  shader-loc-map-height
  "Shader location: sampler2d texture: height"
  nil
  shader-loc-map-cubemap
  "Shader location: samplerCube texture: cubemap"
  nil
  shader-loc-map-irradiance
  "Shader location: samplerCube texture: irradiance"
  nil
  shader-loc-map-prefilter
  "Shader location: samplerCube texture: prefilter"
  nil
  shader-loc-map-brdf
  "Shader location: sampler2d texture: brdf"
  nil)

;; Shader uniform data type
(defenum shader-uniform-float
         "Shader uniform type: float"
         0
         shader-uniform-vec-2
         "Shader uniform type: vec2 (2 float)"
         nil
         shader-uniform-vec-3
         "Shader uniform type: vec3 (3 float)"
         nil
         shader-uniform-vec-4
         "Shader uniform type: vec4 (4 float)"
         nil
         shader-uniform-int
         "Shader uniform type: int"
         nil
         shader-uniform-ivec-2
         "Shader uniform type: ivec2 (2 int)"
         nil
         shader-uniform-ivec-3
         "Shader uniform type: ivec3 (3 int)"
         nil
         shader-uniform-ivec-4
         "Shader uniform type: ivec4 (4 int)"
         nil
         shader-uniform-sampler-2-d
         "Shader uniform type: sampler2d"
         nil)

;; Shader attribute data types
(defenum shader-attrib-float
         "Shader attribute type: float"
         0
         shader-attrib-vec-2
         "Shader attribute type: vec2 (2 float)"
         nil
         shader-attrib-vec-3
         "Shader attribute type: vec3 (3 float)"
         nil
         shader-attrib-vec-4
         "Shader attribute type: vec4 (4 float)"
         nil)

;; Pixel formats
(defenum
  pixelformat-uncompressed-grayscale
  "8 bit per pixel (no alpha)"
  1
  pixelformat-uncompressed-gray-alpha
  "8*2 bpp (2 channels)"
  nil
  pixelformat-uncompressed-r-5-g-6-b-5
  "16 bpp"
  nil
  pixelformat-uncompressed-r-8-g-8-b-8
  "24 bpp"
  nil
  pixelformat-uncompressed-r-5-g-5-b-5-a-1
  "16 bpp (1 bit alpha)"
  nil
  pixelformat-uncompressed-r-4-g-4-b-4-a-4
  "16 bpp (4 bit alpha)"
  nil
  pixelformat-uncompressed-r-8-g-8-b-8-a-8
  "32 bpp"
  nil
  pixelformat-uncompressed-r-32
  "32 bpp (1 channel - float)"
  nil
  pixelformat-uncompressed-r-32-g-32-b-32
  "32*3 bpp (3 channels - float)"
  nil
  pixelformat-uncompressed-r-32-g-32-b-32-a-32
  "32*4 bpp (4 channels - float)"
  nil
  pixelformat-compressed-dxt-1-rgb
  "4 bpp (no alpha)"
  nil
  pixelformat-compressed-dxt-1-rgba
  "4 bpp (1 bit alpha)"
  nil
  pixelformat-compressed-dxt-3-rgba
  "8 bpp"
  nil
  pixelformat-compressed-dxt-5-rgba
  "8 bpp"
  nil
  pixelformat-compressed-etc-1-rgb
  "4 bpp"
  nil
  pixelformat-compressed-etc-2-rgb
  "4 bpp"
  nil
  pixelformat-compressed-etc-2-eac-rgba
  "8 bpp"
  nil
  pixelformat-compressed-pvrt-rgb
  "4 bpp"
  nil
  pixelformat-compressed-pvrt-rgba
  "4 bpp"
  nil
  pixelformat-compressed-astc-4x-4-rgba
  "8 bpp"
  nil
  pixelformat-compressed-astc-8x-8-rgba
  "2 bpp"
  nil)

;; Texture parameters: filter mode
(defenum texture-filter-point
         "No filter, just pixel approximation"
         0
         texture-filter-bilinear
         "Linear filtering"
         nil
         texture-filter-trilinear
         "Trilinear filtering (linear with mipmaps)"
         nil
         texture-filter-anisotropic-4-x
         "Anisotropic filtering 4x"
         nil
         texture-filter-anisotropic-8-x
         "Anisotropic filtering 8x"
         nil
         texture-filter-anisotropic-16-x
         "Anisotropic filtering 16x"
         nil)

;; Texture parameters: wrap model
(defenum texture-wrap-repeat
         "Repeats texture in tiled mode"
         0
         texture-wrap-clamp
         "Clamps texture to edge pixel in tiled mode"
         nil
         texture-wrap-mirror-repeat
         "Mirrors and repeats the texture in tiled mode"
         nil
         texture-wrap-mirror-clamp
         "Mirrors and clamps to border the texture in tiled mode"
         nil)

;; Cubemap layouts
(defenum cubemap-layout-auto-detect
         "Automatically detect layout type"
         0
         cubemap-layout-line-vertical
         "Layout is defined by a vertical line with faces"
         nil
         cubemap-layout-line-horizontal
         "Layout is defined by an horizontal line with faces"
         nil
         cubemap-layout-cross-three-by-four
         "Layout is defined by a 3x4 cross with cubemap faces"
         nil
         cubemap-layout-cross-four-by-three
         "Layout is defined by a 4x3 cross with cubemap faces"
         nil
         cubemap-layout-panorama
         "Layout is defined by a panorama image (equirectangular map)"
         nil)

;; Font type, defines generation method
(defenum font-default
         "Default font generation, anti-aliased"
         0
         font-bitmap
         "Bitmap font generation, no anti-aliasing"
         nil
         font-sdf
         "SDF font generation, requires external shader"
         nil)

;; Color blending modes (pre-defined)
(defenum
  blend-alpha
  "Blend textures considering alpha (default)"
  0
  blend-additive
  "Blend textures adding colors"
  nil
  blend-multiplied
  "Blend textures multiplying colors"
  nil
  blend-add-colors
  "Blend textures adding colors (alternative)"
  nil
  blend-subtract-colors
  "Blend textures subtracting colors (alternative)"
  nil
  blend-alpha-premultiply
  "Blend premultiplied textures considering alpha"
  nil
  blend-custom
  "Blend textures using custom src/dst factors (use rlSetBlendMode())"
  nil
  blend-custom-separate
  "Blend textures using custom rgb/alpha separate src/dst factors (use rlSetBlendModeSeparate())"
  nil)

;; Gesture
(defenum gesture-none
         "No gesture"
         0
         gesture-tap
         "Tap gesture"
         1
         gesture-doubletap
         "Double tap gesture"
         2
         gesture-hold
         "Hold gesture"
         4
         gesture-drag
         "Drag gesture"
         8
         gesture-swipe-right
         "Swipe right gesture"
         16
         gesture-swipe-left
         "Swipe left gesture"
         32
         gesture-swipe-up
         "Swipe up gesture"
         64
         gesture-swipe-down
         "Swipe down gesture"
         128
         gesture-pinch-in
         "Pinch in gesture"
         256 gesture-pinch-out
         "Pinch out gesture" 512)

;; Camera system modes
(defenum camera-custom
         "Custom camera"
         0
         camera-free
         "Free camera"
         nil
         camera-orbital
         "Orbital camera"
         nil
         camera-first-person
         "First person camera"
         nil
         camera-third-person
         "Third person camera"
         nil)

;; Camera projection
(defenum camera-perspective
         "Perspective projection"
         0 camera-orthographic
         "Orthographic projection" nil)

;; N-patch layout
(defenum npatch-nine-patch
         "Npatch layout: 3x3 tiles"
         0
         npatch-three-patch-vertical
         "Npatch layout: 1x3 tiles"
         nil
         npatch-three-patch-horizontal
         "Npatch layout: 3x1 tiles"
         nil)


;; Functions
;; -------------------------------------------------------------------

;; Window

(defcfn init-window
        "Initialize window"
        InitWindow
        [::mem/int ::mem/int ::mem/c-string]
        ::mem/void)

(defcfn close-window "Close window" CloseWindow [] ::mem/void)

(defcfn window-should-close? "Window should close?" WindowShouldClose [] ::bool)

(defcfn is-window-ready?
        "Check if window has been initialized successfully"
        IsWindowReady
        []
        ::bool)

(defcfn is-window-fullscreen?
        "Check if window is currently fullscreen"
        IsWindowFullscreen
        []
        ::bool)

(defcfn is-window-hidden?
        "Check if window is currently hidden (only PLATFORM_DESKTOP)"
        IsWindowHidden
        []
        ::bool)

(defcfn is-window-minimized?
        "Check if window is currently minimized (only PLATFORM_DESKTOP)"
        IsWindowMinimized
        []
        ::bool)

(defcfn is-window-maximized?
        "Check if window is currently maximized (only PLATFORM_DESKTOP)"
        IsWindowMaximized
        []
        ::bool)

(defcfn is-window-focused?
        "Check if window is currently focused (only PLATFORM_DESKTOP)"
        IsWindowFocused
        []
        ::bool)

(defcfn is-window-resized?
        "Check if window has been resized last frame"
        IsWindowResized
        []
        ::bool)

;; RLAPI bool IsWindowState(unsigned int flag);                      // Check
;; if
;; one specific window flag is enabled
(defcfn is-window-state?
        "Check if one specific window flag is enabled"
        IsWindowState
        [::int]
        ::bool)

;; RLAPI void SetWindowState(unsigned int flags);                    // Set
;; window configuration state using flags (only PLATFORM_DESKTOP)
;; RLAPI void ClearWindowState(unsigned int flags);                  // Clear
;; window configuration state flags
;; RLAPI void ToggleFullscreen(void);                                // Toggle
;; window state: fullscreen/windowed (only PLATFORM_DESKTOP)
;; RLAPI void MaximizeWindow(void);                                  // Set
;; window state: maximized, if resizable (only PLATFORM_DESKTOP)
;; RLAPI void MinimizeWindow(void);                                  // Set
;; window state: minimized, if resizable (only PLATFORM_DESKTOP)
;; RLAPI void RestoreWindow(void);                                   // Set
;; window state: not minimized/maximized (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowIcon(Image image);                            // Set
;; icon
;; for window (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowTitle(const char *title);                     // Set
;; title for window (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowPosition(int x, int y);                       // Set
;; window position on screen (only PLATFORM_DESKTOP)
;; RLAPI void SetWindowMonitor(int monitor);                         // Set
;; monitor for the current window (fullscreen mode)
;; RLAPI void SetWindowMinSize(int width, int height);               // Set
;; window minimum dimensions (for FLAG_WINDOW_RESIZABLE)
;; RLAPI void SetWindowSize(int width, int height);                  // Set
;; window dimensions
;; RLAPI void SetWindowOpacity(float opacity);                       // Set
;; window opacity [0.0f..1.0f] (only PLATFORM_DESKTOP)
;; RLAPI void *GetWindowHandle(void);                                // Get
;; native window handle
;; RLAPI int GetScreenWidth(void);                                   // Get
;; current screen width
;; RLAPI int GetScreenHeight(void);                                  // Get
;; current screen height
;; RLAPI int GetRenderWidth(void);                                   // Get
;; current render width (it considers HiDPI)
;; RLAPI int GetRenderHeight(void);                                  // Get
;; current render height (it considers HiDPI)
;; RLAPI int GetMonitorCount(void);                                  // Get
;; number of connected monitors
;; RLAPI int GetCurrentMonitor(void);                                // Get
;; current connected monitor
;; RLAPI Vector2 GetMonitorPosition(int monitor);                    // Get
;; specified monitor position
;; RLAPI int GetMonitorWidth(int monitor);                           // Get
;; specified monitor width (current video mode used by monitor)
;; RLAPI int GetMonitorHeight(int monitor);                          // Get
;; specified monitor height (current video mode used by monitor)
;; RLAPI int GetMonitorPhysicalWidth(int monitor);                   // Get
;; specified monitor physical width in millimetres
;; RLAPI int GetMonitorPhysicalHeight(int monitor);                  // Get
;; specified monitor physical height in millimetres
;; RLAPI int GetMonitorRefreshRate(int monitor);                     // Get
;; specified monitor refresh rate
;; RLAPI Vector2 GetWindowPosition(void);                            // Get
;; window position XY on monitor
;; RLAPI Vector2 GetWindowScaleDPI(void);                            // Get
;; window scale DPI factor
;; RLAPI const char *GetMonitorName(int monitor);                    // Get the
;; human-readable, UTF-8 encoded name of the primary monitor
;; RLAPI void SetClipboardText(const char *text);                    // Set
;; clipboard text content
;; RLAPI const char *GetClipboardText(void);                         // Get
;; clipboard text content
;; RLAPI void EnableEventWaiting(void);                              // Enable
;; waiting for events on EndDrawing(), no automatic event polling
;; RLAPI void DisableEventWaiting(void);                             // Disable
;; waiting for events on EndDrawing(), automatic events polling

(defcfn set-target-fps "Set target FPS" SetTargetFPS [::mem/int] ::mem/void)

(defcfn begin-drawing "Begin drawing" BeginDrawing [] ::mem/void)

(defcfn end-drawing "End drawing" EndDrawing [] ::mem/void)

(defcfn clear-background
        "Clear the background"
        ClearBackground
        [::Color]
        ::mem/void)

(defcfn get-random-value
        "Get random value"
        GetRandomValue
        [::mem/int ::mem/int]
        ::mem/int)
