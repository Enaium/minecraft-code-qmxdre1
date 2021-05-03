package cn.enaium.learn.qmxdre.command.commands;

import cn.enaium.learn.qmxdre.QMXDRE;
import cn.enaium.learn.qmxdre.command.ICommand;
import cn.enaium.learn.qmxdre.module.Module;
import cn.enaium.learn.qmxdre.util.ChatUtil;

/**
 * @author Enaium
 */
public class EnableCommand implements ICommand {
    @Override
    public boolean run(String[] args) {
        if (args.length == 1) {
            Module moduleByName = QMXDRE.INSTANCE.module.getModuleByName(args[0]);
            if (moduleByName != null) {
                moduleByName.enable();
                ChatUtil.message("Module " + args[0] + (moduleByName.getEnable() ? " Enable" : " Disable"));
            } else {
                ChatUtil.message("Module " + args[0] + " Not Found");
            }
            return true;
        }
        return false;
    }

    @Override
    public String[] usage() {
        return new String[]{"<Module>"};
    }
}
