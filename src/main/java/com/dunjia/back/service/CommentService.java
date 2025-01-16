package com.dunjia.back.service;

import com.dunjia.back.mapper.ArticleMapper;
import com.dunjia.back.mapper.CommentMapper;
import com.dunjia.back.pojo.Article;
import com.dunjia.back.pojo.Comment;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Resource
    private ArticleMapper articleMapper;

    public List<Comment> getAllComments() {
        return commentMapper.getAllComments();
    }

    public List<Comment> getCommentsByArticleId(Integer articleId) {
        List<Comment> comments = commentMapper.getAllComments();
        comments.removeIf(comment -> !comment.getArticleId().equals(articleId));
        return comments;
    }

    public void addComment(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        comment.setUpdateTime(LocalDateTime.now());
        Article article = articleMapper.getArticleById(comment.getArticleId());
        article.setComments(article.getComments() + 1);
        articleMapper.updateArticle(article);
        commentMapper.addComment(comment);
    }
}
