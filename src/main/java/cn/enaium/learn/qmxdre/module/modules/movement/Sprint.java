package cn.enaium.learn.qmxdre.module.modules.movement;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.event.Events;
import cn.enaium.learn.qmxdre.event.Events.UpdateEvent;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import cn.enaium.learn.qmxdre.module.settings.EnableSetting;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

/**
 * @author Enaium
 */
public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Type.MOVEMENT, Keyboard.KEY_V);
    }

    @Subscribe
    public void onUpdate(UpdateEvent event) {
        Minecraft.getMinecraft().thePlayer.setSprinting(true);
    }
}
