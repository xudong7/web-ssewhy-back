package com.dunjia.back.service;

import com.dunjia.back.mapper.ArticleMapper;
import com.dunjia.back.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    public List<Article> getArticleList() {
        return articleMapper.getArticleList();
    }

    public void addArticle(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.addArticle(article);
    }

    public void updateArticle(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.updateArticle(article);
    }

    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);
    }

    public void deleteAllArticle() {
        articleMapper.deleteAllArticle();
    }

    public boolean like(Integer articleId, Integer userId) {
        Article article = articleMapper.getArticleById(articleId);
        String likesCart = article.getLikesCart();
        // 判断是否为空
        if (likesCart == null) {
            likesCart = "";
        }
        // 点赞
        if (!likesCart.contains("," + userId + ",")) {
            likesCart += "," + userId + ",";
            article.setLikesCart(likesCart);
            article.setLikes(article.getLikes() + 1);
            articleMapper.updateArticle(article);
            return true;
        }
        // 取消点赞
        else {
            likesCart = likesCart.replace("," + userId + ",", "");
            article.setLikesCart(likesCart);
            article.setLikes(article.getLikes() - 1);
            articleMapper.updateArticle(article);
            return false;
        }
    }

    public List<Article> searchArticle(String keyword) {
        List<Article> articles = articleMapper.getArticleList();
        articles.removeIf(article -> !article.getTitle().contains(keyword));
        // content模糊搜索 同时content里的img的路径不能被搜索到
        articles.removeIf(article -> !article.getContent().contains(keyword)
                || article.getContent().contains("src=\"" + keyword));
        return articles;
    }
}
