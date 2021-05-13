package cn.enaium.learn.qmxdre.module.modules.render;

import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import cn.enaium.learn.qmxdre.screen.click.GUI;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

/**
 * @author Enaium
 */
public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", Type.RENDER, Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        Minecraft.getMinecraft().displayGuiScreen(new GUI());
        enable();
    }
}
