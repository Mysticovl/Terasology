/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.rendering.opengl;

import org.terasology.assets.ResourceUrn;

/**
 * TODO: Add javadocs
 */
public enum DefaultDynamicFBOs {
    READ_ONLY_GBUFFER(new FBOConfig(new ResourceUrn("engine:sceneOpaque"), 1.0f, FBO.Type.HDR)
            .useDepthBuffer().useNormalBuffer().useLightBuffer().useStencilBuffer()),
    WRITE_ONLY_GBUFFER(new FBOConfig(new ResourceUrn("engine:sceneOpaquePingPong"), 1.0f, FBO.Type.HDR)
            .useDepthBuffer().useNormalBuffer().useLightBuffer().useStencilBuffer()),
    FINAL(new FBOConfig(new ResourceUrn("engine:sceneFinal"), 1.0f, FBO.Type.DEFAULT));

    private final FBOConfig fboConfig;
    private FBO fbo;

    DefaultDynamicFBOs(FBOConfig fboConfig) {
        this.fboConfig = fboConfig;
    }

    public FBOConfig getConfig() {
        return fboConfig;
    }

    public ResourceUrn getName() {
        return fboConfig.getName();
    }

    public FBO getFbo() {
        return fbo;
    }

    public void setFbo(FBO fbo) {
        this.fbo = fbo;
    }

    @Override
    public String toString() {
        return getName().toString();
    }

    public int height() {
        return fbo.height();
    }

    public int width() {
        return fbo.width();
    }

    public void bind() {
        fbo.bind();
    }

    public void setRenderBufferMask(boolean color, boolean normal, boolean lightBuffer) {
        fbo.setRenderBufferMask(color, normal, lightBuffer);
    }

    public void bindTexture() {
        fbo.bindTexture();
    }

    public void attachDepthBufferTo(FBO frameBuffersObject) {
        fbo.attachDepthBufferTo(frameBuffersObject);
    }

    public void bindDepthTexture() {
        fbo.bindDepthTexture();
    }

    public void bindNormalsTexture() {
        fbo.bindNormalsTexture();
    }

    public void bindLightBufferTexture() {
        fbo.bindLightBufferTexture();
    }

    public FBO.Dimensions dimensions() {
        return fbo.dimensions();
    }
}
