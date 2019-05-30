package system.issue.comments;

import system.users.User;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class FileComment extends Comment<File, String> {
    Logger logger = Logger.getLogger("LOG");

    public FileComment(User creator, File commentContent) {
        super(creator, commentContent);
    }

    @Override
    public String getCommentContent() {
        return null;
    }
}
