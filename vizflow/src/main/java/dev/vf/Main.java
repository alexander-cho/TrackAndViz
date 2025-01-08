package dev.vf;

import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
//import repositories.DBCommentRepository;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        // Team uses an app to manage tasks.
        // Feature: users to leave comments for the tasks, comment is stored somewhere when published,
        // email is sent to specific address configured in the app
        // service that implements the "publish comment" use case -> CommentService
        // implements the storing comment responsibility -> CommentRepository
        // sending email -> CommentNotificationProxy
//        System.out.println("Welcome to the app");
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
//        Comment comment = new Comment();
//        comment.setAuthor("Alex");
//        comment.setText("This is the first message");
//
//        CommentService commentService = context.getBean(CommentService.class);
//        commentService.PublishComment(comment);
        var commentService = context.getBean(CommentService.class);
        var userService = context.getBean(UserService.class);
        Comment comment = new Comment();
        comment.setText("Test comment");
        comment.setAuthor("Alex");

        commentService.publishComment(comment);

        userService.userGetsComment(comment);
    }
}
