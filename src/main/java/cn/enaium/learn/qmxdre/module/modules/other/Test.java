package cn.enaium.learn.qmxdre.module.modules.other;

import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import cn.enaium.learn.qmxdre.module.settings.EnableSetting;
import cn.enaium.learn.qmxdre.module.settings.IntegerSetting;
import cn.enaium.learn.qmxdre.module.settings.ModeSetting;

import java.util.Arrays;

/**
 * @author Enaium
 */
public class Test extends Module {

    private final EnableSetting setting1 = new EnableSetting("Setting1", true);
    private final IntegerSetting setting2 = new IntegerSetting("Setting2", 1, 1, 10);
    private final ModeSetting setting3 = new ModeSetting("Setting3", "Mode1", Arrays.asList("Mode1", "Mode2", "Mode3"));

    public Test() {
        super("Test", Type.OTHER, 0);
        getSetting().add(setting1);
        getSetting().add(setting2);
        getSetting().add(setting3);
    }


}
