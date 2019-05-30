package system.commands;

import system.commands.interfaces.Command;

public class SystemExitCommand implements Command {

    private static class SystemExitCommandSingleton {
        private static SystemExitCommand INSTANCE = new SystemExitCommand();
    }

    private SystemExitCommand() {
    }

    public static SystemExitCommand getInstance() {
        return SystemExitCommand.SystemExitCommandSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
