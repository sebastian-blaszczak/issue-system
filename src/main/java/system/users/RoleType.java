package system.users;

public enum RoleType {
    ADMIN("ADMIN", 0),
    MOD("MODERATOR", 100),
    USER("USER", 1000),
    GUEST("GUEST", 10000);

    private String roleName;
    private int permission;

    RoleType(String roleName, int permission) {
        this.roleName = roleName;
        this.permission = permission;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getPermission() {
        return permission;
    }
}
