package system.users.behave.imp;

import system.issue.Issue;
import system.users.interfaces.UserBehavior;

public class DefaultUserBehavior implements UserBehavior<Issue> {

    public void doSomething(Issue obj) {
        System.out.println("DefaultUserBehavior");
    }
}
