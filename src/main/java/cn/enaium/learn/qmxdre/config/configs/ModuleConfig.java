package cn.enaium.learn.qmxdre.config.configs;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.config.Config;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Setting;
import cn.enaium.learn.qmxdre.module.settings.EnableSetting;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * @author Enaium
 */
public class ModuleConfig extends Config {
    public ModuleConfig() {
        super("Module");
    }

    @Override
    public void load() {
        JsonObject jsonObject = new Gson().fromJson(read(getFile()), JsonObject.class);
        for (Module module : QMXDRE.INSTANCE.module.getModules()) {
            if (jsonObject.has(module.getName())) {
                JsonObject moduleObject = jsonObject.get(module.getName()).getAsJsonObject();
                module.setKey(moduleObject.get("key").getAsInt());
                if (moduleObject.get("enable").getAsBoolean()) {
                    module.enable();
                }

                if (!module.getSetting().isEmpty()) {
                    if (moduleObject.has("setting")) {
                        JsonObject settingObject = moduleObject.get("setting").getAsJsonObject();
                        for (Setting setting : module.getSetting()) {
                            if (settingObject.has(setting.getName())) {
                                if (setting instanceof EnableSetting) {
                                    ((EnableSetting) setting).setEnable(settingObject.get(setting.getName()).getAsBoolean());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void save() {
        JsonObject jsonObject = new JsonObject();
        for (Module module : QMXDRE.INSTANCE.module.getModules()) {
            JsonObject moduleObject = new JsonObject();
            moduleObject.addProperty("enable", module.getEnable());
            moduleObject.addProperty("key", module.getKey());

            if (!module.getSetting().isEmpty()) {
                JsonObject settingObject = new JsonObject();
                for (Setting setting : module.getSetting()) {
                    if (setting instanceof EnableSetting) {
                        settingObject.addProperty(setting.getName(), ((EnableSetting) setting).getEnable());
                    }
                }
                moduleObject.add("setting", settingObject);
            }
            jsonObject.add(module.getName(), moduleObject);
        }
        write(getFile(), jsonObject.toString());
    }
}
