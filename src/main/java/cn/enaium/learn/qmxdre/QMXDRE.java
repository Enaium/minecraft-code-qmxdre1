package cn.enaium.learn.qmxdre;

import org.lwjgl.opengl.Display;

/**
 * @author Enaium
 */
public enum QMXDRE {

    INSTANCE;

    public static final String NAME = "QMXD";

    public static final String VERSION = "RE1";

    public void run() {
        Display.setTitle(NAME + " | " + VERSION);
    }

    public void stop() {

    }

}
