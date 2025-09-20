package com.spring_boot.blog_app.comments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;
}
