package cn.enaium.learn.qmxdre;

import cn.enaium.learn.qmxdre.module.ModuleManager;
import org.lwjgl.opengl.Display;

/**
 * @author Enaium
 */
public enum QMXDRE {

    INSTANCE;

    public static final String NAME = "QMXD";

    public static final String VERSION = "RE1";

    public ModuleManager module;

    public void run() {
        module = new ModuleManager();
        Display.setTitle(NAME + " | " + VERSION);
        module.load();
    }

    public void stop() {

    }

}
