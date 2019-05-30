package system.exporters;

import system.issue.Issue;

import java.util.List;

public abstract class AbstractExporter<T> implements Exporter<T, List<Issue>> {
    @Override
    public List<Issue> export(T obj) {
        return null;
    }
}
