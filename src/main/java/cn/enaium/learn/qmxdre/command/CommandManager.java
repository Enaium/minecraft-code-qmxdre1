package cn.enaium.learn.qmxdre.command;

import cn.enaium.learn.qmxdre.command.commands.EnableCommand;
import cn.enaium.learn.qmxdre.command.commands.HelpCommand;
import cn.enaium.learn.qmxdre.util.ChatUtil;

import java.util.*;

/**
 * @author Enaium
 */
public class CommandManager {
    public final HashMap<String[], ICommand> commands = new HashMap<>();

    private final String prefix = "`";

    public void load() {
        commands.put(new String[]{"h", "help"}, new HelpCommand());
        commands.put(new String[]{"e", "enable"}, new EnableCommand());
    }

    public boolean execCommand(String message) {
        if (!message.startsWith(prefix)) {
            return false;
        }

        boolean run = message.split("`").length > 1;

        if (run) {
            String[] sss = message.split("`")[1].split(" ");
            List<String> args = new ArrayList<>();
            Collections.addAll(args, sss);

            String key = args.get(0);

            ICommand command = getCommand(key);

            if (command != null) {
                args.remove(key);
                if (!command.run(args.toArray(new String[0]))) {
                    for (String s : command.usage()) {
                        ChatUtil.message(key + s);
                    }
                }
            } else {
                ChatUtil.message("Command " + key + " Not Found");
            }
        }
        return true;
    }


    public ICommand getCommand(String key) {
        for (Map.Entry<String[], ICommand> entry : commands.entrySet()) {
            for (String s : entry.getKey()) {
                if (s.equalsIgnoreCase(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }


}
