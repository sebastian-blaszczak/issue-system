package system.exporters;

import system.issue.Issue;

import java.io.File;
import java.util.List;

public class DefaultIssueFileExporter extends IssueExporter<File>{

    @Override
    public List<Issue> export(File obj) {
        return super.export(obj);
    }
}
