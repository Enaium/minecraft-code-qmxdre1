package cn.enaium.learn.qmxdre.module.settings;

import cn.enaium.learn.qmxdre.module.Setting;

/**
 * @author Enaium
 */
public class IntegerSetting extends Setting {
    private final int min;
    private final int max;
    private int current;

    public IntegerSetting(String name, int current, int min, int max) {
        super(name);
        this.current = current;
        this.min = min;
        this.max = max;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
