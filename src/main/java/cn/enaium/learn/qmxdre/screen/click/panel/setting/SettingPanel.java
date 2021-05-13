package cn.enaium.learn.qmxdre.screen.click.panel.setting;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.module.Setting;
import cn.enaium.learn.qmxdre.module.modules.render.HUD;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enaium
 */
public class SettingPanel {
    protected final Setting setting;

    public SettingPanel(Setting setting) {
        this.setting = setting;
    }

    public void drawScreen(int mouseX, int mouseY, int x, int y) {

    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {

    }

    public void mouseReleased(int mouseX, int mouseY, int state) {

    }

    public int getMaxSetting() {
        List<Setting> settings = new ArrayList<>();
        QMXDRE.INSTANCE.module.getModules().forEach(it -> settings.addAll(it.getSetting()));
        settings.sort((o1, o2) -> FontUtil.getWidth(o2.getName()) - FontUtil.getWidth(o1.getName()));
        return FontUtil.getWidth(settings.get(0).getName()) + 50;
    }
}
