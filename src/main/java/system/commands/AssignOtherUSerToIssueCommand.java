package system.commands;

import system.IssueSystem;
import system.commands.interfaces.Command;
import system.issue.Issue;
import system.users.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AssignOtherUSerToIssueCommand implements Command {

    private Scanner scanner = new Scanner(System.in);

    private static class AssignOtherUSerToIssueCommandSingleton {
        private static AssignOtherUSerToIssueCommand INSTANCE = new AssignOtherUSerToIssueCommand();
    }

    private AssignOtherUSerToIssueCommand() {
    }

    public static AssignOtherUSerToIssueCommand getInstance() {
        return AssignOtherUSerToIssueCommand.AssignOtherUSerToIssueCommandSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("----------ASSIGN USER-----------");
        System.out.println("Choose user to assign:");
        List<User> userList = IssueSystem.getInstance().getUserList();
        Map<String, User> chooseUserMap = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(i + ": " + userList.get(i).toString());
            chooseUserMap.put(String.valueOf(i), userList.get(i));
        }
        String userId = scanner.nextLine();

        System.out.println("Provide issue id:");
        List<Issue> issueList = IssueSystem.getInstance().getIssueList();
        Map<String, Issue> chooseIssueMap = new HashMap<>();
        for (int i = 0; i < issueList.size(); i++) {
            System.out.println(i + ": " + issueList.get(i).toString());
            chooseIssueMap.put(String.valueOf(i), issueList.get(i));
        }
        String issueId = scanner.nextLine();

        User user = chooseUserMap.get(userId);
        Issue issue = chooseIssueMap.get(issueId);

        issue.assignToSubject(user);
        System.out.println("User added to subscribe list");
        System.out.println("--------------------------------");
    }
}
