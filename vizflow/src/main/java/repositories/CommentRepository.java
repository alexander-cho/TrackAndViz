package repositories;

import models.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//public interface CommentRepository {
//    void storeComment(Comment comment);
//}

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentRepository {

}
