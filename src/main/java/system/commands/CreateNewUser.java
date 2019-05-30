package system.commands;

import system.IssueSystem;
import system.MainClass;
import system.commands.interfaces.Command;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.User;
import system.users.behave.imp.DefaultUserBehavior;
import system.users.behave.imp.IssueCommentReader;
import system.users.interfaces.UserBehavior;

import java.util.Scanner;

public class CreateNewUser implements Command {
    Scanner scanner = new Scanner(System.in);

    private static class CreateNewIssueSingleton {
        private static CreateNewUser INSTANCE = new CreateNewUser();
    }

    private CreateNewUser() {
    }

    public static CreateNewUser getInstance() {
        return CreateNewUser.CreateNewIssueSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("----------CREATE USER-----------");
        System.out.println("Provide user name:");
        String name = scanner.nextLine();
        System.out.println("Provide surname");
        String surname = scanner.nextLine();
        System.out.println("Provide role:");
        System.out.println("ADMIN, MOD, USER, GUEST");
        String roleName = scanner.nextLine();
        RoleType roleType;
        try {
            roleType = RoleType.valueOf(roleName);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            System.out.println("Role dose not exist");
            roleType = RoleType.GUEST;
        }
        System.out.println("Provide behavior:");
        System.out.println("0: DefaultUserBehavior");
        System.out.println("1: IssueCommentReader");
        int chooserBehavior = scanner.nextInt();

        User user = new SimplyUser(name, surname, roleType, behaviorChooser(chooserBehavior));
        System.out.println("User added");
        IssueSystem.getInstance().createNewUser(MainClass.loggedInUser, user);
        ShowUsersCommand.getInstance().execute();
    }

    UserBehavior behaviorChooser(int number) {
        switch (number) {
            case 0:
                return new DefaultUserBehavior();
            case 1:
                return new IssueCommentReader();
        }
        return new DefaultUserBehavior();
    }
}

