package system;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import system.users.RoleType;

public class IssueSystemTest {

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
}
