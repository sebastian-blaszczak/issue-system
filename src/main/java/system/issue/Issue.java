package system.issue;

import system.commands.interfaces.Command;
import system.issue.comments.Comment;
import system.issue.wrapper.IssueWrapper;
import system.observers.Observer;
import system.observers.Publisher;
import system.observers.Subject;
import system.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Issue implements Publisher, Subject {

    private static Integer idGenerator = -1;
    private final int id;
    private final String tittle;
    private String description;
    private final User creator;
    private User assignUser;
    private IssueType type;
    private IssuePriority priority;
    private List<Comment> commentList;

    private List<Observer> observerList;

    protected Issue(IssueBuilder builder) {
        Issue.idGenerator += 1;
        this.id = idGenerator;
        this.tittle = builder.title;
        this.description = builder.description;
        this.creator = builder.creator;
        this.assignUser = builder.assignUser;
        this.type = builder.type;
        this.priority = builder.priority;
        this.observerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
        this.publish();
    }

    public void setAssignUser(User user) {
        this.assignUser = user;
        Optional<Observer> foundObserver = this.observerList.stream()
                .filter(observer -> observer.equals(user))
                .findAny();

        Observer observer = foundObserver.orElse(p -> {
            System.out.println("Observer not found");
        });
        observer.notify(() -> {
            System.out.println("User [" + user.getName() + "] is assigned to issue id [" + id + "]");

            return new IssueWrapper(new IssueBuilder()
                    .title(tittle)
                    .description(description)
                    .creator(creator)
                    .assignUser(assignUser)
                    .type(type)
                    .priority(priority));
        });
    }

    public static IssueBuilder builder() {
        return new IssueBuilder();
    }

    @Override
    public void publish() {
        System.out.println("Description was modified");
        notifyObservers();
    }

    @Override
    public void assignToSubject(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void unassignFromSubject(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.observerList.stream()
                .forEach(observer -> {
                    observer.notify(() -> {
                        System.out.println("Issue with title [" + tittle + "] has changed");

                        return new IssueWrapper(new IssueBuilder()
                                .title(tittle)
                                .description(description)
                                .creator(creator)
                                .assignUser(assignUser)
                                .type(type)
                                .priority(priority));
                    });
                });
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
        publish();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class IssueBuilder {
        private String title;
        private String description;
        private User creator;
        private User assignUser;
        private IssueType type;
        private IssuePriority priority;


        public IssueBuilder() {
        }

        public IssueBuilder title(String title) {
            this.title = title;
            return this;
        }

        public IssueBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IssueBuilder creator(User creator) {
            this.creator = creator;
            return this;
        }

        public IssueBuilder assignUser(User assignUser) {
            this.assignUser = assignUser;
            return this;
        }

        public IssueBuilder type(IssueType type) {
            this.type = type;
            return this;
        }

        public IssueBuilder priority(IssuePriority priority) {
            this.priority = priority;
            return this;
        }

        public Issue build() {
            return new Issue(this);
        }
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", creator=" + creator +
                ", assignUser=" + assignUser +
                ", type=" + type +
                ", priority=" + priority +
                ", commentList=" + commentList +
                '}';
    }
}
