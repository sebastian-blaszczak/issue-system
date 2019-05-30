package system.commands;

import system.IssueSystem;
import system.commands.interfaces.Command;
import system.issue.Issue;

import java.util.Scanner;

public class AddIssueCommand implements Command {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {

        System.out.println();

        IssueSystem.getInstance().getIssueList().add(Issue.builder()
                .creator()
                .assignUser()
                .description()
                .priority()
                .title()
                .type()
                .build());
    }
}
