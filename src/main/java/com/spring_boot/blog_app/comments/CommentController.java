package com.spring_boot.blog_app.comments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles/{article-slug}/comment")
public class CommentController {

    @GetMapping
    String getComment(){
        return "Comments";
    }
}
