package system.issue.wrapper;

import system.issue.Issue;
import system.issue.exceptions.MethodNotAllowedException;

public class IssueWrapper extends Issue {

    private Issue issue;

    public IssueWrapper(IssueBuilder builder) {
        super(builder);
    }

    @Override
    public void notifyObservers() {
        throw new MethodNotAllowedException("MethodNotAllowedException");
    }

    @Override
    public void publish() {
        throw new MethodNotAllowedException("MethodNotAllowedException");
    }
}
