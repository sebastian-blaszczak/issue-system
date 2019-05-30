package system.commands;

import system.IssueSystem;
import system.MainClass;
import system.commands.interfaces.Command;
import system.issue.Issue;
import system.issue.comments.TextComment;

import javax.xml.stream.events.Comment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddStringCommentCommand implements Command {

    Scanner scanner = new Scanner(System.in);

    private static class AddStringCommentCommandSingleton {
        private static final AddStringCommentCommand INSTANCE = new AddStringCommentCommand();
    }

    private AddStringCommentCommand() {
    }

    public static AddStringCommentCommand getInstance() {
        return AddStringCommentCommand.AddStringCommentCommandSingleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("----------ADD COMMENT-----------");
        System.out.println("Choose issue id:");
        List<Issue> issueList = IssueSystem.getInstance().getIssueList();
        Map<String, Issue> chooseIssueMap = new HashMap<>();
        for (int i = 0; i < issueList.size(); i++) {
            System.out.println(i + ": " + issueList.get(i).toString());
            chooseIssueMap.put(String.valueOf(i), issueList.get(i));
        }
        String numberOfIssue = scanner.nextLine();
        System.out.println("Provide comment content:");
        String comment = scanner.nextLine();
        Issue issue = chooseIssueMap.get(numberOfIssue);
        issue.addComment(new TextComment(MainClass.loggedInUser, comment));
        System.out.println("Comment added");
        System.out.println("--------------------------------");
    }
}
