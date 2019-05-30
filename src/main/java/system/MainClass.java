package system;

import system.commands.CreateNewIssue;
import system.commands.ShowHelpCommand;
import system.commands.factory.CommandFactory;
import system.commands.interfaces.Command;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.behave.imp.DefaultUserBehavior;

import java.util.Scanner;

public class MainClass {
    static Scanner scanner = new Scanner(System.in);
    static public SimplyUser loggedInUser;

    public static void main(String[] args) {
        System.out.println("----------ISSUE SYSTEM----------");
        System.out.println("Provide name:");
        String name = scanner.nextLine();
        System.out.println("Provide surname:");
        String surname = scanner.nextLine();
        loggedInUser = new SimplyUser(name, surname, RoleType.MOD, new DefaultUserBehavior());
        IssueSystem.getInstance().getUserList().add(loggedInUser);

        ShowHelpCommand.getInstance().execute();

        while (true) {
            int i = scanner.nextInt();
            Command command = CommandFactory.getFactory(i);
            command.execute();
            ShowHelpCommand.getInstance().execute();
            System.out.println();
        }
    }
}
