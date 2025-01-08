package services;

import models.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    private Comment comment;

    public CommentProcessor() {
        System.out.println("This is a newly created instance of the comment processor!");
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void processComment() {
//        changing the comment attribute
    }

    public void validateComment() {
//        validating
    }
}
