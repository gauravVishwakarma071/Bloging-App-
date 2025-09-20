package com.spring_boot.blog_app.articles;

import com.spring_boot.blog_app.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<ArticleEntity,Long> {
}
