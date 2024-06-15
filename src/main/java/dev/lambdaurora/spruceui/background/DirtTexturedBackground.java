/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.background;

import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.util.RenderUtil;
import dev.lambdaurora.spruceui.widget.SpruceWidget;
import net.minecraft.client.gui.GuiGraphics;

public record DirtTexturedBackground(int red, int green, int blue, int alpha) implements Background, ScreenBackground {
	public static final DirtTexturedBackground NORMAL = new DirtTexturedBackground(64, 64, 64, 255);
	public static final DirtTexturedBackground DARKENED = new DirtTexturedBackground(32, 32, 32, 255);

	@Override
	public void render(GuiGraphics graphics, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta) {
		RenderUtil.renderBackgroundTexture(widget.getX(), widget.getY(), widget.getWidth(), widget.getHeight(),
				vOffset / 32.f, this.red, this.green, this.blue, this.alpha);
	}

	@Override
	public void render(GuiGraphics graphics, SpruceScreen screen, int mouseX, int mouseY, float delta) {
		RenderUtil.renderBackgroundTexture(screen.getX(), screen.getY(), screen.width, screen.height,
				0, this.red, this.green, this.blue, this.alpha);
	}

	@Override
	public String toString() {
		return "DirtTexturedBackground{" +
				"red=" + this.red +
				", green=" + this.green +
				", blue=" + this.blue +
				", alpha=" + this.alpha +
				'}';
	}
}
