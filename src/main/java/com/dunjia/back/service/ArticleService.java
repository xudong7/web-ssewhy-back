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
}
