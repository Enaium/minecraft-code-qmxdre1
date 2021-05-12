package cn.enaium.learn.qmxdre.command.commands;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.command.ICommand;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.module.Setting;
import cn.enaium.learn.qmxdre.module.settings.EnableSetting;
import cn.enaium.learn.qmxdre.util.ChatUtil;

/**
 * @author Enaium
 */
public class SetCommand implements ICommand {
    @Override
    public boolean run(String[] args) {
        if (args.length == 1 || args.length == 2 || args.length == 3) {
            Module moduleByName = QMXDRE.INSTANCE.module.getModuleByName(args[0]);
            if (moduleByName == null) {
                ChatUtil.message(args[0] + " Not Found");
                return true;
            }

            if (moduleByName.getSetting().isEmpty()) {
                ChatUtil.message(args[0] + " Not Settings");
                return true;
            }

            if (args.length == 1) {
                moduleByName.getSetting().forEach(it -> ChatUtil.message(it.getName() + "|" + it.getClass().getSimpleName()));
            } else {
                Setting settingByName = QMXDRE.INSTANCE.module.getSettingByName(moduleByName, args[1]);
                if (settingByName == null) {
                    ChatUtil.message(args[1] + " Not Found");
                    return true;
                }

                if (args.length == 2) {
                    if (settingByName instanceof EnableSetting) {
                        ChatUtil.message(settingByName.getName() + ":" + ((EnableSetting) settingByName).getEnable());
                    }
                } else {
                    if (settingByName instanceof EnableSetting) {
                        ((EnableSetting) settingByName).setEnable(Boolean.parseBoolean(args[2]));
                        ChatUtil.message(settingByName.getName() + ":" + ((EnableSetting) settingByName).getEnable());
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String[] usage() {
        return new String[]{
                "<Module>",
                "<Module> <Setting>",
                "<Module> <Setting> <value>"};
    }
}
