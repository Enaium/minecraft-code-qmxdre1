package cn.enaium.learn.qmxdre.util;

import cn.enaium.learn.qmxdre.QMXDRE;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

/**
 * @author Enaium
 */
public class ChatUtil {
    public static void message(String message) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(ChatFormatting.YELLOW + "[" + QMXDRE.NAME + "]" + ChatFormatting.WHITE + message));
    }
}
