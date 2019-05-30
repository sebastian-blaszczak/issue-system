package system.commands;

import system.IssueSystem;
import system.MainClass;
import system.commands.interfaces.Command;
import system.issue.Issue;
import system.issue.IssuePriority;
import system.issue.IssueType;
import system.users.RoleType;
import system.users.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CreateNewIssue implements Command {

    Scanner scanner = new Scanner(System.in);

    private static class CreateNewIssueSingleton {
        private static CreateNewIssue INSTANCE = new CreateNewIssue();
    }

    private CreateNewIssue() {
    }

    public static CreateNewIssue getInstance() {
        return CreateNewIssue.CreateNewIssueSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("----------CREATE ISSUE----------");
        System.out.println("Provide issue title:");
        String title = scanner.nextLine();
        System.out.println("Provide type:");
        System.out.println("CRITICAL, WORK, ANALYSIS, ERROR");
        String issueTypeName = scanner.nextLine();
        IssueType issueType;
        try {
            issueType = IssueType.valueOf(issueTypeName);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            System.out.println("Type dose not exist");
            issueType = IssueType.WORK;
        }
        System.out.println("Provide priority:");
        System.out.println("LOW, MED, HIGH, ASAP");
        String issuePriorityName = scanner.nextLine();
        IssuePriority issuePriority;
        try {
            issuePriority = IssuePriority.valueOf(issuePriorityName);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            System.out.println("Priority dose not exist");
            issuePriority = IssuePriority.LOW;
        }
        System.out.println("Provide description:");
        String description = scanner.nextLine();
        System.out.println("Choose user to assign:");
        List<User> userList = IssueSystem.getInstance().getUserList();
        Map<String, User> chooseUserMap = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(i + ": " + userList.get(i).toString());
            chooseUserMap.put(String.valueOf(i), userList.get(i));
        }
        String number = scanner.nextLine();

        Issue.IssueBuilder issueBuilder = new Issue.IssueBuilder()
                .title(title)
                .type(issueType)
                .priority(issuePriority)
                .description(description)
                .assignUser(chooseUserMap.get(number));

        System.out.println("Issue added");
        IssueSystem.getInstance().createIssue(MainClass.loggedInUser, issueBuilder);
        ShowIssueCommand.getInstance().execute();
    }

}
