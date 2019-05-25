package system;

import system.issue.Issue;
import system.users.User;

import java.util.ArrayList;
import java.util.List;

public class IssueSystem {

    private static class IssueSystemSingleton {
        private static IssueSystem INSTANCE = new IssueSystem();
    }

    List<User> userList;
    List<Issue> issueList;

    private IssueSystem() {
        this.issueList = new ArrayList<Issue>();
        this.userList = new ArrayList<User>();
    }

    public static IssueSystem getInstance() {
        return IssueSystemSingleton.INSTANCE;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }
}
