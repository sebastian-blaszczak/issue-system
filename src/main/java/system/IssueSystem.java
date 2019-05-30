package system;

import system.issue.Issue;
import system.users.RoleType;
import system.users.User;
import system.users.exceptions.WrongRoleExceptions;

import java.util.ArrayList;
import java.util.List;

public class IssueSystem {

    private static class IssueSystemSingleton {
        private static IssueSystem INSTANCE = new IssueSystem();
    }

    List<User> userList;
    List<Issue> issueList;

    private IssueSystem() {
        this.issueList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    public static IssueSystem getInstance() {
        return IssueSystemSingleton.INSTANCE;
    }

    /**
     * Method that create issues by user and issue builder
     *
     * @param user    - user that create issue
     * @param builder - building object
     * @return success of operation
     */
    public boolean createIssue(User user, Issue.IssueBuilder builder) {
        boolean isCreated = false;
        builder.creator(user);
        if (user.getRole().getPermission() <= RoleType.USER.getPermission()) {
            Issue issue = builder.build();
            issue.assignToSubject(user);
            isCreated = this.issueList.add(issue);
        } else {
            throw new WrongRoleExceptions("Only Mod and higher privilege can create new Issue");
        }
        return isCreated;
    }

    public boolean createNewUser(User addedUser, User userToAdd) {
        boolean isUserAdded = false;
        if (addedUser.getRole().getPermission() <= RoleType.MOD.getPermission()) {
            isUserAdded = this.userList.add(userToAdd);
        } else {
            throw new WrongRoleExceptions("Only Moderator and higher privilege can create new User");
        }
        return isUserAdded;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }
}
