package cn.enaium.learn.qmxdre.screen.click.panel;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import cn.enaium.learn.qmxdre.module.modules.render.HUD;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Enaium
 */
public class TypePanel {
    private final String name;
    private int x;
    private int y;

    private int prevX;
    private int prevY;

    private boolean hovered = false;
    private boolean dragging = false;

    private final List<ModulePanel> modulePanelList = new ArrayList<>();
    private boolean module = false;

    public TypePanel(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;

        ArrayList<Module> moduleByType = QMXDRE.INSTANCE.module.getModuleByType(Type.valueOf(name.toUpperCase(Locale.ROOT)));
        moduleByType.forEach(it -> modulePanelList.add(new ModulePanel(it)));
    }


    public String getName() {
        return name;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        hovered = Render2DUtil.isHovered(mouseX, mouseY, x, y, HUD.getMaxType(), FontUtil.getHeight());

        int color = new Color(63, 55, 175, 150).getRGB();

        if (hovered) {
            color = new Color(63, 55, 175, 200).getRGB();
        }


        if (dragging) {
            x = mouseX - prevX;
            y = mouseY - prevY;
        }

        Render2DUtil.drawRect(x, y, HUD.getMaxType(), FontUtil.getHeight(), color);
        FontUtil.draw(name, x, y, 0xFFFFFF);

        if (module) {
            int moduleY = y;
            for (ModulePanel modulePanel : modulePanelList) {
                modulePanel.drawScreen(mouseX, mouseY, x, moduleY + FontUtil.getHeight());
                moduleY += FontUtil.getHeight();
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && hovered) {
            prevX = mouseX - x;
            prevY = mouseY - y;
            dragging = true;
        } else if (mouseButton == 1 && hovered) {
            module = !module;
        }
        modulePanelList.forEach(it -> it.mouseClicked(mouseX, mouseY, mouseButton));
    }


    public void mouseReleased(int mouseX, int mouseY, int state) {
        dragging = false;
    }
}
