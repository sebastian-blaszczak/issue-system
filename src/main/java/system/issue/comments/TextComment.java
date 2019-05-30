package system.issue.comments;

import system.users.User;


public class TextComment extends Comment<String, String> {

    public TextComment(User creator, String commentContent) {
        super(creator, commentContent);
    }

    @Override
    public String getCommentContent() {
        return this.commentContent;
    }


}
