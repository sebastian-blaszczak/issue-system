package system.commands;

import system.IssueSystem;
import system.commands.interfaces.Command;
import system.issue.Issue;
import system.users.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ModifyIssueDescriptionCommand implements Command {
    Scanner scanner = new Scanner(System.in);

    private static class ModifyIssueDescriptionCommandSingleton {
        private static ModifyIssueDescriptionCommand INSTANCE = new ModifyIssueDescriptionCommand();
    }

    private ModifyIssueDescriptionCommand() {
    }

    public static ModifyIssueDescriptionCommand getInstance() {
        return ModifyIssueDescriptionCommand.ModifyIssueDescriptionCommandSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("-----------MODIFY ISSUE DSR-----------");
        System.out.println("Provide issue id:");
        List<Issue> issueList = IssueSystem.getInstance().getIssueList();
        Map<String, Issue> chooseIssueMap = new HashMap<>();
        for (int i = 0; i < issueList.size(); i++) {
            System.out.println(i + ": " + issueList.get(i).toString());
            chooseIssueMap.put(String.valueOf(i), issueList.get(i));
        }
        String number = scanner.nextLine();
        Issue issue = chooseIssueMap.get(number);
        System.out.println("Provide new description:");
        String description = scanner.nextLine();
        issue.setDescription(description);
        issue.publish();
        System.out.println("--------------------------------");
    }
}
