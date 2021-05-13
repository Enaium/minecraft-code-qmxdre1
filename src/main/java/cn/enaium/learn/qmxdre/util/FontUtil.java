package cn.enaium.learn.qmxdre.util;

import net.minecraft.client.Minecraft;

/**
 * @author Enaium
 */
public class FontUtil {
    public static void draw(String text, int x, int y, int color) {
        Minecraft.getMinecraft().fontRendererObj.drawString(text, x, y, color);
    }

    public static int getWidth(String text) {
        return Minecraft.getMinecraft().fontRendererObj.getStringWidth(text);
    }

    public static int getHeight() {
        return Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT;
    }
}
