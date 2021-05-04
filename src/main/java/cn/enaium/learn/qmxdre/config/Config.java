package cn.enaium.learn.qmxdre.config;

import cn.enaium.learn.qmxdre.QMXDRE;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Enaium
 */
public abstract class Config {
    private final String name;

    public Config(String name) {
        this.name = name;
    }

    protected abstract void load();

    protected abstract void save();

    public void write(File file, String text) {
        try {
            FileUtils.write(file, text, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(File file) {
        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getFile() {
        File clientDir = new File(Minecraft.getMinecraft().mcDataDir, QMXDRE.NAME);
        if (!clientDir.exists()) {
            clientDir.mkdir();
        }

        File configFile = new File(clientDir, name + ".json");
        if (!configFile.exists()) {
            try {
                clientDir.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configFile;
    }
}
