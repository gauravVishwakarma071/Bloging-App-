package com.spring_boot.blog_app.articles;

import com.spring_boot.blog_app.articles.dtos.CreateArticleRequest;
import com.spring_boot.blog_app.articles.dtos.UpdateArticleRequest;
import com.spring_boot.blog_app.users.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring_boot.blog_app.exception.UserNotFoundException;

@Service
@AllArgsConstructor
public class ArticlesService {

    @Autowired
    private final ArticlesRepository articlesRepository;
    private final UsersRepository usersRepository;

    //Create an article
    public ArticleEntity createArticle(CreateArticleRequest a, Long authorId){
        var author = usersRepository.findById(authorId).orElseThrow(()-> new UserNotFoundException(authorId));

        return articlesRepository.save(ArticleEntity.builder()
                .title(a.getTitle())
                //TODO: create a proper slugificaion
                .slug(a.getTitle().toLowerCase().replaceAll("\\s+", "-"))
                .body(a.getBody())
                .subTitle(a.getSubTitle())
                .author(author)
                .build()
        );
    }

    //Get all Articles
    public Iterable<ArticleEntity> getAllUsers(){
        return articlesRepository.findAll();
    }

    //Get article by slug
    public ArticleEntity getArticleByslug(String slug){
        var article =  articlesRepository.findByslug(slug);
        if(article==null){
            throw new ArticleNotFoundException(slug);
        }
        return article;
    }

    //Update An Article
    public ArticleEntity updateArticle(Long articleId, UpdateArticleRequest a){
        var updatedArticle = articlesRepository.findById(articleId).orElseThrow(()-> new ArticleNotFoundException(articleId));

        if(a.getTitle()!=null){
            updatedArticle.setTitle(a.getTitle());
        }

        if(a.getBody()!=null){
            updatedArticle.setBody(a.getBody());
        }

        if(a.getSubTitle()!=null){
            updatedArticle.setSubTitle(a.getSubTitle());
        }

        return articlesRepository.save(updatedArticle);
    }


    //Exception class for article not found
    static class ArticleNotFoundException extends IllegalArgumentException{
        public ArticleNotFoundException(String slug){
            super("Article with slug" + slug + " not found");
        }
        public ArticleNotFoundException(Long id){
            super("Article with Id" + id + " not found");
        }
    }
}
