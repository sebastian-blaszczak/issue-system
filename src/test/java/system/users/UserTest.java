package system.users;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import system.issue.Issue;
import system.users.behave.imp.DefaultUserBehavior;
import system.users.behave.imp.IssueCommentReader;
import system.users.exceptions.WrongRoleExceptions;

public class UserTest {

    @Test(expected = WrongRoleExceptions.class)
    public void createSimplyUserWithAdminRole() {
        SimplyUser simplyUser = new SimplyUser("Janek", "Kowalski", RoleType.ADMIN, new DefaultUserBehavior());

        Assertions.assertThat(simplyUser).isNull();
    }

    @Test
    public void createSimplyUserWithUserRole() {
        SimplyUser simplyUser = new SimplyUser("Janek", "Kowalski", RoleType.USER, new IssueCommentReader());
        Issue issue = Issue.builder()
                .assignUser(simplyUser)
                .creator(simplyUser)
                .build();
        simplyUser.behave(issue);
        simplyUser.setBehavior(new DefaultUserBehavior());
        simplyUser.behave(issue);
        Assertions.assertThat(simplyUser).isNotNull();
    }

    @Test
    public void testId() {
        SimplyUser firstUser = new SimplyUser("Janek", "Kowalski", RoleType.USER, new IssueCommentReader());
        Assertions.assertThat(firstUser.getId()).isEqualTo(firstUser.idGenerator.get());
        SimplyUser secondUser = new SimplyUser("Marek", "Kowalski", RoleType.USER, new IssueCommentReader());
        Assertions.assertThat(secondUser.getId()).isEqualTo(secondUser.idGenerator.get());
    }
}
