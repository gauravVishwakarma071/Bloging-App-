package com.spring_boot.blog_app.comments;

import com.spring_boot.blog_app.articles.ArticleEntity;
import com.spring_boot.blog_app.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import java.util.Date;

@Entity(name="comments")
@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Nullable
    private String title;

    @NonNull
    private String body;

    @CreatedDate
    private Date CreatedAt;

    @ManyToOne
    @JoinColumn(name="autorId", nullable = false)
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name="articleId", nullable = false)
    private ArticleEntity article;

}
