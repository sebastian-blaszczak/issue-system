package system.users.behave.imp;

import system.issue.Issue;
import system.users.interfaces.UserBehavior;

public class IssueCommentReader implements UserBehavior<Issue> {

    public void doSomething(Issue issue) {
        System.out.println("IssueCommentReader");
    }
}
