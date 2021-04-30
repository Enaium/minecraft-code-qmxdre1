package cn.enaium.learn.qmxdre.module;

/**
 * @author Enaium
 */
public class Module {
    private final String name;
    private final Type type;
    private int key;

    private boolean enable;

    public Module(String name, Type type, int key) {
        this.name = name;
        this.type = type;
        this.key = key;
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

    public void enable() {
        this.enable = !this.enable;
        if (this.enable) {
            onEnable();
        } else {
            onDisable();
        }
    }

    protected void onEnable() {

    }

    protected void onDisable() {

    }
}
