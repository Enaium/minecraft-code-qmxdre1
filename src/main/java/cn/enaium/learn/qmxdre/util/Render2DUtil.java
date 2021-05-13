package cn.enaium.learn.qmxdre.util;

import net.minecraft.client.gui.Gui;

/**
 * @author Enaium
 */
public class Render2DUtil {
    public static void drawRect(int x, int y, int width, int height, int color) {
        Gui.drawRect(x, y, x + width, y + height, color);
    }

    public static boolean isHovered(int mouseX, int mouseY, int x, int y, int width, int height) {
        return mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
    }
}
