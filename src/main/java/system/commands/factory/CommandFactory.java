package system.commands.factory;

import system.commands.*;
import system.commands.exceptions.CommandNotFound;
import system.commands.interfaces.Command;

public class CommandFactory {

    public static Command getFactory(int number) {
        switch (number) {
            case -1:
                return SystemExitCommand.getInstance();
            case 0:
                return ShowHelpCommand.getInstance();
            case 1:
                return ShowIssueCommand.getInstance();
            case 2:
                return ShowUsersCommand.getInstance();
            case 3:
                return CreateNewIssue.getInstance();
            case 4:
                return CreateNewUser.getInstance();
            case 5:
                return ModifyIssueDescriptionCommand.getInstance();
            case 6:
                return AssignOtherUSerToIssueCommand.getInstance();
            case 7:
                return AddStringCommentCommand.getInstance();
            default:
                throw new CommandNotFound("Command not found");
        }
    }
}

