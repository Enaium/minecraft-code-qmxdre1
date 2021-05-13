package cn.enaium.learn.qmxdre.screen.click.panel.setting;

import cn.enaium.learn.qmxdre.module.Setting;
import cn.enaium.learn.qmxdre.module.settings.ModeSetting;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;

import java.awt.*;

/**
 * @author Enaium
 */
public class ModeSettingPanel extends SettingPanel {

    private boolean hovered = false;

    public ModeSettingPanel(Setting setting) {
        super(setting);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {

        hovered = Render2DUtil.isHovered(mouseX, mouseY, x, y, getMaxSetting(), FontUtil.getHeight());

        int color = new Color(47, 82, 180, 150).getRGB();

        if (hovered) {
            color = new Color(47, 82, 180, 190).getRGB();
        }

        Render2DUtil.drawRect(x, y, getMaxSetting(), FontUtil.getHeight(), color);
        FontUtil.draw(setting.getName() + ":" + ((ModeSetting) setting).getCurrent(), x, y, 0xFFFFFF);


        super.drawScreen(mouseX, mouseY, x, y);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && hovered) {
            ModeSetting setting = (ModeSetting) this.setting;
            if (setting.getCurrentIndex() >= 0) {
                try {
                    setting.setCurrent(setting.getModes().get(setting.getCurrentIndex() + 1));
                } catch (Throwable throwable) {
                    setting.setCurrent(setting.getModes().get(0));
                }
            }
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        if (state == 1 && hovered) {
            ModeSetting setting = (ModeSetting) this.setting;
            if (setting.getCurrentIndex() <= setting.getModes().size() - 1) {
                try {
                    setting.setCurrent(setting.getModes().get(setting.getCurrentIndex() - 1));
                } catch (Throwable throwable) {
                    setting.setCurrent(setting.getModes().get(setting.getModes().size() - 1));
                }
            }
        }
        super.mouseReleased(mouseX, mouseY, state);
    }
}
