package system.issue;

public enum IssueType {
    CRITICAL("CRITICAL"),
    WORK("WORK"),
    ANALYSIS("ANALYSIS"),
    ERROR("ERROR");

    private String typeName;

    IssueType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return "IssueType{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
