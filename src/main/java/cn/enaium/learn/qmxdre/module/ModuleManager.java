package cn.enaium.learn.qmxdre.module;

import cn.enaium.learn.qmxdre.module.modules.movement.Sprint;

import java.util.ArrayList;

/**
 * @author Enaium
 */
public class ModuleManager {
    private final ArrayList<Module> modules;

    public ModuleManager() {
        modules = new ArrayList<>();
    }

    public void load() {
        modules.add(new Sprint());
    }

    public void onKey(int key) {
        for (Module module : modules) {
            if (module.getKey() == key) {
                module.enable();
            }
        }
    }

    public Setting getSettingByName(Module module, String name) {
        for (Module module1 : modules) {
            if (!module1.equals(module)) continue;
            for (Setting setting : module1.getSetting()) {
                if (setting.getName().equalsIgnoreCase(name)) {
                    return setting;
                }
            }
        }
        return null;
    }
}
