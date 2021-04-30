package cn.enaium.learn.qmxdre.module.modules.movement;

import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import org.lwjgl.input.Keyboard;

/**
 * @author Enaium
 */
public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Type.OTHER, Keyboard.KEY_V);
    }

    @Override
    public void onEnable() {
        System.out.println("Sprint onEnable");
    }

    @Override
    public void onDisable() {
        System.out.println("Sprint onDisable");
    }
}
