(defcfn init-window
        "Initialize window and OpenGL context"
        "InitWindow"
        [::mem/int ::mem/int ::mem/c-string]
        ::mem/void)

(defcfn window-should-close?
        "Check if KEY_ESCAPE pressed or Close icon pressed"
        "WindowShouldClose"
        []
        ::bool)

(defcfn close-window
        "Close window and unload OpenGL context"
        "CloseWindow"
        []
        ::mem/void)

(defcfn is-window-ready?
        "Check if window has been initialized successfully"
        "IsWindowReady"
        []
        ::bool)

(defcfn is-window-fullscreen?
        "Check if window is currently fullscreen"
        "IsWindowFullscreen"
        []
        ::bool)

(defcfn is-window-hidden?
        "Check if window is currently hidden (only PLATFORM_DESKTOP)"
        "IsWindowHidden"
        []
        ::bool)

(defcfn is-window-minimized?
        "Check if window is currently minimized (only PLATFORM_DESKTOP)"
        "IsWindowMinimized"
        []
        ::bool)

(defcfn is-window-maximized?
        "Check if window is currently maximized (only PLATFORM_DESKTOP)"
        "IsWindowMaximized"
        []
        ::bool)

(defcfn is-window-focused?
        "Check if window is currently focused (only PLATFORM_DESKTOP)"
        "IsWindowFocused"
        []
        ::bool)

(defcfn is-window-resized?
        "Check if window has been resized last frame"
        "IsWindowResized"
        []
        ::bool)

(defcfn is-window-state?
        "Check if one specific window flag is enabled"
        "IsWindowState"
        [::unsigned-int]
        ::bool)

(defcfn set-window-state
        "Set window configuration state using flags (only PLATFORM_DESKTOP)"
        "SetWindowState"
        [::unsigned-int]
        ::mem/void)

(defcfn clear-window-state
        "Clear window configuration state flags"
        "ClearWindowState"
        [::unsigned-int]
        ::mem/void)

(defcfn toggle-fullscreen
        "Toggle window state: fullscreen/windowed (only PLATFORM_DESKTOP)"
        "ToggleFullscreen"
        []
        ::mem/void)

(defcfn maximize-window
        "Set window state: maximized, if resizable (only PLATFORM_DESKTOP)"
        "MaximizeWindow"
        []
        ::mem/void)

(defcfn minimize-window
        "Set window state: minimized, if resizable (only PLATFORM_DESKTOP)"
        "MinimizeWindow"
        []
        ::mem/void)

(defcfn restore-window
        "Set window state: not minimized/maximized (only PLATFORM_DESKTOP)"
        "RestoreWindow"
        []
        ::mem/void)

(defcfn set-window-icon
        "Set icon for window (only PLATFORM_DESKTOP)"
        "SetWindowIcon"
        [::Image]
        ::mem/void)

(defcfn set-window-title
        "Set title for window (only PLATFORM_DESKTOP)"
        "SetWindowTitle"
        [::mem/c-string]
        ::mem/void)

(defcfn set-window-position
        "Set window position on screen (only PLATFORM_DESKTOP)"
        "SetWindowPosition"
        [::mem/int ::mem/int]
        ::mem/void)

(defcfn set-window-monitor
        "Set monitor for the current window (fullscreen mode)"
        "SetWindowMonitor"
        [::mem/int]
        ::mem/void)

(defcfn set-window-min-size
        "Set window minimum dimensions (for FLAG_WINDOW_RESIZABLE)"
        "SetWindowMinSize"
        [::mem/int ::mem/int]
        ::mem/void)

(defcfn set-window-size
        "Set window dimensions"
        "SetWindowSize"
        [::mem/int ::mem/int]
        ::mem/void)

(defcfn set-window-opacity
        "Set window opacity [0.0f..1.0f] (only PLATFORM_DESKTOP)"
        "SetWindowOpacity"
        [::mem/float]
        ::mem/void)

(defcfn get-window-handle
        "Get native window handle"
        "GetWindowHandle"
        []
        ::mem/pointer)

(defcfn get-screen-width
        "Get current screen width"
        "GetScreenWidth"
        []
        ::mem/int)

(defcfn get-screen-height
        "Get current screen height"
        "GetScreenHeight"
        []
        ::mem/int)

(defcfn get-render-width
        "Get current render width (it considers HiDPI)"
        "GetRenderWidth"
        []
        ::mem/int)

(defcfn get-render-height
        "Get current render height (it considers HiDPI)"
        "GetRenderHeight"
        []
        ::mem/int)

(defcfn get-monitor-count
        "Get number of connected monitors"
        "GetMonitorCount"
        []
        ::mem/int)

(defcfn get-current-monitor
        "Get current connected monitor"
        "GetCurrentMonitor"
        []
        ::mem/int)

(defcfn get-monitor-position
        "Get specified monitor position"
        "GetMonitorPosition"
        [::mem/int]
        ::Vector2)

(defcfn get-monitor-width
        "Get specified monitor width (current video mode used by monitor)"
        "GetMonitorWidth"
        [::mem/int]
        ::mem/int)

(defcfn get-monitor-height
        "Get specified monitor height (current video mode used by monitor)"
        "GetMonitorHeight"
        [::mem/int]
        ::mem/int)

(defcfn get-monitor-physical-width
        "Get specified monitor physical width in millimetres"
        "GetMonitorPhysicalWidth"
        [::mem/int]
        ::mem/int)

(defcfn get-monitor-physical-height
        "Get specified monitor physical height in millimetres"
        "GetMonitorPhysicalHeight"
        [::mem/int]
        ::mem/int)

(defcfn get-monitor-refresh-rate
        "Get specified monitor refresh rate"
        "GetMonitorRefreshRate"
        [::mem/int]
        ::mem/int)

(defcfn get-window-position
        "Get window position XY on monitor"
        "GetWindowPosition"
        []
        ::Vector2)

(defcfn get-window-scale-dpi
        "Get window scale DPI factor"
        "GetWindowScaleDPI"
        []
        ::Vector2)

(defcfn get-monitor-name
        "Get the human-readable, UTF-8 encoded name of the primary monitor"
        "GetMonitorName"
        [::mem/int]
        ::mem/c-string)

(defcfn set-clipboard-text
        "Set clipboard text content"
        "SetClipboardText"
        [::mem/c-string]
        ::mem/void)

(defcfn get-clipboard-text
        "Get clipboard text content"
        "GetClipboardText"
        []
        ::mem/c-string)

(defcfn enable-event-waiting
        "Enable waiting for events on EndDrawing(), no automatic event polling"
        "EnableEventWaiting"
        []
        ::mem/void)

(defcfn disable-event-waiting
        "Disable waiting for events on EndDrawing(), automatic events polling"
        "DisableEventWaiting"
        []
        ::mem/void)

(defcfn swap-screen-buffer
        "Swap back buffer with front buffer (screen drawing)"
        "SwapScreenBuffer"
        []
        ::mem/void)

(defcfn poll-input-events
        "Register all input events"
        "PollInputEvents"
        []
        ::mem/void)

(defcfn wait-time
        "Wait for some time (halt program execution)"
        "WaitTime"
        [::mem/double]
        ::mem/void)

(defcfn show-cursor "Shows cursor" "ShowCursor" [] ::mem/void)

(defcfn hide-cursor "Hides cursor" "HideCursor" [] ::mem/void)

(defcfn is-cursor-hidden?
        "Check if cursor is not visible"
        "IsCursorHidden"
        []
        ::bool)

(defcfn enable-cursor
        "Enables cursor (unlock cursor)"
        "EnableCursor"
        []
        ::mem/void)

(defcfn disable-cursor
        "Disables cursor (lock cursor)"
        "DisableCursor"
        []
        ::mem/void)

(defcfn is-cursor-on-screen?
        "Check if cursor is on the screen"
        "IsCursorOnScreen"
        []
        ::bool)

(defcfn clear-background
        "Set background color (framebuffer clear color)"
        "ClearBackground"
        [::Color]
        ::mem/void)

(defcfn begin-drawing
        "Setup canvas (framebuffer) to start drawing"
        "BeginDrawing"
        []
        ::mem/void)

(defcfn end-drawing
        "End canvas drawing and swap buffers (double buffering)"
        "EndDrawing"
        []
        ::mem/void)

(defcfn begin-mode-2-d
        "Begin 2D mode with custom camera (2D)"
        "BeginMode2D"
        [::Camera2D]
        ::mem/void)

(defcfn end-mode-2-d
        "Ends 2D mode with custom camera"
        "EndMode2D"
        []
        ::mem/void)

(defcfn begin-mode-3-d
        "Begin 3D mode with custom camera (3D)"
        "BeginMode3D"
        [::Camera3D]
        ::mem/void)

(defcfn end-mode-3-d
        "Ends 3D mode and returns to default 2D orthographic mode"
        "EndMode3D"
        []
        ::mem/void)

(defcfn begin-texture-mode
        "Begin drawing to render texture"
        "BeginTextureMode"
        [::RenderTexture2D]
        ::mem/void)

(defcfn end-texture-mode
        "Ends drawing to render texture"
        "EndTextureMode"
        []
        ::mem/void)

(defcfn begin-shader-mode
        "Begin custom shader drawing"
        "BeginShaderMode"
        [::Shader]
        ::mem/void)

(defcfn end-shader-mode
        "End custom shader drawing (use default shader)"
        "EndShaderMode"
        []
        ::mem/void)

(defcfn begin-blend-mode
        "Begin blending mode (alpha, additive, multiplied, subtract, custom)"
        "BeginBlendMode"
        [::mem/int]
        ::mem/void)

(defcfn end-blend-mode
        "End blending mode (reset to default: alpha blending)"
        "EndBlendMode"
        []
        ::mem/void)

(defcfn begin-scissor-mode
        "Begin scissor mode (define screen area for following drawing)"
        "BeginScissorMode"
        [::mem/int ::mem/int ::mem/int ::mem/int]
        ::mem/void)

(defcfn end-scissor-mode "End scissor mode" "EndScissorMode" [] ::mem/void)

(defcfn begin-vr-stereo-mode
        "Begin stereo rendering (requires VR simulator)"
        "BeginVrStereoMode"
        [::VrStereoConfig]
        ::mem/void)

(defcfn end-vr-stereo-mode
        "End stereo rendering (requires VR simulator)"
        "EndVrStereoMode"
        []
        ::mem/void)

(defcfn load-vr-stereo-config
        "Load VR stereo config for VR simulator device parameters"
        "LoadVrStereoConfig"
        [::VrDeviceInfo]
        ::VrStereoConfig)

(defcfn unload-vr-stereo-config
        "Unload VR stereo config"
        "UnloadVrStereoConfig"
        [::VrStereoConfig]
        ::mem/void)

(defcfn load-shader
        "Load shader from files and bind default locations"
        "LoadShader"
        [::mem/c-string ::mem/c-string]
        ::Shader)

(defcfn load-shader-from-memory
        "Load shader from code strings and bind default locations"
        "LoadShaderFromMemory"
        [::mem/c-string ::mem/c-string]
        ::Shader)

(defcfn get-shader-location
        "Get shader uniform location"
        "GetShaderLocation"
        [::Shader ::mem/c-string]
        ::mem/int)

(defcfn get-shader-location-attrib
        "Get shader attribute location"
        "GetShaderLocationAttrib"
        [::Shader ::mem/c-string]
        ::mem/int)

(defcfn set-shader-value
        "Set shader uniform value"
        "SetShaderValue"
        [::Shader ::mem/int ::mem/pointer
         ::mem/int]
        ::mem/void)

(defcfn set-shader-value-v
        "Set shader uniform value vector"
        "SetShaderValueV"
        [::Shader ::mem/int ::mem/pointer
         ::mem/int ::mem/int]
        ::mem/void)

(defcfn set-shader-value-matrix
        "Set shader uniform value (matrix 4x4)"
        "SetShaderValueMatrix"
        [::Shader ::mem/int ::Matrix]
        ::mem/void)

(defcfn set-shader-value-texture
        "Set shader uniform value for texture (sampler2d)"
        "SetShaderValueTexture"
        [::Shader ::mem/int ::Texture2D]
        ::mem/void)

(defcfn unload-shader
        "Unload shader from GPU memory (VRAM)"
        "UnloadShader"
        [::Shader]
        ::mem/void)

(defcfn get-mouse-ray
        "Get a ray trace from mouse position"
        "GetMouseRay"
        [::Vector2 ::Camera]
        ::Ray)

(defcfn get-camera-matrix
        "Get camera transform matrix (view matrix)"
        "GetCameraMatrix"
        [::Camera]
        ::Matrix)

(defcfn get-camera-matrix-2-d
        "Get camera 2d transform matrix"
        "GetCameraMatrix2D"
        [::Camera2D]
        ::Matrix)

(defcfn get-world-to-screen
        "Get the screen space position for a 3d world space position"
        "GetWorldToScreen"
        [::Vector3 ::Camera]
        ::Vector2)

(defcfn get-screen-to-world-2-d
        "Get the world space position for a 2d camera screen space position"
        "GetScreenToWorld2D"
        [::Vector2 ::Camera2D]
        ::Vector2)

(defcfn get-world-to-screen-ex
        "Get size position for a 3d world space position"
        "GetWorldToScreenEx"
        [::Vector3 ::Camera ::mem/int
         ::mem/int]
        ::Vector2)

(defcfn get-world-to-screen-2-d
        "Get the screen space position for a 2d camera world space position"
        "GetWorldToScreen2D"
        [::Vector2 ::Camera2D]
        ::Vector2)

(defcfn set-target-fps
        "Set target FPS (maximum)"
        "SetTargetFPS"
        [::mem/int]
        ::mem/void)

(defcfn get-fps "Get current FPS" "GetFPS" [] ::mem/int)

(defcfn get-frame-time
        "Get time in seconds for last frame drawn (delta time)"
        "GetFrameTime"
        []
        ::mem/float)

(defcfn get-time
        "Get elapsed time in seconds since InitWindow()"
        "GetTime"
        []
        ::mem/double)

(defcfn get-random-value
        "Get a random value between min and max (both included)"
        "GetRandomValue"
        [::mem/int ::mem/int]
        ::mem/int)

(defcfn set-random-seed
        "Set the seed for the random number generator"
        "SetRandomSeed"
        [::unsigned-int]
        ::mem/void)

(defcfn
  take-screenshot
  "Takes a screenshot of current screen (filename extension defines format)"
  "TakeScreenshot"
  [::mem/c-string]
  ::mem/void)

(defcfn set-config-flags
        "Setup init configuration flags (view FLAGS)"
        "SetConfigFlags"
        [::unsigned-int]
        ::mem/void)

(defcfn set-trace-log-level
        "Set the current threshold (minimum) log level"
        "SetTraceLogLevel"
        [::mem/int]
        ::mem/void)

(defcfn mem-alloc
        "Internal memory allocator"
        "MemAlloc"
        [::unsigned-int]
        ::mem/pointer)

(defcfn mem-realloc
        "Internal memory reallocator"
        "MemRealloc"
        [::mem/pointer ::unsigned-int]
        ::mem/pointer)

(defcfn mem-free
        "Internal memory free"
        "MemFree"
        [::mem/pointer]
        ::mem/void)

(defcfn open-url
        "Open URL with default system browser (if available)"
        "OpenURL"
        [::mem/c-string]
        ::mem/void)

(defcfn load-file-data
        "Load file data as byte array (read)"
        "LoadFileData"
        [::mem/c-string
         [::mem/pointer ::unsigned-int]]
        ::mem/c-string)

(defcfn unload-file-data
        "Unload file data allocated by LoadFileData()"
        "UnloadFileData"
        [::mem/c-string]
        ::mem/void)

(defcfn save-file-data?
        "Save data to file from byte array (write), returns true on success"
        "SaveFileData"
        [::mem/c-string ::mem/pointer ::unsigned-int]
        ::bool)

(defcfn export-data-as-code?
        "Export data to code (.h), returns true on success"
        "ExportDataAsCode"
        [::mem/c-string ::unsigned-int
         ::mem/c-string]
        ::bool)

(defcfn load-file-text
        "Load text data from file (read), returns a '\\0' terminated string"
        "LoadFileText"
        [::mem/c-string]
        ::mem/c-string)

(defcfn unload-file-text
        "Unload file text data allocated by LoadFileText()"
        "UnloadFileText"
        [::mem/c-string]
        ::mem/void)

(defcfn
  save-file-text?
  "Save text data to file (write), string must be '\\0' terminated, returns true on success"
  "SaveFileText"
  [::mem/c-string ::mem/c-string]
  ::bool)

(defcfn file-exists?
        "Check if file exists"
        "FileExists"
        [::mem/c-string]
        ::bool)

(defcfn directory-exists?
        "Check if a directory path exists"
        "DirectoryExists"
        [::mem/c-string]
        ::bool)

(defcfn is-file-extension?
        "Check file extension (including point: .png, .wav)"
        "IsFileExtension"
        [::mem/c-string ::mem/c-string]
        ::bool)

(defcfn
  get-file-length
  "Get file length in bytes (NOTE: GetFileSize() conflicts with windows.h)"
  "GetFileLength"
  [::mem/c-string]
  ::mem/int)

(defcfn get-file-extension
        "Get pointer to extension for a filename string (includes dot: '.png')"
        "GetFileExtension"
        [::mem/c-string]
        ::mem/c-string)

(defcfn get-file-name
        "Get pointer to filename for a path string"
        "GetFileName"
        [::mem/c-string]
        ::mem/c-string)

(defcfn get-file-name-without-ext
        "Get filename string without extension (uses static string)"
        "GetFileNameWithoutExt"
        [::mem/c-string]
        ::mem/c-string)

(defcfn get-directory-path
        "Get full path for a given fileName with path (uses static string)"
        "GetDirectoryPath"
        [::mem/c-string]
        ::mem/c-string)

(defcfn get-prev-directory-path
        "Get previous directory path for a given path (uses static string)"
        "GetPrevDirectoryPath"
        [::mem/c-string]
        ::mem/c-string)

(defcfn get-working-directory
        "Get current working directory (uses static string)"
        "GetWorkingDirectory"
        []
        ::mem/c-string)

(defcfn get-application-directory
        "Get the directory if the running application (uses static string)"
        "GetApplicationDirectory"
        []
        ::mem/c-string)

(defcfn change-directory?
        "Change working directory, return true on success"
        "ChangeDirectory"
        [::mem/c-string]
        ::bool)

(defcfn is-path-file?
        "Check if a given path is a file or a directory"
        "IsPathFile"
        [::mem/c-string]
        ::bool)

(defcfn load-directory-files
        "Load directory filepaths"
        "LoadDirectoryFiles"
        [::mem/c-string]
        ::FilePathList)

(defcfn
  load-directory-files-ex
  "Load directory filepaths with extension filtering and recursive directory scan"
  "LoadDirectoryFilesEx"
  [::mem/c-string ::mem/c-string ::bool]
  ::FilePathList)

(defcfn unload-directory-files
        "Unload filepaths"
        "UnloadDirectoryFiles"
        [::FilePathList]
        ::mem/void)

(defcfn is-file-dropped?
        "Check if a file has been dropped into window"
        "IsFileDropped"
        []
        ::bool)

(defcfn load-dropped-files
        "Load dropped filepaths"
        "LoadDroppedFiles"
        []
        ::FilePathList)

(defcfn unload-dropped-files
        "Unload dropped filepaths"
        "UnloadDroppedFiles"
        [::FilePathList]
        ::mem/void)

(defcfn get-file-mod-time
        "Get file modification time (last write time)"
        "GetFileModTime"
        [::mem/c-string]
        ::mem/long)

(defcfn compress-data
        "Compress data (DEFLATE algorithm), memory must be MemFree()"
        "CompressData"
        [::mem/c-string ::mem/int [::mem/pointer ::mem/int]]
        ::mem/c-string)

(defcfn decompress-data
        "Decompress data (DEFLATE algorithm), memory must be MemFree()"
        "DecompressData"
        [::mem/c-string ::mem/int [::mem/pointer ::mem/int]]
        ::mem/c-string)

(defcfn encode-data-base-64
        "Encode data to Base64 string, memory must be MemFree()"
        "EncodeDataBase64"
        [::mem/c-string ::mem/int [::mem/pointer ::mem/int]]
        ::mem/c-string)

(defcfn decode-data-base-64
        "Decode Base64 string data, memory must be MemFree()"
        "DecodeDataBase64"
        [::mem/c-string [::mem/pointer ::mem/int]]
        ::mem/c-string)

(defcfn is-key-pressed?
        "Check if a key has been pressed once"
        "IsKeyPressed"
        [::mem/int]
        ::bool)

(defcfn is-key-down?
        "Check if a key is being pressed"
        "IsKeyDown"
        [::mem/int]
        ::bool)

(defcfn is-key-released?
        "Check if a key has been released once"
        "IsKeyReleased"
        [::mem/int]
        ::bool)

(defcfn is-key-up?
        "Check if a key is NOT being pressed"
        "IsKeyUp"
        [::mem/int]
        ::bool)

(defcfn set-exit-key
        "Set a custom key to exit program (default is ESC)"
        "SetExitKey"
        [::mem/int]
        ::mem/void)

(defcfn
  get-key-pressed
  "Get key pressed (keycode), call it multiple times for keys queued, returns 0 when the queue is empty"
  "GetKeyPressed"
  []
  ::mem/int)

(defcfn
  get-char-pressed
  "Get char pressed (unicode), call it multiple times for chars queued, returns 0 when the queue is empty"
  "GetCharPressed"
  []
  ::mem/int)

(defcfn is-gamepad-available?
        "Check if a gamepad is available"
        "IsGamepadAvailable"
        [::mem/int]
        ::bool)

(defcfn get-gamepad-name
        "Get gamepad internal name id"
        "GetGamepadName"
        [::mem/int]
        ::mem/c-string)

(defcfn is-gamepad-button-pressed?
        "Check if a gamepad button has been pressed once"
        "IsGamepadButtonPressed"
        [::mem/int ::mem/int]
        ::bool)

(defcfn is-gamepad-button-down?
        "Check if a gamepad button is being pressed"
        "IsGamepadButtonDown"
        [::mem/int ::mem/int]
        ::bool)

(defcfn is-gamepad-button-released?
        "Check if a gamepad button has been released once"
        "IsGamepadButtonReleased"
        [::mem/int ::mem/int]
        ::bool)

(defcfn is-gamepad-button-up?
        "Check if a gamepad button is NOT being pressed"
        "IsGamepadButtonUp"
        [::mem/int ::mem/int]
        ::bool)

(defcfn get-gamepad-button-pressed
        "Get the last gamepad button pressed"
        "GetGamepadButtonPressed"
        []
        ::mem/int)

(defcfn get-gamepad-axis-count
        "Get gamepad axis count for a gamepad"
        "GetGamepadAxisCount"
        [::mem/int]
        ::mem/int)

(defcfn get-gamepad-axis-movement
        "Get axis movement value for a gamepad axis"
        "GetGamepadAxisMovement"
        [::mem/int ::mem/int]
        ::mem/float)

(defcfn set-gamepad-mappings
        "Set internal gamepad mappings (SDL_GameControllerDB)"
        "SetGamepadMappings"
        [::mem/c-string]
        ::mem/int)

(defcfn is-mouse-button-pressed?
        "Check if a mouse button has been pressed once"
        "IsMouseButtonPressed"
        [::mem/int]
        ::bool)

(defcfn is-mouse-button-down?
        "Check if a mouse button is being pressed"
        "IsMouseButtonDown"
        [::mem/int]
        ::bool)

(defcfn is-mouse-button-released?
        "Check if a mouse button has been released once"
        "IsMouseButtonReleased"
        [::mem/int]
        ::bool)

(defcfn is-mouse-button-up?
        "Check if a mouse button is NOT being pressed"
        "IsMouseButtonUp"
        [::mem/int]
        ::bool)

(defcfn get-mouse-x "Get mouse position X" "GetMouseX" [] ::mem/int)

(defcfn get-mouse-y "Get mouse position Y" "GetMouseY" [] ::mem/int)

(defcfn get-mouse-position
        "Get mouse position XY"
        "GetMousePosition"
        []
        ::Vector2)

(defcfn get-mouse-delta
        "Get mouse delta between frames"
        "GetMouseDelta"
        []
        ::Vector2)

(defcfn set-mouse-position
        "Set mouse position XY"
        "SetMousePosition"
        [::mem/int ::mem/int]
        ::mem/void)

(defcfn set-mouse-offset
        "Set mouse offset"
        "SetMouseOffset"
        [::mem/int ::mem/int]
        ::mem/void)

(defcfn set-mouse-scale
        "Set mouse scaling"
        "SetMouseScale"
        [::mem/float ::mem/float]
        ::mem/void)

(defcfn get-mouse-wheel-move
        "Get mouse wheel movement for X or Y, whichever is larger"
        "GetMouseWheelMove"
        []
        ::mem/float)

(defcfn get-mouse-wheel-move-v
        "Get mouse wheel movement for both X and Y"
        "GetMouseWheelMoveV"
        []
        ::Vector2)

(defcfn set-mouse-cursor
        "Set mouse cursor"
        "SetMouseCursor"
        [::mem/int]
        ::mem/void)

(defcfn get-touch-x
        "Get touch position X for touch point 0 (relative to screen size)"
        "GetTouchX"
        []
        ::mem/int)

(defcfn get-touch-y
        "Get touch position Y for touch point 0 (relative to screen size)"
        "GetTouchY"
        []
        ::mem/int)

(defcfn
  get-touch-position
  "Get touch position XY for a touch point index (relative to screen size)"
  "GetTouchPosition"
  [::mem/int]
  ::Vector2)

(defcfn get-touch-point-id
        "Get touch point identifier for given index"
        "GetTouchPointId"
        [::mem/int]
        ::mem/int)

(defcfn get-touch-point-count
        "Get number of touch points"
        "GetTouchPointCount"
        []
        ::mem/int)

(defcfn set-gestures-enabled
        "Enable a set of gestures using flags"
        "SetGesturesEnabled"
        [::unsigned-int]
        ::mem/void)

(defcfn is-gesture-detected?
        "Check if a gesture have been detected"
        "IsGestureDetected"
        [::mem/int]
        ::bool)

(defcfn get-gesture-detected
        "Get latest detected gesture"
        "GetGestureDetected"
        []
        ::mem/int)

(defcfn get-gesture-hold-duration
        "Get gesture hold time in milliseconds"
        "GetGestureHoldDuration"
        []
        ::mem/float)

(defcfn get-gesture-drag-vector
        "Get gesture drag vector"
        "GetGestureDragVector"
        []
        ::Vector2)

(defcfn get-gesture-drag-angle
        "Get gesture drag angle"
        "GetGestureDragAngle"
        []
        ::mem/float)

(defcfn get-gesture-pinch-vector
        "Get gesture pinch delta"
        "GetGesturePinchVector"
        []
        ::Vector2)

(defcfn get-gesture-pinch-angle
        "Get gesture pinch angle"
        "GetGesturePinchAngle"
        []
        ::mem/float)

(defcfn set-camera-mode
        "Set camera mode (multiple camera modes available)"
        "SetCameraMode"
        [::Camera ::mem/int]
        ::mem/void)

(defcfn update-camera
        "Update camera position for selected mode"
        "UpdateCamera"
        [[::mem/pointer ::Camera]]
        ::mem/void)

(defcfn set-camera-pan-control
        "Set camera pan key to combine with mouse movement (free camera)"
        "SetCameraPanControl"
        [::mem/int]
        ::mem/void)

(defcfn set-camera-alt-control
        "Set camera alt key to combine with mouse movement (free camera)"
        "SetCameraAltControl"
        [::mem/int]
        ::mem/void)

(defcfn set-camera-smooth-zoom-control
        "Set camera smooth zoom key to combine with mouse (free camera)"
        "SetCameraSmoothZoomControl"
        [::mem/int]
        ::mem/void)

(defcfn set-camera-move-controls
        "Set camera move controls (1st person and 3rd person cameras)"
        "SetCameraMoveControls"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::mem/int ::mem/int]
        ::mem/void)

(defcfn set-shapes-texture
        "Set texture and rectangle to be used on shapes drawing"
        "SetShapesTexture"
        [::Texture2D ::Rectangle]
        ::mem/void)

(defcfn draw-pixel
        "Draw a pixel"
        "DrawPixel"
        [::mem/int ::mem/int ::Color]
        ::mem/void)

(defcfn draw-pixel-v
        "Draw a pixel (Vector version)"
        "DrawPixelV"
        [::Vector2 ::Color]
        ::mem/void)

(defcfn draw-line
        "Draw a line"
        "DrawLine"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-line-v
        "Draw a line (Vector version)"
        "DrawLineV"
        [::Vector2 ::Vector2
         ::Color]
        ::mem/void)

(defcfn draw-line-ex
        "Draw a line defining thickness"
        "DrawLineEx"
        [::Vector2 ::Vector2 ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-line-bezier
        "Draw a line using cubic-bezier curves in-out"
        "DrawLineBezier"
        [::Vector2 ::Vector2 ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-line-bezier-quad
        "Draw line using quadratic bezier curves with a control point"
        "DrawLineBezierQuad"
        [::Vector2 ::Vector2
         ::Vector2 ::mem/float ::Color]
        ::mem/void)

(defcfn draw-line-bezier-cubic
        "Draw line using cubic bezier curves with 2 control points"
        "DrawLineBezierCubic"
        [::Vector2 ::Vector2
         ::Vector2 ::Vector2 ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-line-strip
        "Draw lines sequence"
        "DrawLineStrip"
        [[::mem/pointer ::Vector2] ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-circle
        "Draw a color-filled circle"
        "DrawCircle"
        [::mem/int ::mem/int ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-circle-sector
        "Draw a piece of a circle"
        "DrawCircleSector"
        [::Vector2 ::mem/float ::mem/float
         ::mem/float ::mem/int ::Color]
        ::mem/void)

(defcfn draw-circle-sector-lines
        "Draw circle sector outline"
        "DrawCircleSectorLines"
        [::Vector2 ::mem/float ::mem/float
         ::mem/float ::mem/int ::Color]
        ::mem/void)

(defcfn draw-circle-gradient
        "Draw a gradient-filled circle"
        "DrawCircleGradient"
        [::mem/int ::mem/int ::mem/float ::Color
         ::Color]
        ::mem/void)

(defcfn draw-circle-v
        "Draw a color-filled circle (Vector version)"
        "DrawCircleV"
        [::Vector2 ::mem/float ::Color]
        ::mem/void)

(defcfn draw-circle-lines
        "Draw circle outline"
        "DrawCircleLines"
        [::mem/int ::mem/int ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-ellipse
        "Draw ellipse"
        "DrawEllipse"
        [::mem/int ::mem/int ::mem/float ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-ellipse-lines
        "Draw ellipse outline"
        "DrawEllipseLines"
        [::mem/int ::mem/int ::mem/float ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-ring
        "Draw ring"
        "DrawRing"
        [::Vector2 ::mem/float ::mem/float
         ::mem/float ::mem/float ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-ring-lines
        "Draw ring outline"
        "DrawRingLines"
        [::Vector2 ::mem/float ::mem/float
         ::mem/float ::mem/float ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-rectangle
        "Draw a color-filled rectangle"
        "DrawRectangle"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-rectangle-v
        "Draw a color-filled rectangle (Vector version)"
        "DrawRectangleV"
        [::Vector2 ::Vector2
         ::Color]
        ::mem/void)

(defcfn draw-rectangle-rec
        "Draw a color-filled rectangle"
        "DrawRectangleRec"
        [::Rectangle ::Color]
        ::mem/void)

(defcfn draw-rectangle-pro
        "Draw a color-filled rectangle with pro parameters"
        "DrawRectanglePro"
        [::Rectangle ::Vector2
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-rectangle-gradient-v
        "Draw a vertical-gradient-filled rectangle"
        "DrawRectangleGradientV"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::Color ::Color]
        ::mem/void)

(defcfn draw-rectangle-gradient-h
        "Draw a horizontal-gradient-filled rectangle"
        "DrawRectangleGradientH"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::Color ::Color]
        ::mem/void)

(defcfn draw-rectangle-gradient-ex
        "Draw a gradient-filled rectangle with custom vertex colors"
        "DrawRectangleGradientEx"
        [::Rectangle ::Color
         ::Color ::Color
         ::Color]
        ::mem/void)

(defcfn draw-rectangle-lines
        "Draw rectangle outline"
        "DrawRectangleLines"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-rectangle-lines-ex
        "Draw rectangle outline with extended parameters"
        "DrawRectangleLinesEx"
        [::Rectangle ::mem/float ::Color]
        ::mem/void)

(defcfn draw-rectangle-rounded
        "Draw rectangle with rounded edges"
        "DrawRectangleRounded"
        [::Rectangle ::mem/float ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-rectangle-rounded-lines
        "Draw rectangle with rounded edges outline"
        "DrawRectangleRoundedLines"
        [::Rectangle ::mem/float ::mem/int
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-triangle
        "Draw a color-filled triangle (vertex in counter-clockwise order!)"
        "DrawTriangle"
        [::Vector2 ::Vector2
         ::Vector2 ::Color]
        ::mem/void)

(defcfn draw-triangle-lines
        "Draw triangle outline (vertex in counter-clockwise order!)"
        "DrawTriangleLines"
        [::Vector2 ::Vector2
         ::Vector2 ::Color]
        ::mem/void)

(defcfn draw-triangle-fan
        "Draw a triangle fan defined by points (first vertex is the center)"
        "DrawTriangleFan"
        [[::mem/pointer ::Vector2] ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-triangle-strip
        "Draw a triangle strip defined by points"
        "DrawTriangleStrip"
        [[::mem/pointer ::Vector2] ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-poly
        "Draw a regular polygon (Vector version)"
        "DrawPoly"
        [::Vector2 ::mem/int ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-poly-lines
        "Draw a polygon outline of n sides"
        "DrawPolyLines"
        [::Vector2 ::mem/int ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-poly-lines-ex
        "Draw a polygon outline of n sides with extended parameters"
        "DrawPolyLinesEx"
        [::Vector2 ::mem/int ::mem/float
         ::mem/float ::mem/float ::Color]
        ::mem/void)

(defcfn check-collision-recs?
        "Check collision between two rectangles"
        "CheckCollisionRecs"
        [::Rectangle ::Rectangle]
        ::bool)

(defcfn check-collision-circles?
        "Check collision between two circles"
        "CheckCollisionCircles"
        [::Vector2 ::mem/float ::Vector2
         ::mem/float]
        ::bool)

(defcfn check-collision-circle-rec?
        "Check collision between circle and rectangle"
        "CheckCollisionCircleRec"
        [::Vector2 ::mem/float
         ::Rectangle]
        ::bool)

(defcfn check-collision-point-rec?
        "Check if point is inside rectangle"
        "CheckCollisionPointRec"
        [::Vector2 ::Rectangle]
        ::bool)

(defcfn check-collision-point-circle?
        "Check if point is inside circle"
        "CheckCollisionPointCircle"
        [::Vector2 ::Vector2 ::mem/float]
        ::bool)

(defcfn check-collision-point-triangle?
        "Check if point is inside a triangle"
        "CheckCollisionPointTriangle"
        [::Vector2 ::Vector2
         ::Vector2 ::Vector2]
        ::bool)

(defcfn check-collision-point-poly?
        "Check if point is within a polygon described by array of vertices"
        "CheckCollisionPointPoly"
        [::Vector2
         ::mem/pointer ::mem/int]
        ::bool)

(defcfn
  check-collision-lines?
  "Check the collision between two lines defined by two points each, returns collision point by reference"
  "CheckCollisionLines"
  [::Vector2 ::Vector2
   ::Vector2 ::Vector2
   [::mem/pointer ::Vector2]]
  ::bool)

(defcfn
  check-collision-point-line?
  "Check if point belongs to line created between two points [p1] and [p2] with defined margin in pixels [threshold]"
  "CheckCollisionPointLine"
  [::Vector2 ::Vector2
   ::Vector2 ::mem/int]
  ::bool)

(defcfn get-collision-rec
        "Get collision rectangle for two rectangles collision"
        "GetCollisionRec"
        [::Rectangle ::Rectangle]
        ::Rectangle)

(defcfn load-image
        "Load image from file into CPU memory (RAM)"
        "LoadImage"
        [::mem/c-string]
        ::Image)

(defcfn load-image-raw
        "Load image from RAW file data"
        "LoadImageRaw"
        [::mem/c-string ::mem/int ::mem/int ::mem/int
         ::mem/int]
        ::Image)

(defcfn load-image-anim
        "Load image sequence from file (frames appended to image.data)"
        "LoadImageAnim"
        [::mem/c-string [::mem/pointer ::mem/int]]
        ::Image)

(defcfn
  load-image-from-memory
  "Load image from memory buffer, fileType refers to extension: i.e. '.png'"
  "LoadImageFromMemory"
  [::mem/c-string ::mem/c-string ::mem/int]
  ::Image)

(defcfn load-image-from-texture
        "Load image from GPU texture data"
        "LoadImageFromTexture"
        [::Texture2D]
        ::Image)

(defcfn load-image-from-screen
        "Load image from screen buffer and (screenshot)"
        "LoadImageFromScreen"
        []
        ::Image)

(defcfn unload-image
        "Unload image from CPU memory (RAM)"
        "UnloadImage"
        [::Image]
        ::mem/void)

(defcfn export-image?
        "Export image data to file, returns true on success"
        "ExportImage"
        [::Image ::mem/c-string]
        ::bool)

(defcfn
  export-image-as-code?
  "Export image as code file defining an array of bytes, returns true on success"
  "ExportImageAsCode"
  [::Image ::mem/c-string]
  ::bool)

(defcfn gen-image-color
        "Generate image: plain color"
        "GenImageColor"
        [::mem/int ::mem/int ::Color]
        ::Image)

(defcfn gen-image-gradient-v
        "Generate image: vertical gradient"
        "GenImageGradientV"
        [::mem/int ::mem/int ::Color
         ::Color]
        ::Image)

(defcfn gen-image-gradient-h
        "Generate image: horizontal gradient"
        "GenImageGradientH"
        [::mem/int ::mem/int ::Color
         ::Color]
        ::Image)

(defcfn gen-image-gradient-radial
        "Generate image: radial gradient"
        "GenImageGradientRadial"
        [::mem/int ::mem/int ::mem/float ::Color
         ::Color]
        ::Image)

(defcfn gen-image-checked
        "Generate image: checked"
        "GenImageChecked"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::Color ::Color]
        ::Image)

(defcfn gen-image-white-noise
        "Generate image: white noise"
        "GenImageWhiteNoise"
        [::mem/int ::mem/int ::mem/float]
        ::Image)

(defcfn gen-image-perlin-noise
        "Generate image: perlin noise"
        "GenImagePerlinNoise"
        [::mem/int ::mem/int ::mem/int ::mem/int
         ::mem/float]
        ::Image)

(defcfn gen-image-cellular
        "Generate image: cellular algorithm, bigger tileSize means bigger cells"
        "GenImageCellular"
        [::mem/int ::mem/int ::mem/int]
        ::Image)

(defcfn image-copy
        "Create an image duplicate (useful for transformations)"
        "ImageCopy"
        [::Image]
        ::Image)

(defcfn image-from-image
        "Create an image from another image piece"
        "ImageFromImage"
        [::Image ::Rectangle]
        ::Image)

(defcfn image-text
        "Create an image from text (default font)"
        "ImageText"
        [::mem/c-string ::mem/int ::Color]
        ::Image)

(defcfn image-text-ex
        "Create an image from text (custom sprite font)"
        "ImageTextEx"
        [::Font ::mem/c-string ::mem/float
         ::mem/float ::Color]
        ::Image)

(defcfn image-format
        "Convert image data to desired format"
        "ImageFormat"
        [[::mem/pointer ::Image] ::mem/int]
        ::mem/void)

(defcfn image-to-pot
        "Convert image to POT (power-of-two)"
        "ImageToPOT"
        [[::mem/pointer ::Image] ::Color]
        ::mem/void)

(defcfn image-crop
        "Crop an image to a defined rectangle"
        "ImageCrop"
        [[::mem/pointer ::Image]
         ::Rectangle]
        ::mem/void)

(defcfn image-alpha-crop
        "Crop image depending on alpha value"
        "ImageAlphaCrop"
        [[::mem/pointer ::Image] ::mem/float]
        ::mem/void)

(defcfn image-alpha-clear
        "Clear alpha channel to desired color"
        "ImageAlphaClear"
        [[::mem/pointer ::Image] ::Color
         ::mem/float]
        ::mem/void)

(defcfn image-alpha-mask
        "Apply alpha mask to image"
        "ImageAlphaMask"
        [[::mem/pointer ::Image] ::Image]
        ::mem/void)

(defcfn image-alpha-premultiply
        "Premultiply alpha channel"
        "ImageAlphaPremultiply"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-resize
        "Resize image (Bicubic scaling algorithm)"
        "ImageResize"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int]
        ::mem/void)

(defcfn image-resize-nn
        "Resize image (Nearest-Neighbor scaling algorithm)"
        "ImageResizeNN"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int]
        ::mem/void)

(defcfn image-resize-canvas
        "Resize canvas and fill with color"
        "ImageResizeCanvas"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int ::mem/int ::mem/int ::Color]
        ::mem/void)

(defcfn image-mipmaps
        "Compute all mipmap levels for a provided image"
        "ImageMipmaps"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-dither
        "Dither image data to 16bpp or lower (Floyd-Steinberg dithering)"
        "ImageDither"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int ::mem/int ::mem/int]
        ::mem/void)

(defcfn image-flip-vertical
        "Flip image vertically"
        "ImageFlipVertical"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-flip-horizontal
        "Flip image horizontally"
        "ImageFlipHorizontal"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-rotate-cw
        "Rotate image clockwise 90deg"
        "ImageRotateCW"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-rotate-ccw
        "Rotate image counter-clockwise 90deg"
        "ImageRotateCCW"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-color-tint
        "Modify image color: tint"
        "ImageColorTint"
        [[::mem/pointer ::Image] ::Color]
        ::mem/void)

(defcfn image-color-invert
        "Modify image color: invert"
        "ImageColorInvert"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-color-grayscale
        "Modify image color: grayscale"
        "ImageColorGrayscale"
        [[::mem/pointer ::Image]]
        ::mem/void)

(defcfn image-color-contrast
        "Modify image color: contrast (-100 to 100)"
        "ImageColorContrast"
        [[::mem/pointer ::Image] ::mem/float]
        ::mem/void)

(defcfn image-color-brightness
        "Modify image color: brightness (-255 to 255)"
        "ImageColorBrightness"
        [[::mem/pointer ::Image] ::mem/int]
        ::mem/void)

(defcfn image-color-replace
        "Modify image color: replace color"
        "ImageColorReplace"
        [[::mem/pointer ::Image] ::Color
         ::Color]
        ::mem/void)

(defcfn load-image-colors
        "Load color data from image as a Color array (RGBA - 32bit)"
        "LoadImageColors"
        [::Image]
        [::mem/pointer ::Color])

(defcfn load-image-palette
        "Load colors palette from image as a Color array (RGBA - 32bit)"
        "LoadImagePalette"
        [::Image ::mem/int
         [::mem/pointer ::mem/int]]
        [::mem/pointer ::Color])

(defcfn unload-image-colors
        "Unload color data loaded with LoadImageColors()"
        "UnloadImageColors"
        [[::mem/pointer ::Color]]
        ::mem/void)

(defcfn unload-image-palette
        "Unload colors palette loaded with LoadImagePalette()"
        "UnloadImagePalette"
        [[::mem/pointer ::Color]]
        ::mem/void)

(defcfn get-image-alpha-border
        "Get image alpha border rectangle"
        "GetImageAlphaBorder"
        [::Image ::mem/float]
        ::Rectangle)

(defcfn get-image-color
        "Get image pixel color at (x, y) position"
        "GetImageColor"
        [::Image ::mem/int ::mem/int]
        ::Color)

(defcfn image-clear-background
        "Clear image background with given color"
        "ImageClearBackground"
        [[::mem/pointer ::Image] ::Color]
        ::mem/void)

(defcfn image-draw-pixel
        "Draw pixel within an image"
        "ImageDrawPixel"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-pixel-v
        "Draw pixel within an image (Vector version)"
        "ImageDrawPixelV"
        [[::mem/pointer ::Image]
         ::Vector2 ::Color]
        ::mem/void)

(defcfn image-draw-line
        "Draw line within an image"
        "ImageDrawLine"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int ::mem/int ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-line-v
        "Draw line within an image (Vector version)"
        "ImageDrawLineV"
        [[::mem/pointer ::Image]
         ::Vector2 ::Vector2
         ::Color]
        ::mem/void)

(defcfn image-draw-circle
        "Draw a filled circle within an image"
        "ImageDrawCircle"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-circle-v
        "Draw a filled circle within an image (Vector version)"
        "ImageDrawCircleV"
        [[::mem/pointer ::Image]
         ::Vector2 ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-circle-lines
        "Draw circle outline within an image"
        "ImageDrawCircleLines"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-circle-lines-v
        "Draw circle outline within an image (Vector version)"
        "ImageDrawCircleLinesV"
        [[::mem/pointer ::Image]
         ::Vector2 ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-rectangle
        "Draw rectangle within an image"
        "ImageDrawRectangle"
        [[::mem/pointer ::Image] ::mem/int
         ::mem/int ::mem/int ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-rectangle-v
        "Draw rectangle within an image (Vector version)"
        "ImageDrawRectangleV"
        [[::mem/pointer ::Image]
         ::Vector2 ::Vector2
         ::Color]
        ::mem/void)

(defcfn image-draw-rectangle-rec
        "Draw rectangle within an image"
        "ImageDrawRectangleRec"
        [[::mem/pointer ::Image]
         ::Rectangle ::Color]
        ::mem/void)

(defcfn image-draw-rectangle-lines
        "Draw rectangle lines within an image"
        "ImageDrawRectangleLines"
        [[::mem/pointer ::Image]
         ::Rectangle ::mem/int ::Color]
        ::mem/void)

(defcfn
  image-draw
  "Draw a source image within a destination image (tint applied to source)"
  "ImageDraw"
  [[::mem/pointer ::Image] ::Image
   ::Rectangle ::Rectangle
   ::Color]
  ::mem/void)

(defcfn image-draw-text
        "Draw text (using default font) within an image (destination)"
        "ImageDrawText"
        [[::mem/pointer ::Image] ::mem/c-string
         ::mem/int ::mem/int ::mem/int ::Color]
        ::mem/void)

(defcfn image-draw-text-ex
        "Draw text (custom sprite font) within an image (destination)"
        "ImageDrawTextEx"
        [[::mem/pointer ::Image] ::Font
         ::mem/c-string ::Vector2 ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn load-texture
        "Load texture from file into GPU memory (VRAM)"
        "LoadTexture"
        [::mem/c-string]
        ::Texture2D)

(defcfn load-texture-from-image
        "Load texture from image data"
        "LoadTextureFromImage"
        [::Image]
        ::Texture2D)

(defcfn load-texture-cubemap
        "Load cubemap from image, multiple image cubemap layouts supported"
        "LoadTextureCubemap"
        [::Image ::mem/int]
        ::TextureCubemap)

(defcfn load-render-texture
        "Load texture for rendering (framebuffer)"
        "LoadRenderTexture"
        [::mem/int ::mem/int]
        ::RenderTexture2D)

(defcfn unload-texture
        "Unload texture from GPU memory (VRAM)"
        "UnloadTexture"
        [::Texture2D]
        ::mem/void)

(defcfn unload-render-texture
        "Unload render texture from GPU memory (VRAM)"
        "UnloadRenderTexture"
        [::RenderTexture2D]
        ::mem/void)

(defcfn update-texture
        "Update GPU texture with new data"
        "UpdateTexture"
        [::Texture2D ::mem/pointer]
        ::mem/void)

(defcfn update-texture-rec
        "Update GPU texture rectangle with new data"
        "UpdateTextureRec"
        [::Texture2D ::Rectangle
         ::mem/pointer]
        ::mem/void)

(defcfn gen-texture-mipmaps
        "Generate GPU mipmaps for a texture"
        "GenTextureMipmaps"
        [[::mem/pointer ::Texture2D]]
        ::mem/void)

(defcfn set-texture-filter
        "Set texture scaling filter mode"
        "SetTextureFilter"
        [::Texture2D ::mem/int]
        ::mem/void)

(defcfn set-texture-wrap
        "Set texture wrapping mode"
        "SetTextureWrap"
        [::Texture2D ::mem/int]
        ::mem/void)

(defcfn draw-texture
        "Draw a Texture2D"
        "DrawTexture"
        [::Texture2D ::mem/int ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-texture-v
        "Draw a Texture2D with position defined as Vector2"
        "DrawTextureV"
        [::Texture2D ::Vector2
         ::Color]
        ::mem/void)

(defcfn draw-texture-ex
        "Draw a Texture2D with extended parameters"
        "DrawTextureEx"
        [::Texture2D ::Vector2
         ::mem/float ::mem/float ::Color]
        ::mem/void)

(defcfn draw-texture-rec
        "Draw a part of a texture defined by a rectangle"
        "DrawTextureRec"
        [::Texture2D ::Rectangle
         ::Vector2 ::Color]
        ::mem/void)

(defcfn draw-texture-quad
        "Draw texture quad with tiling and offset parameters"
        "DrawTextureQuad"
        [::Texture2D ::Vector2
         ::Vector2 ::Rectangle
         ::Color]
        ::mem/void)

(defcfn
  draw-texture-tiled
  "Draw part of a texture (defined by a rectangle) with rotation and scale tiled into dest."
  "DrawTextureTiled"
  [::Texture2D ::Rectangle
   ::Rectangle ::Vector2 ::mem/float
   ::mem/float ::Color]
  ::mem/void)

(defcfn draw-texture-pro
        "Draw a part of a texture defined by a rectangle with 'pro' parameters"
        "DrawTexturePro"
        [::Texture2D ::Rectangle
         ::Rectangle ::Vector2
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-texture-n-patch
        "Draws a texture (or part of it) that stretches or shrinks nicely"
        "DrawTextureNPatch"
        [::Texture2D ::NPatchInfo
         ::Rectangle ::Vector2
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-texture-poly
        "Draw a textured polygon"
        "DrawTexturePoly"
        [::Texture2D ::Vector2
         [::mem/pointer ::Vector2]
         [::mem/pointer ::Vector2] ::mem/int
         ::Color]
        ::mem/void)

(defcfn fade
        "Get color with alpha applied, alpha goes from 0.0f to 1.0f"
        "Fade"
        [::Color ::mem/float]
        ::Color)

(defcfn color-to-int
        "Get hexadecimal value for a Color"
        "ColorToInt"
        [::Color]
        ::mem/int)

(defcfn color-normalize
        "Get Color normalized as float [0..1]"
        "ColorNormalize"
        [::Color]
        ::Vector4)

(defcfn color-from-normalized
        "Get Color from normalized values [0..1]"
        "ColorFromNormalized"
        [::Vector4]
        ::Color)

(defcfn color-to-hsv
        "Get HSV values for a Color, hue [0..360], saturation/value [0..1]"
        "ColorToHSV"
        [::Color]
        ::Vector3)

(defcfn color-from-hsv
        "Get a Color from HSV values, hue [0..360], saturation/value [0..1]"
        "ColorFromHSV"
        [::mem/float ::mem/float ::mem/float]
        ::Color)

(defcfn color-alpha
        "Get color with alpha applied, alpha goes from 0.0f to 1.0f"
        "ColorAlpha"
        [::Color ::mem/float]
        ::Color)

(defcfn color-alpha-blend
        "Get src alpha-blended into dst color with tint"
        "ColorAlphaBlend"
        [::Color ::Color
         ::Color]
        ::Color)

(defcfn get-color
        "Get Color structure from hexadecimal value"
        "GetColor"
        [::unsigned-int]
        ::Color)

(defcfn get-pixel-color
        "Get Color from a source pixel pointer of certain format"
        "GetPixelColor"
        [::mem/pointer ::mem/int]
        ::Color)

(defcfn set-pixel-color
        "Set color formatted into destination pixel pointer"
        "SetPixelColor"
        [::mem/pointer ::Color ::mem/int]
        ::mem/void)

(defcfn get-pixel-data-size
        "Get pixel data size in bytes for certain format"
        "GetPixelDataSize"
        [::mem/int ::mem/int ::mem/int]
        ::mem/int)

(defcfn get-font-default
        "Get the default Font"
        "GetFontDefault"
        []
        ::Font)

(defcfn load-font
        "Load font from file into GPU memory (VRAM)"
        "LoadFont"
        [::mem/c-string]
        ::Font)

(defcfn
  load-font-ex
  "Load font from file with extended parameters, use NULL for fontChars and 0 for glyphCount to load the default character set"
  "LoadFontEx"
  [::mem/c-string ::mem/int [::mem/pointer ::mem/int]
   ::mem/int]
  ::Font)

(defcfn load-font-from-image
        "Load font from Image (XNA style)"
        "LoadFontFromImage"
        [::Image ::Color ::mem/int]
        ::Font)

(defcfn
  load-font-from-memory
  "Load font from memory buffer, fileType refers to extension: i.e. '.ttf'"
  "LoadFontFromMemory"
  [::mem/c-string ::mem/c-string ::mem/int ::mem/int
   [::mem/pointer ::mem/int] ::mem/int]
  ::Font)

(defcfn load-font-data
        "Load font data for further use"
        "LoadFontData"
        [::mem/c-string ::mem/int ::mem/int
         [::mem/pointer ::mem/int] ::mem/int ::mem/int]
        [::mem/pointer ::GlyphInfo])

(defcfn gen-image-font-atlas
        "Generate image font atlas using chars info"
        "GenImageFontAtlas"
        [[::mem/pointer ::mem/const GlyphInfo]
         [::mem/pointer [::mem/pointer ::Rectangle]]
         ::mem/int ::mem/int ::mem/int ::mem/int]
        ::Image)

(defcfn unload-font-data
        "Unload font chars info data (RAM)"
        "UnloadFontData"
        [[::mem/pointer ::GlyphInfo] ::mem/int]
        ::mem/void)

(defcfn unload-font
        "Unload font from GPU memory (VRAM)"
        "UnloadFont"
        [::Font]
        ::mem/void)

(defcfn export-font-as-code?
        "Export font as code file, returns true on success"
        "ExportFontAsCode"
        [::Font ::mem/c-string]
        ::bool)

(defcfn draw-fps
        "Draw current FPS"
        "DrawFPS"
        [::mem/int ::mem/int]
        ::mem/void)

(defcfn draw-text
        "Draw text (using default font)"
        "DrawText"
        [::mem/c-string ::mem/int ::mem/int ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-text-ex
        "Draw text using font and additional parameters"
        "DrawTextEx"
        [::Font ::mem/c-string ::Vector2
         ::mem/float ::mem/float ::Color]
        ::mem/void)

(defcfn draw-text-pro
        "Draw text using Font and pro parameters (rotation)"
        "DrawTextPro"
        [::Font ::mem/c-string ::Vector2
         ::Vector2 ::mem/float ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-text-codepoint
        "Draw one character (codepoint)"
        "DrawTextCodepoint"
        [::Font ::mem/int ::Vector2
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-text-codepoints
        "Draw multiple character (codepoint)"
        "DrawTextCodepoints"
        [::Font [::mem/pointer ::mem/const int]
         ::mem/int ::Vector2 ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn measure-text
        "Measure string width for default font"
        "MeasureText"
        [::mem/c-string ::mem/int]
        ::mem/int)

(defcfn measure-text-ex
        "Measure string size for Font"
        "MeasureTextEx"
        [::Font ::mem/c-string ::mem/float
         ::mem/float]
        ::Vector2)

(defcfn
  get-glyph-index
  "Get glyph index position in font for a codepoint (unicode character), fallback to '?' if not found"
  "GetGlyphIndex"
  [::Font ::mem/int]
  ::mem/int)

(defcfn
  get-glyph-info
  "Get glyph font info data for a codepoint (unicode character), fallback to '?' if not found"
  "GetGlyphInfo"
  [::Font ::mem/int]
  ::GlyphInfo)

(defcfn
  get-glyph-atlas-rec
  "Get glyph rectangle in font atlas for a codepoint (unicode character), fallback to '?' if not found"
  "GetGlyphAtlasRec"
  [::Font ::mem/int]
  ::Rectangle)

(defcfn load-utf-8
        "Load UTF-8 text encoded from codepoints array"
        "LoadUTF8"
        [[::mem/pointer ::mem/const int] ::mem/int]
        ::mem/c-string)

(defcfn unload-utf-8
        "Unload UTF-8 text encoded from codepoints array"
        "UnloadUTF8"
        [::mem/c-string]
        ::mem/void)

(defcfn
  load-codepoints
  "Load all codepoints from a UTF-8 text string, codepoints count returned by parameter"
  "LoadCodepoints"
  [::mem/c-string [::mem/pointer ::mem/int]]
  [::mem/pointer ::mem/int])

(defcfn unload-codepoints
        "Unload codepoints data from memory"
        "UnloadCodepoints"
        [[::mem/pointer ::mem/int]]
        ::mem/void)

(defcfn get-codepoint-count
        "Get total number of codepoints in a UTF-8 encoded string"
        "GetCodepointCount"
        [::mem/c-string]
        ::mem/int)

(defcfn
  get-codepoint
  "Get next codepoint in a UTF-8 encoded string, 0x3f('?') is returned on failure"
  "GetCodepoint"
  [::mem/c-string [::mem/pointer ::mem/int]]
  ::mem/int)

(defcfn
  get-codepoint-next
  "Get next codepoint in a UTF-8 encoded string, 0x3f('?') is returned on failure"
  "GetCodepointNext"
  [::mem/c-string [::mem/pointer ::mem/int]]
  ::mem/int)

(defcfn
  get-codepoint-previous
  "Get previous codepoint in a UTF-8 encoded string, 0x3f('?') is returned on failure"
  "GetCodepointPrevious"
  [::mem/c-string [::mem/pointer ::mem/int]]
  ::mem/int)

(defcfn
  codepoint-to-utf-8
  "Encode one codepoint into UTF-8 byte array (array length returned as parameter)"
  "CodepointToUTF8"
  [::mem/int [::mem/pointer ::mem/int]]
  ::mem/c-string)

(defcfn text-copy
        "Copy one string to another, returns bytes copied"
        "TextCopy"
        [::mem/c-string ::mem/c-string]
        ::mem/int)

(defcfn text-is-equal?
        "Check if two text string are equal"
        "TextIsEqual"
        [::mem/c-string ::mem/c-string]
        ::bool)

(defcfn text-length
        "Get text length, checks for '\\0' ending"
        "TextLength"
        [::mem/c-string]
        ::unsigned-int)

(defcfn text-subtext
        "Get a piece of a text string"
        "TextSubtext"
        [::mem/c-string ::mem/int ::mem/int]
        ::mem/c-string)

(defcfn text-replace
        "Replace text string (WARNING: memory must be freed!)"
        "TextReplace"
        [::mem/c-string ::mem/c-string ::mem/c-string]
        ::mem/c-string)

(defcfn text-insert
        "Insert text in a position (WARNING: memory must be freed!)"
        "TextInsert"
        [::mem/c-string ::mem/c-string ::mem/int]
        ::mem/c-string)

(defcfn text-join
        "Join text strings with delimiter"
        "TextJoin"
        [[::mem/pointer ::mem/c-string] ::mem/int
         ::mem/c-string]
        ::mem/c-string)

(defcfn text-split
        "Split text into multiple strings"
        "TextSplit"
        [::mem/c-string ::mem/char
         [::mem/pointer ::mem/int]]
        [::mem/pointer ::mem/c-string])

(defcfn text-append
        "Append text at specific position and move cursor!"
        "TextAppend"
        [::mem/c-string ::mem/c-string
         [::mem/pointer ::mem/int]]
        ::mem/void)

(defcfn text-find-index
        "Find first text occurrence within a string"
        "TextFindIndex"
        [::mem/c-string ::mem/c-string]
        ::mem/int)

(defcfn text-to-upper
        "Get upper case version of provided string"
        "TextToUpper"
        [::mem/c-string]
        ::mem/c-string)

(defcfn text-to-lower
        "Get lower case version of provided string"
        "TextToLower"
        [::mem/c-string]
        ::mem/c-string)

(defcfn text-to-pascal
        "Get Pascal case notation version of provided string"
        "TextToPascal"
        [::mem/c-string]
        ::mem/c-string)

(defcfn text-to-integer
        "Get integer value from text (negative values not supported)"
        "TextToInteger"
        [::mem/c-string]
        ::mem/int)

(defcfn draw-line-3-d
        "Draw a line in 3D world space"
        "DrawLine3D"
        [::Vector3 ::Vector3
         ::Color]
        ::mem/void)

(defcfn draw-point-3-d
        "Draw a point in 3D space, actually a small line"
        "DrawPoint3D"
        [::Vector3 ::Color]
        ::mem/void)

(defcfn draw-circle-3-d
        "Draw a circle in 3D world space"
        "DrawCircle3D"
        [::Vector3 ::mem/float ::Vector3
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-triangle-3-d
        "Draw a color-filled triangle (vertex in counter-clockwise order!)"
        "DrawTriangle3D"
        [::Vector3 ::Vector3
         ::Vector3 ::Color]
        ::mem/void)

(defcfn draw-triangle-strip-3-d
        "Draw a triangle strip defined by points"
        "DrawTriangleStrip3D"
        [[::mem/pointer ::Vector3] ::mem/int
         ::Color]
        ::mem/void)

(defcfn draw-cube
        "Draw cube"
        "DrawCube"
        [::Vector3 ::mem/float ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-cube-v
        "Draw cube (Vector version)"
        "DrawCubeV"
        [::Vector3 ::Vector3
         ::Color]
        ::mem/void)

(defcfn draw-cube-wires
        "Draw cube wires"
        "DrawCubeWires"
        [::Vector3 ::mem/float ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-cube-wires-v
        "Draw cube wires (Vector version)"
        "DrawCubeWiresV"
        [::Vector3 ::Vector3
         ::Color]
        ::mem/void)

(defcfn draw-cube-texture
        "Draw cube textured"
        "DrawCubeTexture"
        [::Texture2D ::Vector3
         ::mem/float ::mem/float ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-cube-texture-rec
        "Draw cube with a region of a texture"
        "DrawCubeTextureRec"
        [::Texture2D ::Rectangle
         ::Vector3 ::mem/float ::mem/float
         ::mem/float ::Color]
        ::mem/void)

(defcfn draw-sphere
        "Draw sphere"
        "DrawSphere"
        [::Vector3 ::mem/float ::Color]
        ::mem/void)

(defcfn draw-sphere-ex
        "Draw sphere with extended parameters"
        "DrawSphereEx"
        [::Vector3 ::mem/float ::mem/int
         ::mem/int ::Color]
        ::mem/void)

(defcfn draw-sphere-wires
        "Draw sphere wires"
        "DrawSphereWires"
        [::Vector3 ::mem/float ::mem/int
         ::mem/int ::Color]
        ::mem/void)

(defcfn draw-cylinder
        "Draw a cylinder/cone"
        "DrawCylinder"
        [::Vector3 ::mem/float ::mem/float
         ::mem/float ::mem/int ::Color]
        ::mem/void)

(defcfn draw-cylinder-ex
        "Draw a cylinder with base at startPos and top at endPos"
        "DrawCylinderEx"
        [::Vector3 ::Vector3 ::mem/float
         ::mem/float ::mem/int ::Color]
        ::mem/void)

(defcfn draw-cylinder-wires
        "Draw a cylinder/cone wires"
        "DrawCylinderWires"
        [::Vector3 ::mem/float ::mem/float
         ::mem/float ::mem/int ::Color]
        ::mem/void)

(defcfn draw-cylinder-wires-ex
        "Draw a cylinder wires with base at startPos and top at endPos"
        "DrawCylinderWiresEx"
        [::Vector3 ::Vector3 ::mem/float
         ::mem/float ::mem/int ::Color]
        ::mem/void)

(defcfn draw-plane
        "Draw a plane XZ"
        "DrawPlane"
        [::Vector3 ::Vector2
         ::Color]
        ::mem/void)

(defcfn draw-ray
        "Draw a ray line"
        "DrawRay"
        [::Ray ::Color]
        ::mem/void)

(defcfn draw-grid
        "Draw a grid (centered at (0, 0, 0))"
        "DrawGrid"
        [::mem/int ::mem/float]
        ::mem/void)

(defcfn load-model
        "Load model from files (meshes and materials)"
        "LoadModel"
        [::mem/c-string]
        ::Model)

(defcfn load-model-from-mesh
        "Load model from generated mesh (default material)"
        "LoadModelFromMesh"
        [::Mesh]
        ::Model)

(defcfn unload-model
        "Unload model (including meshes) from memory (RAM and/or VRAM)"
        "UnloadModel"
        [::Model]
        ::mem/void)

(defcfn unload-model-keep-meshes
        "Unload model (but not meshes) from memory (RAM and/or VRAM)"
        "UnloadModelKeepMeshes"
        [::Model]
        ::mem/void)

(defcfn get-model-bounding-box
        "Compute model bounding box limits (considers all meshes)"
        "GetModelBoundingBox"
        [::Model]
        ::BoundingBox)

(defcfn draw-model
        "Draw a model (with texture if set)"
        "DrawModel"
        [::Model ::Vector3 ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-model-ex
        "Draw a model with extended parameters"
        "DrawModelEx"
        [::Model ::Vector3
         ::Vector3 ::mem/float ::Vector3
         ::Color]
        ::mem/void)

(defcfn draw-model-wires
        "Draw a model wires (with texture if set)"
        "DrawModelWires"
        [::Model ::Vector3 ::mem/float
         ::Color]
        ::mem/void)

(defcfn draw-model-wires-ex
        "Draw a model wires (with texture if set) with extended parameters"
        "DrawModelWiresEx"
        [::Model ::Vector3
         ::Vector3 ::mem/float ::Vector3
         ::Color]
        ::mem/void)

(defcfn draw-bounding-box
        "Draw bounding box (wires)"
        "DrawBoundingBox"
        [::BoundingBox ::Color]
        ::mem/void)

(defcfn draw-billboard
        "Draw a billboard texture"
        "DrawBillboard"
        [::Camera ::Texture2D
         ::Vector3 ::mem/float ::Color]
        ::mem/void)

(defcfn draw-billboard-rec
        "Draw a billboard texture defined by source"
        "DrawBillboardRec"
        [::Camera ::Texture2D
         ::Rectangle ::Vector3
         ::Vector2 ::Color]
        ::mem/void)

(defcfn draw-billboard-pro
        "Draw a billboard texture defined by source and rotation"
        "DrawBillboardPro"
        [::Camera ::Texture2D
         ::Rectangle ::Vector3
         ::Vector3 ::Vector2
         ::Vector2 ::mem/float ::Color]
        ::mem/void)

(defcfn upload-mesh
        "Upload mesh vertex data in GPU and provide VAO/VBO ids"
        "UploadMesh"
        [[::mem/pointer ::Mesh] ::bool]
        ::mem/void)

(defcfn update-mesh-buffer
        "Update mesh vertex data in GPU for a specific buffer index"
        "UpdateMeshBuffer"
        [::Mesh ::mem/int ::mem/pointer
         ::mem/int ::mem/int]
        ::mem/void)

(defcfn unload-mesh
        "Unload mesh data from CPU and GPU"
        "UnloadMesh"
        [::Mesh]
        ::mem/void)

(defcfn draw-mesh
        "Draw a 3d mesh with material and transform"
        "DrawMesh"
        [::Mesh ::Material
         ::Matrix]
        ::mem/void)

(defcfn draw-mesh-instanced
        "Draw multiple mesh instances with material and different transforms"
        "DrawMeshInstanced"
        [::Mesh ::Material
         [::mem/pointer ::mem/const Matrix] ::mem/int]
        ::mem/void)

(defcfn export-mesh?
        "Export mesh data to file, returns true on success"
        "ExportMesh"
        [::Mesh ::mem/c-string]
        ::bool)

(defcfn get-mesh-bounding-box
        "Compute mesh bounding box limits"
        "GetMeshBoundingBox"
        [::Mesh]
        ::BoundingBox)

(defcfn gen-mesh-tangents
        "Compute mesh tangents"
        "GenMeshTangents"
        [[::mem/pointer ::Mesh]]
        ::mem/void)

(defcfn gen-mesh-poly
        "Generate polygonal mesh"
        "GenMeshPoly"
        [::mem/int ::mem/float]
        ::Mesh)

(defcfn gen-mesh-plane
        "Generate plane mesh (with subdivisions)"
        "GenMeshPlane"
        [::mem/float ::mem/float ::mem/int ::mem/int]
        ::Mesh)

(defcfn gen-mesh-cube
        "Generate cuboid mesh"
        "GenMeshCube"
        [::mem/float ::mem/float ::mem/float]
        ::Mesh)

(defcfn gen-mesh-sphere
        "Generate sphere mesh (standard sphere)"
        "GenMeshSphere"
        [::mem/float ::mem/int ::mem/int]
        ::Mesh)

(defcfn gen-mesh-hemi-sphere
        "Generate half-sphere mesh (no bottom cap)"
        "GenMeshHemiSphere"
        [::mem/float ::mem/int ::mem/int]
        ::Mesh)

(defcfn gen-mesh-cylinder
        "Generate cylinder mesh"
        "GenMeshCylinder"
        [::mem/float ::mem/float ::mem/int]
        ::Mesh)

(defcfn gen-mesh-cone
        "Generate cone/pyramid mesh"
        "GenMeshCone"
        [::mem/float ::mem/float ::mem/int]
        ::Mesh)

(defcfn gen-mesh-torus
        "Generate torus mesh"
        "GenMeshTorus"
        [::mem/float ::mem/float ::mem/int ::mem/int]
        ::Mesh)

(defcfn gen-mesh-knot
        "Generate trefoil knot mesh"
        "GenMeshKnot"
        [::mem/float ::mem/float ::mem/int ::mem/int]
        ::Mesh)

(defcfn gen-mesh-heightmap
        "Generate heightmap mesh from image data"
        "GenMeshHeightmap"
        [::Image ::Vector3]
        ::Mesh)

(defcfn gen-mesh-cubicmap
        "Generate cubes-based map mesh from image data"
        "GenMeshCubicmap"
        [::Image ::Vector3]
        ::Mesh)

(defcfn load-materials
        "Load materials from model file"
        "LoadMaterials"
        [::mem/c-string [::mem/pointer ::mem/int]]
        [::mem/pointer ::Material])

(defcfn load-material-default
        "Load default material (Supports: DIFFUSE, SPECULAR, NORMAL maps)"
        "LoadMaterialDefault"
        []
        ::Material)

(defcfn unload-material
        "Unload material from GPU memory (VRAM)"
        "UnloadMaterial"
        [::Material]
        ::mem/void)

(defcfn
  set-material-texture
  "Set texture for a material map type (MATERIAL_MAP_DIFFUSE, MATERIAL_MAP_SPECULAR...)"
  "SetMaterialTexture"
  [[::mem/pointer ::Material] ::mem/int
   ::Texture2D]
  ::mem/void)

(defcfn set-model-mesh-material
        "Set material for a mesh"
        "SetModelMeshMaterial"
        [[::mem/pointer ::Model] ::mem/int
         ::mem/int]
        ::mem/void)

(defcfn load-model-animations
        "Load model animations from file"
        "LoadModelAnimations"
        [::mem/c-string
         [::mem/pointer ::unsigned-int]]
        [::mem/pointer ::ModelAnimation])

(defcfn update-model-animation
        "Update model animation pose"
        "UpdateModelAnimation"
        [::Model ::ModelAnimation
         ::mem/int]
        ::mem/void)

(defcfn unload-model-animation
        "Unload animation data"
        "UnloadModelAnimation"
        [::ModelAnimation]
        ::mem/void)

(defcfn unload-model-animations
        "Unload animation array data"
        "UnloadModelAnimations"
        [[::mem/pointer ::ModelAnimation]
         ::unsigned-int]
        ::mem/void)

(defcfn is-model-animation-valid?
        "Check model animation skeleton match"
        "IsModelAnimationValid"
        [::Model ::ModelAnimation]
        ::bool)

(defcfn check-collision-spheres?
        "Check collision between two spheres"
        "CheckCollisionSpheres"
        [::Vector3 ::mem/float ::Vector3
         ::mem/float]
        ::bool)

(defcfn check-collision-boxes?
        "Check collision between two bounding boxes"
        "CheckCollisionBoxes"
        [::BoundingBox ::BoundingBox]
        ::bool)

(defcfn check-collision-box-sphere?
        "Check collision between box and sphere"
        "CheckCollisionBoxSphere"
        [::BoundingBox ::Vector3
         ::mem/float]
        ::bool)

(defcfn get-ray-collision-sphere
        "Get collision info between ray and sphere"
        "GetRayCollisionSphere"
        [::Ray ::Vector3 ::mem/float]
        ::RayCollision)

(defcfn get-ray-collision-box
        "Get collision info between ray and box"
        "GetRayCollisionBox"
        [::Ray ::BoundingBox]
        ::RayCollision)

(defcfn get-ray-collision-mesh
        "Get collision info between ray and mesh"
        "GetRayCollisionMesh"
        [::Ray ::Mesh
         ::Matrix]
        ::RayCollision)

(defcfn get-ray-collision-triangle
        "Get collision info between ray and triangle"
        "GetRayCollisionTriangle"
        [::Ray ::Vector3
         ::Vector3 ::Vector3]
        ::RayCollision)

(defcfn get-ray-collision-quad
        "Get collision info between ray and quad"
        "GetRayCollisionQuad"
        [::Ray ::Vector3
         ::Vector3 ::Vector3
         ::Vector3]
        ::RayCollision)

(defcfn init-audio-device
        "Initialize audio device and context"
        "InitAudioDevice"
        []
        ::mem/void)

(defcfn close-audio-device
        "Close the audio device and context"
        "CloseAudioDevice"
        []
        ::mem/void)

(defcfn is-audio-device-ready?
        "Check if audio device has been initialized successfully"
        "IsAudioDeviceReady"
        []
        ::bool)

(defcfn set-master-volume
        "Set master volume (listener)"
        "SetMasterVolume"
        [::mem/float]
        ::mem/void)

(defcfn load-wave
        "Load wave data from file"
        "LoadWave"
        [::mem/c-string]
        ::Wave)

(defcfn
  load-wave-from-memory
  "Load wave from memory buffer, fileType refers to extension: i.e. '.wav'"
  "LoadWaveFromMemory"
  [::mem/c-string ::mem/c-string ::mem/int]
  ::Wave)

(defcfn load-sound
        "Load sound from file"
        "LoadSound"
        [::mem/c-string]
        ::Sound)

(defcfn load-sound-from-wave
        "Load sound from wave data"
        "LoadSoundFromWave"
        [::Wave]
        ::Sound)

(defcfn update-sound
        "Update sound buffer with new data"
        "UpdateSound"
        [::Sound ::mem/pointer ::mem/int]
        ::mem/void)

(defcfn unload-wave
        "Unload wave data"
        "UnloadWave"
        [::Wave]
        ::mem/void)

(defcfn unload-sound
        "Unload sound"
        "UnloadSound"
        [::Sound]
        ::mem/void)

(defcfn export-wave?
        "Export wave data to file, returns true on success"
        "ExportWave"
        [::Wave ::mem/c-string]
        ::bool)

(defcfn export-wave-as-code?
        "Export wave sample data to code (.h), returns true on success"
        "ExportWaveAsCode"
        [::Wave ::mem/c-string]
        ::bool)

(defcfn play-sound
        "Play a sound"
        "PlaySound"
        [::Sound]
        ::mem/void)

(defcfn stop-sound
        "Stop playing a sound"
        "StopSound"
        [::Sound]
        ::mem/void)

(defcfn pause-sound
        "Pause a sound"
        "PauseSound"
        [::Sound]
        ::mem/void)

(defcfn resume-sound
        "Resume a paused sound"
        "ResumeSound"
        [::Sound]
        ::mem/void)

(defcfn play-sound-multi
        "Play a sound (using multichannel buffer pool)"
        "PlaySoundMulti"
        [::Sound]
        ::mem/void)

(defcfn stop-sound-multi
        "Stop any sound playing (using multichannel buffer pool)"
        "StopSoundMulti"
        []
        ::mem/void)

(defcfn get-sounds-playing
        "Get number of sounds playing in the multichannel"
        "GetSoundsPlaying"
        []
        ::mem/int)

(defcfn is-sound-playing?
        "Check if a sound is currently playing"
        "IsSoundPlaying"
        [::Sound]
        ::bool)

(defcfn set-sound-volume
        "Set volume for a sound (1.0 is max level)"
        "SetSoundVolume"
        [::Sound ::mem/float]
        ::mem/void)

(defcfn set-sound-pitch
        "Set pitch for a sound (1.0 is base level)"
        "SetSoundPitch"
        [::Sound ::mem/float]
        ::mem/void)

(defcfn set-sound-pan
        "Set pan for a sound (0.5 is center)"
        "SetSoundPan"
        [::Sound ::mem/float]
        ::mem/void)

(defcfn wave-copy
        "Copy a wave to a new wave"
        "WaveCopy"
        [::Wave]
        ::Wave)

(defcfn wave-crop
        "Crop a wave to defined samples range"
        "WaveCrop"
        [[::mem/pointer ::Wave] ::mem/int
         ::mem/int]
        ::mem/void)

(defcfn wave-format
        "Convert wave data to desired format"
        "WaveFormat"
        [[::mem/pointer ::Wave] ::mem/int
         ::mem/int ::mem/int]
        ::mem/void)

(defcfn load-wave-samples
        "Load samples data from wave as a 32bit float data array"
        "LoadWaveSamples"
        [::Wave]
        [::mem/pointer ::mem/float])

(defcfn unload-wave-samples
        "Unload samples data loaded with LoadWaveSamples()"
        "UnloadWaveSamples"
        [[::mem/pointer ::mem/float]]
        ::mem/void)

(defcfn load-music-stream
        "Load music stream from file"
        "LoadMusicStream"
        [::mem/c-string]
        ::Music)

(defcfn load-music-stream-from-memory
        "Load music stream from data"
        "LoadMusicStreamFromMemory"
        [::mem/c-string ::mem/c-string ::mem/int]
        ::Music)

(defcfn unload-music-stream
        "Unload music stream"
        "UnloadMusicStream"
        [::Music]
        ::mem/void)

(defcfn play-music-stream
        "Start music playing"
        "PlayMusicStream"
        [::Music]
        ::mem/void)

(defcfn is-music-stream-playing?
        "Check if music is playing"
        "IsMusicStreamPlaying"
        [::Music]
        ::bool)

(defcfn update-music-stream
        "Updates buffers for music streaming"
        "UpdateMusicStream"
        [::Music]
        ::mem/void)

(defcfn stop-music-stream
        "Stop music playing"
        "StopMusicStream"
        [::Music]
        ::mem/void)

(defcfn pause-music-stream
        "Pause music playing"
        "PauseMusicStream"
        [::Music]
        ::mem/void)

(defcfn resume-music-stream
        "Resume playing paused music"
        "ResumeMusicStream"
        [::Music]
        ::mem/void)

(defcfn seek-music-stream
        "Seek music to a position (in seconds)"
        "SeekMusicStream"
        [::Music ::mem/float]
        ::mem/void)

(defcfn set-music-volume
        "Set volume for music (1.0 is max level)"
        "SetMusicVolume"
        [::Music ::mem/float]
        ::mem/void)

(defcfn set-music-pitch
        "Set pitch for a music (1.0 is base level)"
        "SetMusicPitch"
        [::Music ::mem/float]
        ::mem/void)

(defcfn set-music-pan
        "Set pan for a music (0.5 is center)"
        "SetMusicPan"
        [::Music ::mem/float]
        ::mem/void)

(defcfn get-music-time-length
        "Get music time length (in seconds)"
        "GetMusicTimeLength"
        [::Music]
        ::mem/float)

(defcfn get-music-time-played
        "Get current music time played (in seconds)"
        "GetMusicTimePlayed"
        [::Music]
        ::mem/float)

(defcfn load-audio-stream
        "Load audio stream (to stream raw audio pcm data)"
        "LoadAudioStream"
        [::unsigned-int ::unsigned-int
         ::unsigned-int]
        ::AudioStream)

(defcfn unload-audio-stream
        "Unload audio stream and free memory"
        "UnloadAudioStream"
        [::AudioStream]
        ::mem/void)

(defcfn update-audio-stream
        "Update audio stream buffers with data"
        "UpdateAudioStream"
        [::AudioStream ::mem/pointer ::mem/int]
        ::mem/void)

(defcfn is-audio-stream-processed?
        "Check if any audio stream buffers requires refill"
        "IsAudioStreamProcessed"
        [::AudioStream]
        ::bool)

(defcfn play-audio-stream
        "Play audio stream"
        "PlayAudioStream"
        [::AudioStream]
        ::mem/void)

(defcfn pause-audio-stream
        "Pause audio stream"
        "PauseAudioStream"
        [::AudioStream]
        ::mem/void)

(defcfn resume-audio-stream
        "Resume audio stream"
        "ResumeAudioStream"
        [::AudioStream]
        ::mem/void)

(defcfn is-audio-stream-playing?
        "Check if audio stream is playing"
        "IsAudioStreamPlaying"
        [::AudioStream]
        ::bool)

(defcfn stop-audio-stream
        "Stop audio stream"
        "StopAudioStream"
        [::AudioStream]
        ::mem/void)

(defcfn set-audio-stream-volume
        "Set volume for audio stream (1.0 is max level)"
        "SetAudioStreamVolume"
        [::AudioStream ::mem/float]
        ::mem/void)

(defcfn set-audio-stream-pitch
        "Set pitch for audio stream (1.0 is base level)"
        "SetAudioStreamPitch"
        [::AudioStream ::mem/float]
        ::mem/void)

(defcfn set-audio-stream-pan
        "Set pan for audio stream (0.5 is centered)"
        "SetAudioStreamPan"
        [::AudioStream ::mem/float]
        ::mem/void)

(defcfn set-audio-stream-buffer-size-default
        "Default size for new audio streams"
        "SetAudioStreamBufferSizeDefault"
        [::mem/int]
        ::mem/void)

(defcfn attach-audio-stream-processor
        "Attach audio stream processor to stream"
        "AttachAudioStreamProcessor"
        [::AudioStream ::AudioCallback]
        ::mem/void)

(defcfn detach-audio-stream-processor
        "Detach audio stream processor from stream"
        "DetachAudioStreamProcessor"
        [::AudioStream ::AudioCallback]
        ::mem/void)
