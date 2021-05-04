package cn.enaium.learn.qmxdre.config;

import cn.enaium.learn.qmxdre.config.configs.ModuleConfig;

import java.util.ArrayList;

/**
 * @author Enaium
 */
public class ConfigManager {
    public ArrayList<Config> configs = new ArrayList<>();

    public ConfigManager() {
        configs.add(new ModuleConfig());
    }

    public void load() {
        configs.forEach(Config::load);
    }

    public void save() {
        configs.forEach(Config::save);
    }
}
