package cn.enaium.learn.qmxdre.command.commands;

import cn.enaium.learn.qmxdre.command.ICommand;
import cn.enaium.learn.qmxdre.util.ChatUtil;

/**
 * @author Enaium
 */
public class HelpCommand implements ICommand {
    @Override
    public boolean run(String[] args) {
        ChatUtil.message("HeEeEeEeLP");
        return true;
    }

    @Override
    public String[] usage() {
        return new String[]{"help"};
    }
}
