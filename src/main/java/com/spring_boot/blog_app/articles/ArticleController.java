package com.spring_boot.blog_app.articles;

import com.spring_boot.blog_app.users.UserEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping("")
    String getArticle(){
        return "get all articles";
    }

    @GetMapping("/{id}")
    String getArticlesById(@PathVariable("id") String id){
        return "get articles by id " + id;
    }

    @PostMapping("")
    String createArticles(@AuthenticationPrincipal UserEntity user){
        return "created article called by" + user.getUsername();
    }

}
