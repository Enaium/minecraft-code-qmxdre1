package cn.enaium.learn.qmxdre.module.settings;

import cn.enaium.learn.qmxdre.module.Setting;

/**
 * @author Enaium
 */
public class EnableSetting extends Setting {
    private boolean enable;

    public EnableSetting(String name, boolean enable) {
        super(name);
        this.enable = enable;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
