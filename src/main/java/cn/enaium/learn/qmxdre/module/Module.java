package cn.enaium.learn.qmxdre.module;

import cn.enaium.learn.qmxdre.QMXDRE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enaium
 */
public class Module {
    private final String name;
    private final Type type;
    private int key;

    private final List<Setting> setting;

    private boolean enable;

    public Module(String name, Type type, int key) {
        this.name = name;
        this.type = type;
        this.key = key;
        setting = new ArrayList<>();
        enable = false;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean getEnable() {
        return enable;
    }

    public List<Setting> getSetting() {
        return setting;
    }

    public void enable() {
        this.enable = !this.enable;
        if (this.enable) {
            onEnable();
        } else {
            onDisable();
        }
    }

    protected void onEnable() {
        QMXDRE.INSTANCE.event.register(this);
    }

    protected void onDisable() {
        QMXDRE.INSTANCE.event.unregister(this);
    }
}
