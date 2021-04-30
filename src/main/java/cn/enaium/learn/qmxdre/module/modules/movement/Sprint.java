package cn.enaium.learn.qmxdre.module.modules.movement;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import cn.enaium.learn.qmxdre.module.settings.EnableSetting;
import org.lwjgl.input.Keyboard;

/**
 * @author Enaium
 */
public class Sprint extends Module {

    private final EnableSetting enable = new EnableSetting("setting1", false);

    public Sprint() {
        super("Sprint", Type.OTHER, Keyboard.KEY_V);
        getSetting().add(enable);
    }

    @Override
    public void onEnable() {
        enable.setEnable(true);
        System.out.println("Sprint onEnable");
    }

    @Override
    public void onDisable() {
        System.out.println(enable.getEnable());
        if (QMXDRE.INSTANCE.module.getSettingByName(this, "setting1") instanceof EnableSetting) {
            System.out.println("setting1:" + enable.getEnable());
        }
        System.out.println("Sprint onDisable");
    }
}
