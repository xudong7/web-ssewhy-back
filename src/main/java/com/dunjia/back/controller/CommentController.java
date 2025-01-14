package com.dunjia.back.controller;

import com.dunjia.back.pojo.Comment;
import com.dunjia.back.pojo.Result;
import com.dunjia.back.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 查询全部评论
     * @return
     */
    @GetMapping("/comment")
    public Result getAllComments() {
        log.info("查询全部评论");
        List<Comment> comments = commentService.getAllComments();
        return Result.success(comments);
    }

    /**
     * 根据articleId查询评论
     * @param articleId
     * @return
     */
    @GetMapping("/comment/{articleId}")
    public Result getCommentsByArticleId(@PathVariable Integer articleId) {
        log.info("查询文章id: {} 的评论", articleId);
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        return Result.success(comments);
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/comment")
    public Result addComment(@RequestBody Comment comment) {
        log.info("添加评论: {}", comment);
        commentService.addComment(comment);
        return Result.success("添加成功");
    }
}
