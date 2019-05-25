package system.issue;

public enum IssuePriority {
    LOW(1, "LOWEST"),
    MED(2, "MEDIUM"),
    HIGH(3, "HIGH"),
    ASAP(1000, "ASAP");

    private final int priority;
    private final String priorityName;

    IssuePriority(int priority, String priorityName) {
        this.priority = priority;
        this.priorityName = priorityName;
    }

    public int getPriority() {
        return priority;
    }

    public String getPriorityName() {
        return priorityName;
    }
}
