/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.spruceui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import me.lambdaurora.spruceui.Position;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Represents a textured button widget.
 *
 * @author LambdAurora
 * @version 1.7.0
 * @since 1.7.0
 */
public class SpruceTexturedButtonWidget extends SpruceButtonWidget {
    private final Identifier texture;
    private final int u;
    private final int v;
    private final int hoveredVOffset;
    private final int textureWidth;
    private final int textureHeight;

    public SpruceTexturedButtonWidget(Position position, int width, int height, PressAction action, int u, int v, int hoveredVOffset, Identifier texture) {
        this(position, width, height, action, u, v, hoveredVOffset, texture, 256, 256);
    }

    public SpruceTexturedButtonWidget(Position position, int width, int height, PressAction action, int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight) {
        this(position, width, height, LiteralText.EMPTY, action, u, v, hoveredVOffset, texture, textureWidth, textureHeight);
    }

    public SpruceTexturedButtonWidget(Position position, int width, int height, Text message, PressAction action, int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight) {
        super(position, width, height, message, action);
        this.texture = texture;
        this.u = u;
        this.v = v;
        this.hoveredVOffset = hoveredVOffset;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    @Override
    protected void renderBackground(MatrixStack matrices, int mouseX, int mouseY) {
        this.client.getTextureManager().bindTexture(this.texture);
        int v = this.v;
        if (this.isFocusedOrHovered()) {
            v += this.hoveredVOffset;
        }

        RenderSystem.color4f(1.f, 1.f, 1.f, this.getAlpha());
        RenderSystem.enableDepthTest();
        drawTexture(matrices, this.getX(), this.getY(), this.u, v, this.getWidth(), this.getHeight(), this.textureWidth, this.textureHeight);
    }

    @Override
    public String toString() {
        return "SpruceButtonWidget{" +
                "position=" + this.getPosition() +
                ", width=" + this.getWidth() +
                ", height=" + this.getHeight() +
                ", visible=" + this.isVisible() +
                ", active=" + this.isActive() +
                ", message=" + this.getMessage() +
                ", focused=" + this.isFocused() +
                ", hovered=" + this.isMouseHovered() +
                ", wasHovered=" + this.wasHovered +
                ", dragging=" + this.dragging +
                ", lastDrag=" + this.lastDrag +
                ", alpha=" + this.getAlpha() +
                ", texture=" + this.texture +
                ", u=" + this.u +
                ", v=" + this.v +
                ", hoveredVOffset=" + this.hoveredVOffset +
                ", textureWidth=" + this.textureWidth +
                ", textureHeight=" + this.textureHeight +
                '}';
    }
}
