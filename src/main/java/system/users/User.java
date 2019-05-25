package system.users;

import system.issue.Issue;
import system.observers.Observer;
import system.users.interfaces.UserBehavior;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class User implements Observer {

    //private static Integer idGenerator = 0;
    static AtomicInteger idGenerator = new AtomicInteger(-1);

    private final int id;
    private final String name;
    private final String surname;
    private RoleType role;
    private UserBehavior<Issue> behavior;

    public User(String name, String surname, RoleType role, UserBehavior behavior) {
        User.idGenerator.getAndIncrement();
        this.id = User.idGenerator.get();
        //id = User.idGenerator + 1;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.behavior = behavior;
    }

    public void behave(Issue issue) {
        behavior.doSomething(issue);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public RoleType getRole() {
        return role;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
}
