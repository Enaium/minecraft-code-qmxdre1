package cn.enaium.learn.qmxdre.screen.click;

import cn.enaium.learn.qmxdre.module.Type;
import cn.enaium.learn.qmxdre.screen.click.panel.TypePanel;
import cn.enaium.learn.qmxdre.util.FontUtil;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Enaium
 */
public class GUI extends GuiScreen {

    private final List<TypePanel> typePanelList = new ArrayList<>();

    public GUI() {
        int y = 0;
        for (Type value : Type.values()) {
            typePanelList.add(new TypePanel(value.name().charAt(0) + value.name().substring(1).toLowerCase(Locale.ROOT), 5, y));
            y += FontUtil.getHeight() + 5;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        typePanelList.forEach(it -> it.drawScreen(mouseX, mouseY, partialTicks));
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        typePanelList.forEach(it -> it.mouseClicked(mouseX, mouseY, mouseButton));
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        typePanelList.forEach(it -> it.mouseReleased(mouseX, mouseY, state));
        super.mouseReleased(mouseX, mouseY, state);
    }
}
