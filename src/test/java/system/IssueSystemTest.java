package system;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import system.observers.ObserverMethod;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.User;
import system.users.behave.imp.DefaultUserBehavior;
import system.users.behave.imp.IssueCommentReader;
import system.users.exceptions.WrongRoleExceptions;

public class IssueSystemTest {

    private User admin;
    private User mod;
    private User user;
    private User guest;

    @Before
    public void prepareUser() {
        admin = new User("Rafał", "Siergiej", RoleType.ADMIN, new DefaultUserBehavior()) {
            @Override
            public void notify(ObserverMethod method) {
                System.out.println("Admin");
            }
        };
        mod = new SimplyUser("Darek", "Maczek", RoleType.MOD, new IssueCommentReader());
        user = new SimplyUser("Jarek", "Zawadzki", RoleType.USER, new DefaultUserBehavior());
        guest = new SimplyUser("Adam", "Zawadzki", RoleType.GUEST, new DefaultUserBehavior());
    }

    @Test
    public void issueSystemSingletonTest() {
        IssueSystem instanceOne = IssueSystem.getInstance();
        IssueSystem instanceTwo = IssueSystem.getInstance();
        Assertions.assertThat(instanceOne.equals(instanceTwo)).isTrue();
    }

    @Test
    public void roleTest() {
        RoleType admin = RoleType.ADMIN;
        Assertions.assertThat(admin.getRoleName()).isEqualTo("ADMIN");
    }

    @Test
    public void createUserByAdminTest() {
        IssueSystem instance = IssueSystem.getInstance();
        boolean isNewUserCreated = instance.createNewUser(admin, guest);
        Assertions.assertThat(isNewUserCreated).isTrue();
    }

    @Test
    public void createUserByModTest() {
        IssueSystem instance = IssueSystem.getInstance();
        boolean isNewUserCreated = instance.createNewUser(mod, guest);
        Assertions.assertThat(isNewUserCreated).isTrue();
    }

    @Test(expected = WrongRoleExceptions.class)
    public void createUserByUserTest() {
        IssueSystem instance = IssueSystem.getInstance();
        boolean isNewUserCreated = instance.createNewUser(user, guest);
        Assertions.assertThat(isNewUserCreated).isTrue();
    }

    @Test(expected = WrongRoleExceptions.class)
    public void createUserByGuestTest() {
        IssueSystem instance = IssueSystem.getInstance();
        boolean isNewUserCreated = instance.createNewUser(guest, guest);
        Assertions.assertThat(isNewUserCreated).isTrue();
    }
}
