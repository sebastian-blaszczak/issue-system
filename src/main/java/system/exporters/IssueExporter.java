package system.exporters;

import system.exporters.interfaces.Exporter;
import system.issue.Issue;

import java.util.List;

public abstract class IssueExporter<T> implements Exporter<T, List<Issue>> {
}
