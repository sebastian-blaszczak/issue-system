package system.issue.comments;

import system.users.User;

import java.time.LocalDateTime;

public abstract class Comment<T,R> {

    private User creator;
    private User modifyBy;
    private LocalDateTime createAt;
    private LocalDateTime modifyAt;
    protected T commentContent;

    public Comment(User creator, T commentContent) {
        this.creator = creator;
        this.modifyBy = creator;
        this.createAt = LocalDateTime.now();
        this.modifyAt = LocalDateTime.now();
        this.commentContent = commentContent;
    }

    public void changeContent(User modifyBy, T newCommentContent) {
        this.commentContent = newCommentContent;
        this.modifyBy = modifyBy;
        this.modifyAt = LocalDateTime.now();
    }

    public void setModifyBy(User modifyBy) {
        this.modifyBy = modifyBy;
    }


    public void setModifyAt(LocalDateTime modifyAt) {
        this.modifyAt = modifyAt;
    }

    public User getCreator() {
        return creator;
    }

    public User getModifyBy() {
        return modifyBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getModifyAt() {
        return modifyAt;
    }

    abstract public R getCommentContent();

    @Override
    public String toString() {
        return "Comment{" +
                "creator=" + creator +
                ", modifyBy=" + modifyBy +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                ", commentContent=" + getCommentContent() +
                '}';
    }
}
