package services;

import models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.CommentRepository;

import java.util.logging.Logger;

@Component
public class UserService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String userGetsComment(Comment comment) {
        logger.info("Test USER " + comment.getText());
        return "SUCCESS";
    }
}
