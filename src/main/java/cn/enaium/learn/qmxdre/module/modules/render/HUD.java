package cn.enaium.learn.qmxdre.module.modules.render;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.event.Events;
import cn.enaium.learn.qmxdre.event.Events.KeyboardEvent;
import cn.enaium.learn.qmxdre.event.Events.Render2DEvent;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Type;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Enaium
 */
public class HUD extends Module {

    private final ArrayList<Tab> tabs;

    private final Minecraft mc = Minecraft.getMinecraft();

    private int selectTab = 0;

    private boolean sub = false;

    private int selectSub = 0;

    public HUD() {
        super("HUD", Type.RENDER, Keyboard.KEY_O);

        tabs = new ArrayList<>();

        for (Type type : Type.values()) {
            Tab tab = new Tab(type.name().substring(0, 1).toUpperCase(Locale.ROOT)
                    + type.name().substring(1).toLowerCase(Locale.ROOT));

            QMXDRE.INSTANCE.module.getModuleByType(type).
                    forEach(it -> tab.sub.add(new Tab(it.getName())));

            tabs.add(tab);
        }
    }

    @Subscribe
    public void tabGui(Render2DEvent event) {
        int typeY = 5;
        int indexY = 0;
        int tabX = 5;
        for (Tab tab : tabs) {
            mc.fontRendererObj.drawString(tab.name, 5, typeY, 0xFFFFFF);

            if (indexY == selectTab) {
                drawRect(tabX, typeY, getMaxType(), mc.fontRendererObj.FONT_HEIGHT, new Color(20, 100, 190, 150).getRGB());

                if (sub) {
                    int moduleY = typeY;
                    int moduleIndex = 0;
                    for (Tab subTab : tab.sub) {
                        mc.fontRendererObj.drawString(subTab.name, tabX + getMaxType(), moduleY, 0xFFFFFF);

                        if (moduleIndex == selectSub) {
                            drawRect(tabX + getMaxType(), moduleY, getMaxModule(), mc.fontRendererObj.FONT_HEIGHT, new Color(20, 100, 190, 150).getRGB());
                        }

                        moduleIndex++;
                        moduleY += mc.fontRendererObj.FONT_HEIGHT;
                    }
                }
            }

            indexY++;
            typeY += mc.fontRendererObj.FONT_HEIGHT;
        }
    }

    @Subscribe
    public void enableList(Render2DEvent event) {
        ScaledResolution sr = new ScaledResolution(mc);
        int[] y = new int[]{5};
        QMXDRE.INSTANCE.module.getModules().stream().
                filter(Module::getEnable).
                sorted((o1, o2) -> mc.fontRendererObj.getStringWidth(o2.getName())
                        - mc.fontRendererObj.getStringWidth(o1.getName())).
                forEach(it -> {
                    mc.fontRendererObj.drawString(it.getName(), sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(it.getName()), y[0], 0xFFFFFF);
                    y[0] += mc.fontRendererObj.FONT_HEIGHT;
                });
    }

    private void up() {
        if (!sub) {
            if (selectTab > 0) {
                selectTab--;
            } else {
                selectTab = Type.values().length - 1;
            }
        } else {
            if (selectSub > 0) {
                selectSub--;
            } else {
                selectSub = QMXDRE.INSTANCE.module.getModuleByType(Type.values()[selectTab]).size() - 1;
            }
        }
    }

    private void down() {
        if (!sub) {
            if (selectTab < Type.values().length - 1) {
                selectTab++;
            } else {
                selectTab = 0;
            }
        } else {
            if (selectSub < QMXDRE.INSTANCE.module.getModuleByType(Type.values()[selectTab]).size() - 1) {
                selectSub++;
            } else {
                selectSub = 0;
            }
        }
    }

    private void left() {
        sub = false;
    }

    private void right() {
        sub = true;
        selectSub = 0;
    }

    private void enter() {
        if (sub) {
            QMXDRE.INSTANCE.module.getModuleByType(Type.values()[selectTab]).get(selectSub).enable();
        }
    }

    @Subscribe
    public void onKey(KeyboardEvent event) {
        switch (event.getKey()) {
            case Keyboard.KEY_UP:
                up();
                break;
            case Keyboard.KEY_DOWN:
                down();
                break;
            case Keyboard.KEY_LEFT:
                left();
                break;
            case Keyboard.KEY_RIGHT:
                right();
                break;
            case Keyboard.KEY_RETURN:
                enter();
                break;
        }
    }

    private int getMaxModule() {
        ArrayList<Module> modules = QMXDRE.INSTANCE.module.getModules();
        modules.sort((o1, o2) -> mc.fontRendererObj.getStringWidth(o2.getName()) - mc.fontRendererObj.getStringWidth(o1.getName()));
        return mc.fontRendererObj.getStringWidth(modules.get(0).getName());
    }

    private int getMaxType() {
        List<Type> collect = Arrays.stream(Type.values()).
                sorted((o1, o2) -> mc.fontRendererObj.getStringWidth(o2.name())
                        - mc.fontRendererObj.getStringWidth(o1.name())).collect(Collectors.toList());
        return mc.fontRendererObj.getStringWidth(collect.get(0).name());
    }

    private void drawRect(int x, int y, int width, int height, int color) {
        Gui.drawRect(x, y, x + width, y + height, color);
    }

    private static class Tab {
        private final String name;

        private final ArrayList<Tab> sub = new ArrayList<>();

        private Tab(String name) {
            this.name = name;
        }
    }
}
