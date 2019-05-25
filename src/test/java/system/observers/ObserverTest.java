package system.observers;

import org.junit.Before;
import org.junit.Test;
import system.issue.Issue;
import system.issue.IssuePriority;
import system.issue.IssueType;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.behave.imp.DefaultUserBehavior;
import system.users.behave.imp.IssueCommentReader;

public class ObserverTest {

    private SimplyUser s1;
    private SimplyUser s2;
    private SimplyUser s3;

    private Issue issueOne;
    private Issue issueTwo;
    private Issue issueThree;

    @Before
    public void prepareUser() {
        s1 = new SimplyUser("Rafał", "Siergiej", RoleType.USER, new DefaultUserBehavior());
        s2 = new SimplyUser("Darek", "Maczek", RoleType.USER, new IssueCommentReader());
        s3 = new SimplyUser("Jarek", "Zawadzki", RoleType.USER, new DefaultUserBehavior());
    }

    @Before
    public void prepareIssues() {
        issueOne = Issue.builder()
                .assignUser(s1)
                .creator(s2)
                .description("First issue description")
                .priority(IssuePriority.HIGH)
                .title("Very important")
                .type(IssueType.ERROR)
                .build();

        issueTwo = Issue.builder()
                .assignUser(s3)
                .creator(s2)
                .description("Second issue description")
                .priority(IssuePriority.LOW)
                .title("Not very important")
                .type(IssueType.WORK)
                .build();

        issueThree = Issue.builder()
                .assignUser(s2)
                .creator(s1)
                .description("Third issue description")
                .priority(IssuePriority.MED)
                .title("Third issue title")
                .type(IssueType.ANALISIS)
                .build();
    }

    @Test
    public void checkObserver() {

        issueOne.assignToSubject(s1);
        issueOne.assignToSubject(s2);

        issueTwo.assignToSubject(s3);

        issueThree.assignToSubject(s2);
        issueThree.assignToSubject(s3);

        issueThree.changeDescription("Changed description of issueThree");
        issueOne.notifyObservers();
        issueTwo.notifyObservers();

        System.out.println();

        issueThree.setAssignUser(s3);
    }
}
