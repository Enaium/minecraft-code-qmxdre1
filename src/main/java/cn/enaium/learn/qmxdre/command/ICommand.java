package cn.enaium.learn.qmxdre.command;

/**
 * @author Enaium
 */
public interface ICommand {
    boolean run(String[] args);
    String[] usage();
}
