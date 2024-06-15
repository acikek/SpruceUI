package dev.lambdaurora.spruceui.background;

import dev.lambdaurora.spruceui.screen.SpruceScreen;
import net.minecraft.client.gui.GuiGraphics;

public interface ScreenBackground {
    void render(GuiGraphics graphics, SpruceScreen screen, int mouseX, int mouseY, float delta);
}
