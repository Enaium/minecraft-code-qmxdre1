package cn.enaium.learn.qmxdre;

import cn.enaium.learn.qmxdre.command.CommandManager;
import cn.enaium.learn.qmxdre.module.ModuleManager;
import com.google.common.eventbus.EventBus;
import org.lwjgl.opengl.Display;

/**
 * @author Enaium
 */
public enum QMXDRE {

    INSTANCE;

    public static final String NAME = "QMXD";

    public static final String VERSION = "RE1";

    public EventBus event;
    public ModuleManager module;
    public CommandManager command;



    public void run() {
        event = new EventBus();
        module = new ModuleManager();
        command = new CommandManager();
        Display.setTitle(NAME + " | " + VERSION);
        module.load();
        command.load();
    }

    public void stop() {

    }

}
