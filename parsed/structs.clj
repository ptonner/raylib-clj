(defalias ::Quaternion ::Vector4)

(defalias ::Texture2D ::Texture)

(defalias ::TextureCubemap ::Texture)

(defalias ::RenderTexture2D ::RenderTexture)

(defalias ::Camera ::Camera3D)(defalias ::Vector2
          (layout/with-c-layout
            [::mem/struct [[:x ::mem/float] [:y ::mem/float]]]))

(defalias ::Vector3
          (layout/with-c-layout [::mem/struct
                                 [[:x ::mem/float] [:y ::mem/float]
                                  [:z ::mem/float]]]))

(defalias ::Vector4
          (layout/with-c-layout
            [::mem/struct
             [[:x ::mem/float] [:y ::mem/float] [:z ::mem/float]
              [:w ::mem/float]]]))

(defalias
  ::Matrix
  (layout/with-c-layout
    [::mem/struct
     [[:m0 ::mem/float] [:m4 ::mem/float] [:m8 ::mem/float]
      [:m12 ::mem/float] [:m1 ::mem/float] [:m5 ::mem/float]
      [:m9 ::mem/float] [:m13 ::mem/float] [:m2 ::mem/float]
      [:m6 ::mem/float] [:m10 ::mem/float] [:m14 ::mem/float]
      [:m3 ::mem/float] [:m7 ::mem/float] [:m11 ::mem/float]
      [:m15 ::mem/float]]]))

(defalias ::Color
          (layout/with-c-layout [::mem/struct
                                 [[:r ::unsigned-char]
                                  [:g ::unsigned-char]
                                  [:b ::unsigned-char]
                                  [:a ::unsigned-char]]]))

(defalias ::Rectangle
          (layout/with-c-layout
            [::mem/struct
             [[:x ::mem/float] [:y ::mem/float]
              [:width ::mem/float] [:height ::mem/float]]]))

(defalias
  ::Image
  (layout/with-c-layout [::mem/struct
                         [[:data ::mem/pointer] [:width ::mem/int]
                          [:height ::mem/int] [:mipmaps ::mem/int]
                          [:format ::mem/int]]]))

(defalias
  ::Texture
  (layout/with-c-layout [::mem/struct
                         [[:id ::unsigned-int]
                          [:width ::mem/int] [:height ::mem/int]
                          [:mipmaps ::mem/int] [:format ::mem/int]]]))

(defalias ::RenderTexture
          (layout/with-c-layout [::mem/struct
                                 [[:id ::unsigned-int]
                                  [:texture ::Texture]
                                  [:depth ::Texture]]]))

(defalias ::NPatchInfo
          (layout/with-c-layout
            [::mem/struct
             [[:source ::Rectangle] [:left ::mem/int]
              [:top ::mem/int] [:right ::mem/int]
              [:bottom ::mem/int] [:layout ::mem/int]]]))

(defalias
  ::GlyphInfo
  (layout/with-c-layout [::mem/struct
                         [[:value ::mem/int] [:offsetX ::mem/int]
                          [:offsetY ::mem/int] [:advanceX ::mem/int]
                          [:image ::Image]]]))

(defalias
  ::Font
  (layout/with-c-layout
    [::mem/struct
     [[:baseSize ::mem/int] [:glyphCount ::mem/int]
      [:glyphPadding ::mem/int] [:texture ::Texture2D]
      [:recs [::mem/pointer ::Rectangle]]
      [:glyphs [::mem/pointer ::GlyphInfo]]]]))

(defalias
  ::Camera3D
  (layout/with-c-layout
    [::mem/struct
     [[:position ::Vector3]
      [:target ::Vector3] [:up ::Vector3]
      [:fovy ::mem/float] [:projection ::mem/int]]]))

(defalias
  ::Camera2D
  (layout/with-c-layout
    [::mem/struct
     [[:offset ::Vector2] [:target ::Vector2]
      [:rotation ::mem/float] [:zoom ::mem/float]]]))

(defalias ::Mesh
          (layout/with-c-layout
            [::mem/struct
             [[:vertexCount ::mem/int] [:triangleCount ::mem/int]
              [:vertices [::mem/pointer ::mem/float]]
              [:texcoords [::mem/pointer ::mem/float]]
              [:texcoords2 [::mem/pointer ::mem/float]]
              [:normals [::mem/pointer ::mem/float]]
              [:tangents [::mem/pointer ::mem/float]]
              [:colors ::mem/c-string]
              [:indices [::mem/pointer ::unsigned-short]]
              [:animVertices [::mem/pointer ::mem/float]]
              [:animNormals [::mem/pointer ::mem/float]]
              [:boneIds ::mem/c-string]
              [:boneWeights [::mem/pointer ::mem/float]]
              [:vaoId ::unsigned-int]
              [:vboId [::mem/pointer ::unsigned-int]]]]))

(defalias ::Shader
          (layout/with-c-layout
            [::mem/struct
             [[:id ::unsigned-int]
              [:locs [::mem/pointer ::mem/int]]]]))

(defalias ::MaterialMap
          (layout/with-c-layout
            [::mem/struct
             [[:texture ::Texture2D]
              [:color ::Color] [:value ::mem/float]]]))

(defalias ::Material
          (layout/with-c-layout
            [::mem/struct
             [[:shader ::Shader]
              [:maps [::mem/pointer ::MaterialMap]]
              [:params ::mem/float[4]]]]))

(defalias ::Transform
          (layout/with-c-layout [::mem/struct
                                 [[:translation ::Vector3]
                                  [:rotation ::Quaternion]
                                  [:scale ::Vector3]]]))

(defalias ::BoneInfo
          (layout/with-c-layout [::mem/struct
                                 [[:name ::mem/char[32]]
                                  [:parent ::mem/int]]]))

(defalias ::Model
          (layout/with-c-layout
            [::mem/struct
             [[:transform ::Matrix] [:meshCount ::mem/int]
              [:materialCount ::mem/int]
              [:meshes [::mem/pointer ::Mesh]]
              [:materials [::mem/pointer ::Material]]
              [:meshMaterial [::mem/pointer ::mem/int]]
              [:boneCount ::mem/int]
              [:bones [::mem/pointer ::BoneInfo]]
              [:bindPose [::mem/pointer ::Transform]]]]))

(defalias ::ModelAnimation
          (layout/with-c-layout
            [::mem/struct
             [[:boneCount ::mem/int] [:frameCount ::mem/int]
              [:bones [::mem/pointer ::BoneInfo]]
              [:framePoses
               [::mem/pointer
                [::mem/pointer ::Transform]]]]]))

(defalias ::Ray
          (layout/with-c-layout [::mem/struct
                                 [[:position ::Vector3]
                                  [:direction ::Vector3]]]))

(defalias ::RayCollision
          (layout/with-c-layout
            [::mem/struct
             [[:hit ::bool] [:distance ::mem/float]
              [:point ::Vector3]
              [:normal ::Vector3]]]))

(defalias ::BoundingBox
          (layout/with-c-layout [::mem/struct
                                 [[:min ::Vector3]
                                  [:max ::Vector3]]]))

(defalias ::Wave
          (layout/with-c-layout [::mem/struct
                                 [[:frameCount ::unsigned-int]
                                  [:sampleRate ::unsigned-int]
                                  [:sampleSize ::unsigned-int]
                                  [:channels ::unsigned-int]
                                  [:data ::mem/pointer]]]))

(defalias ::AudioStream
          (layout/with-c-layout
            [::mem/struct
             [[:buffer [::mem/pointer ::mem/rAudioBuffer]]
              [:processor [::mem/pointer ::mem/rAudioProcessor]]
              [:sampleRate ::unsigned-int]
              [:sampleSize ::unsigned-int]
              [:channels ::unsigned-int]]]))

(defalias ::Sound
          (layout/with-c-layout
            [::mem/struct
             [[:stream ::AudioStream]
              [:frameCount ::unsigned-int]]]))

(defalias ::Music
          (layout/with-c-layout
            [::mem/struct
             [[:stream ::AudioStream]
              [:frameCount ::unsigned-int]
              [:looping ::bool] [:ctxType ::mem/int]
              [:ctxData ::mem/pointer]]]))

(defalias
  ::VrDeviceInfo
  (layout/with-c-layout
    [::mem/struct
     [[:hResolution ::mem/int] [:vResolution ::mem/int]
      [:hScreenSize ::mem/float] [:vScreenSize ::mem/float]
      [:vScreenCenter ::mem/float] [:eyeToScreenDistance ::mem/float]
      [:lensSeparationDistance ::mem/float]
      [:interpupillaryDistance ::mem/float]
      [:lensDistortionValues ::mem/float[4]]
      [:chromaAbCorrection ::mem/float[4]]]]))

(defalias ::VrStereoConfig
          (layout/with-c-layout
            [::mem/struct
             [[:projection ::Matrix[2]]
              [:viewOffset ::Matrix[2]]
              [:leftLensCenter ::mem/float[2]]
              [:rightLensCenter ::mem/float[2]]
              [:leftScreenCenter ::mem/float[2]]
              [:rightScreenCenter ::mem/float[2]]
              [:scale ::mem/float[2]] [:scaleIn ::mem/float[2]]]]))

(defalias
  ::FilePathList
  (layout/with-c-layout [::mem/struct
                         [[:capacity ::unsigned-int]
                          [:count ::unsigned-int]
                          [:paths [::mem/pointer ::mem/c-string]]]]))