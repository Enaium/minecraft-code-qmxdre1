package cn.enaium.learn.qmxdre.screen.click.panel.setting;

import cn.enaium.learn.qmxdre.module.Setting;
import cn.enaium.learn.qmxdre.module.modules.render.HUD;
import cn.enaium.learn.qmxdre.module.settings.EnableSetting;
import cn.enaium.learn.qmxdre.module.settings.IntegerSetting;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;

import java.awt.*;

/**
 * @author Enaium
 */
public class EnableSettingPanel extends SettingPanel {

    private boolean hovered = false;

    public EnableSettingPanel(Setting setting) {
        super(setting);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {

        hovered = Render2DUtil.isHovered(mouseX, mouseY, x, y, getMaxSetting(), FontUtil.getHeight());

        int color;

        if (((EnableSetting) setting).getEnable()) {
            color = new Color(0, 255, 0).getRGB();
        } else {
            color = new Color(255, 0, 0).getRGB();
        }

        if (hovered) {
            color = new Color(47, 82, 180, 190).getRGB();
        }

        Render2DUtil.drawRect(x, y, getMaxSetting(), FontUtil.getHeight(), color);
        FontUtil.draw(setting.getName(), x, y, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, x, y);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && hovered) {
            ((EnableSetting) setting).setEnable(!((EnableSetting) setting).getEnable());
        }
    }
}
