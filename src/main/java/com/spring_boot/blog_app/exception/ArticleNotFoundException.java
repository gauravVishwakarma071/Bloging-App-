package com.spring_boot.blog_app.exception;

public class ArticleNotFoundException extends IllegalArgumentException {
    public ArticleNotFoundException(String slug) {
        super("Article with slug '" + slug + "' not found");
    }

    public ArticleNotFoundException(Long id) {
        super("Article with ID " + id + " not found");
    }
}
