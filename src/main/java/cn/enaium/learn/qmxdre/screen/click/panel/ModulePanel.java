package cn.enaium.learn.qmxdre.screen.click.panel;

import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.modules.render.HUD;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;

import java.awt.*;

/**
 * @author Enaium
 */
public class ModulePanel {

    private final Module module;

    private boolean hovered = false;

    public ModulePanel(Module module) {
        this.module = module;
    }

    public void drawScreen(int mouseX, int mouseY, int x, int y) {

        hovered = Render2DUtil.isHovered(mouseX, mouseY, x, y, HUD.getMaxModule(), FontUtil.getHeight());

        int color = new Color(63, 55, 175, 150).getRGB();

        if (hovered) {
            color = new Color(63, 55, 175, 200).getRGB();
        }

        Render2DUtil.drawRect(x, y, HUD.getMaxModule(), FontUtil.getHeight(), color);
        FontUtil.draw(module.getName(), x, y, 0xFFFFFF);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (hovered) {
            module.enable();
        }
    }
}
