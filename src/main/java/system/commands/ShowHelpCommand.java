package system.commands;

import system.commands.interfaces.Command;

public class ShowHelpCommand implements Command {

    private static class ShowHelpCommandSingleton {
        private static ShowHelpCommand INSTANCE = new ShowHelpCommand();
    }

    private ShowHelpCommand() {
    }

    public static ShowHelpCommand getInstance() {
        return ShowHelpCommand.ShowHelpCommandSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("--------------MENU--------------");
        System.out.println("1: Show All Issue");
        System.out.println("2: Show All Users");
        System.out.println("3: Add new Issue");
        System.out.println("4: Add new User");
        System.out.println("5: Modify description for issue");
        System.out.println("6: Assign other user to issue");
        System.out.println("7: Add comment to issue");
        System.out.println("0: help");
        System.out.println("-1: Exit program");
        System.out.println("--------------------------------");
    }
}
