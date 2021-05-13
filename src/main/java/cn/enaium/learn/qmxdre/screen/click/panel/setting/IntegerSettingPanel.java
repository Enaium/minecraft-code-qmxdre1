package cn.enaium.learn.qmxdre.screen.click.panel.setting;

import cn.enaium.learn.qmxdre.module.Setting;
import cn.enaium.learn.qmxdre.module.settings.IntegerSetting;
import cn.enaium.learn.qmxdre.util.FontUtil;
import cn.enaium.learn.qmxdre.util.Render2DUtil;
import net.minecraft.util.MathHelper;

import java.awt.*;

/**
 * @author Enaium
 */
public class IntegerSettingPanel extends SettingPanel {

    private boolean hovered = false;

    private boolean sliderHovered = false;

    private boolean dragging = false;

    private int offsetX = 0;

    public IntegerSettingPanel(Setting setting) {
        super(setting);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {

        hovered = Render2DUtil.isHovered(mouseX, mouseY, x, y, getMaxSetting(), FontUtil.getHeight());

        int color = new Color(47, 82, 180, 150).getRGB();

        if (hovered) {
            color = new Color(47, 82, 180, 190).getRGB();
        }

        Render2DUtil.drawRect(x, y, getMaxSetting(), FontUtil.getHeight(), color);


        IntegerSetting setting = (IntegerSetting) this.setting;
        if (dragging) {
            offsetX = MathHelper.clamp_int(mouseX - x, 0, getMaxSetting() - 10);

            int value = setting.getMax() - setting.getMin();
            double val = setting.getMin() + (MathHelper.clamp_double((mouseX - x) / (double) getMaxSetting(), 0, 1)) * value;
            setting.setCurrent((int) val);
        }

        Render2DUtil.drawRect(x + offsetX, y, 10, FontUtil.getHeight(), new Color(255, 255, 0).getRGB());

        FontUtil.draw(this.setting.getName() + ":" + setting.getCurrent(), x, y, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, x, y);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (hovered && mouseButton == 0) {
            dragging = true;
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        dragging = false;
        super.mouseReleased(mouseX, mouseY, state);
    }
}
