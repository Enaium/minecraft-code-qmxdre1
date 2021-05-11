package cn.enaium.learn.qmxdre.module.modules.render;

import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

/**
 * @author Enaium
 */
public class FullBright extends Module {
    public FullBright() {
        super("FillBright", Type.RENDER, Keyboard.KEY_L);
    }

    @Override
    public void onEnable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 300;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 1;
        super.onDisable();
    }
}
