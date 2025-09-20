package com.spring_boot.blog_app.articles;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArticlesService {

    @Autowired
    private final ArticlesRepository articlesRepository;
}
