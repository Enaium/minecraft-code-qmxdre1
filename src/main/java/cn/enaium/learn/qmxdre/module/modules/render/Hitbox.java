package cn.enaium.learn.qmxdre.module.modules.render;

import cn.enaium.learn.qmxdre.event.Events;
import cn.enaium.learn.qmxdre.event.Events.Render3DEvent;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;

/**
 * @author Enaium
 */
public class Hitbox extends Module {
    public Hitbox() {
        super("Hitbox", Type.RENDER, 0);
    }

    @Subscribe
    public void render(Render3DEvent event) {
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (!(entity instanceof EntityPlayerSP)) {
                AxisAlignedBB bb = entity.getEntityBoundingBox();
                RenderGlobal.func_181563_a(new AxisAlignedBB(bb.minX - RenderManager.renderPosX, bb.minY - RenderManager.renderPosY, bb.minZ - RenderManager.renderPosZ,
                        bb.maxX - RenderManager.renderPosX, bb.maxY - RenderManager.renderPosY, bb.maxZ - RenderManager.renderPosZ), 255, 255, 255, 255);
            }
        }
    }
}
