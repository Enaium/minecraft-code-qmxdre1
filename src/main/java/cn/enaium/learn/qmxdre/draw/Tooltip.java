package cn.enaium.learn.qmxdre.draw;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;

import java.awt.*;

/**
 * @author Enaium
 */
public class Tooltip {
    public static void renderTooltip(ScaledResolution sr, float partialTicks) {
        Minecraft mc = Minecraft.getMinecraft();
        int i = sr.getScaledWidth() / 2;
        EntityPlayer entityplayer = (EntityPlayer) mc.getRenderViewEntity();
        int x = 0;
        int y = sr.getScaledHeight() - 22;
        Render2DUtil.drawRect(x, y, sr.getScaledWidth(), 22, new Color(142, 142, 142, 100).getRGB());
        Render2DUtil.drawRect(i - 91 - 1 + entityplayer.inventory.currentItem * 20, sr.getScaledHeight() - 22 - 1, 24, 22, new Color(187, 187, 187, 200).getRGB());

        y += 3;
        x += 5;

        int name = FontUtil.draw(QMXDRE.NAME + " | " + QMXDRE.VERSION, x, y, 0xFFFFFF);
        int fps = FontUtil.draw("FPS:" + Minecraft.getDebugFPS(), x, y + FontUtil.getHeight(), 0xFFFFFF);

        long ping;

        if (mc.getCurrentServerData() != null) {
            ping = mc.getCurrentServerData().pingToServer;
        } else {
            ping = 0;
        }

        FontUtil.draw("Ping:" + ping, x + name, y, 0xFFFFFF);

        FontUtil.draw(String.format("X:%s | Y:%s | Z:%s", Math.round(mc.thePlayer.posX), Math.round(mc.thePlayer.posY), Math.round(mc.thePlayer.posZ)), x + fps, y + FontUtil.getHeight(), 0xFFFFFF);
    }
}
