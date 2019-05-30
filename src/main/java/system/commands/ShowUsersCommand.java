package system.commands;

import system.IssueSystem;
import system.commands.interfaces.Command;

import java.util.Arrays;

public class ShowUsersCommand implements Command {

    private static class ShowUsersCommandSingleton {
        private static ShowUsersCommand INSTANCE = new ShowUsersCommand();
    }

    private ShowUsersCommand() {
    }

    public static ShowUsersCommand getInstance() {
        return ShowUsersCommand.ShowUsersCommandSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("-----------USER LIST------------");
        IssueSystem.getInstance().getUserList()
                .forEach(System.out::println);
        System.out.println("--------------------------------");
    }
}
