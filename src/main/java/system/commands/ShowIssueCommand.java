package system.commands;

import system.IssueSystem;
import system.commands.interfaces.Command;

import java.util.Arrays;

public class ShowIssueCommand implements Command {

    private static class ShowIssueCommandSingleton {
        private static ShowIssueCommand INSTANCE = new ShowIssueCommand();
    }

    private ShowIssueCommand() {
    }

    public static ShowIssueCommand getInstance() {
        return ShowIssueCommand.ShowIssueCommandSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("-----------ISSUE LIST-----------");
        IssueSystem.getInstance().getIssueList()
                .forEach(System.out::println);
        System.out.println("--------------------------------");
    }
}
