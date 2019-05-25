package system.issue;

public enum IssueType {
    CRITICAL("CRITICAL"),
    WORK("WORK"),
    ANALISIS("ANALYSIS"),
    ERROR("ERROR");

    private String typeName;

    IssueType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
