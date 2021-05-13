package cn.enaium.learn.qmxdre.screen.click.panel;

import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.modules.render.HUD;
import cn.enaium.learn.qmxdre.module.settings.EnableSetting;
import cn.enaium.learn.qmxdre.module.settings.IntegerSetting;
import cn.enaium.learn.qmxdre.module.settings.ModeSetting;
import cn.enaium.learn.qmxdre.screen.click.panel.setting.EnableSettingPanel;
import cn.enaium.learn.qmxdre.screen.click.panel.setting.IntegerSettingPanel;
import cn.enaium.learn.qmxdre.screen.click.panel.setting.ModeSettingPanel;
import cn.enaium.learn.qmxdre.screen.click.panel.setting.SettingPanel;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Enaium
 */
public class ModulePanel {

    private final Module module;

    private boolean hovered = false;

    private boolean setting = false;

    private final List<SettingPanel> settingPanelList = new ArrayList<>();

    public ModulePanel(Module module) {
        this.module = module;

        if (!module.getSetting().isEmpty()) {
            module.getSetting().forEach(it -> {
                if (it instanceof EnableSetting) {
                    settingPanelList.add(new EnableSettingPanel(it));
                } else if (it instanceof IntegerSetting) {
                    settingPanelList.add(new IntegerSettingPanel(it));
                } else if (it instanceof ModeSetting) {
                    settingPanelList.add(new ModeSettingPanel(it));
                }
            });
        }
    }

    public void drawScreen(int mouseX, int mouseY, int x, int y) {

        hovered = Render2DUtil.isHovered(mouseX, mouseY, x, y, HUD.getMaxModule(), FontUtil.getHeight());

        int color = new Color(63, 55, 175, 150).getRGB();

        if (hovered) {
            color = new Color(63, 55, 175, 200).getRGB();
        }

        Render2DUtil.drawRect(x, y, HUD.getMaxModule(), FontUtil.getHeight(), color);
        FontUtil.draw(module.getName(), x, y, 0xFFFFFF);

        if (setting && !settingPanelList.isEmpty()) {
            int settingY = y;
            for (SettingPanel it : settingPanelList) {
                it.drawScreen(mouseX, mouseY, x + HUD.getMaxModule(), settingY);
                settingY += FontUtil.getHeight();
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && hovered) {
            module.enable();
        } else if (mouseButton == 1 && hovered) {
            setting = !setting;
        }
        if (setting && !settingPanelList.isEmpty()) {
            settingPanelList.forEach(it -> it.mouseClicked(mouseX, mouseY, mouseButton));
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
        if (setting && !settingPanelList.isEmpty()) {
            settingPanelList.forEach(it -> it.mouseReleased(mouseX, mouseY, state));
        }
    }
}
