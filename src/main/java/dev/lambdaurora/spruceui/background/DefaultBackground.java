package dev.lambdaurora.spruceui.background;


import com.mojang.blaze3d.systems.RenderSystem;
import dev.lambdaurora.spruceui.widget.SpruceWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;

/**
 * Default background that is
 * @param isList
 */
public record DefaultBackground(boolean isList) implements Background {
    public static final DefaultBackground LIST = new DefaultBackground(true);
    public static final DefaultBackground DEFAULT = new DefaultBackground(false);

    public static final Identifier MENU_LIST_BG = new Identifier("textures/gui/menu_list_background.png");
    public static final Identifier INWORLD_MENU_LIST_BG = new Identifier("textures/gui/inworld_menu_list_background.png");
    public static final Identifier INWORLD_MENU_BG = new Identifier("textures/gui/inworld_menu_background.png");

    private Identifier getIdentifier(boolean inWorld){
        if (isList) {
            return inWorld ? MENU_LIST_BG : INWORLD_MENU_LIST_BG;
        } else {
            return inWorld ? INWORLD_MENU_BG : Screen.MENU_BACKGROUND;
        }
    }

    @Override
    public void render(GuiGraphics graphics, SpruceWidget widget, int vOffset, int mouseX, int mouseY, float delta) {
        RenderSystem.enableBlend();
        Identifier identifier = getIdentifier(MinecraftClient.getInstance().world != null);
        graphics.drawTexture(identifier, widget.getX(), widget.getY(), widget.getXEnd(), widget.getYEnd() + vOffset, widget.getWidth(), widget.getHeight(), 32, 32);
        RenderSystem.disableBlend();
    }
}
