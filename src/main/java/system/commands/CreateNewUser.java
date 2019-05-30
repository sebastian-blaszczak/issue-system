package system.commands;

import system.IssueSystem;
import system.commands.interfaces.Command;

import java.util.Arrays;

public class AddUsersCommand implements Command {
    @Override
    public void execute() {
        Arrays.asList(IssueSystem.getInstance().getUserList())
                .forEach(System.out::println);
    }
}
