package cn.enaium.learn.qmxdre.module.settings;

import cn.enaium.learn.qmxdre.module.Setting;

import java.util.List;

/**
 * @author Enaium
 */
public class ModeSetting extends Setting {

    private String current;
    private final List<String> modes;

    public ModeSetting(String name, String current, List<String> modes) {
        super(name);
        this.current = current;
        this.modes = modes;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public List<String> getModes() {
        return modes;
    }

    public int getCurrentIndex() {
        int index = 0;
        for (String mode : modes) {
            if (mode.equalsIgnoreCase(current)) {
                return index;
            }
            index++;
        }
        return 0;
    }
}
