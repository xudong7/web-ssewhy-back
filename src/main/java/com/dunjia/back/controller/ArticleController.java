package com.dunjia.back.controller;

import com.dunjia.back.pojo.Article;
import com.dunjia.back.pojo.Result;
import com.dunjia.back.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 查询全部文章
     * @return
     */
    @GetMapping("/article")
    public Result getArticleList() {
        log.info("查询全部文章");
        List<Article> articles = articleService.getArticleList();
        return Result.success(articles);
    }

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    @GetMapping("/article/{id}")
    public Result getArticleById(@PathVariable Integer id) {
        log.info("查询文章id: {}", id);
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return Result.success(article);
        }
        return Result.error("文章不存在");
    }

    /**
     * 新增文章
     * @param article
     * @return
     */
    @PostMapping("/article")
    public Result addArticle(@RequestBody Article article) {
        log.info("新增文章: {}", article);
        articleService.addArticle(article);
        return Result.success();
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @PutMapping("/article")
    public Result updateArticle(@RequestBody Article article) {
        log.info("更新文章: {}", article);
        articleService.updateArticle(article);
        return Result.success();
    }

    /**
     * 删除特定id的文章
     * @param id
     * @return
     */
    @DeleteMapping("/article/{id}")
    public Result deleteArticle(@PathVariable Integer id) {
        log.info("删除文章id: {}", id);
        articleService.deleteArticle(id);
        return Result.success();
    }

    /**
     * 删除全部文章
     * @return
     */
    @DeleteMapping("/article")
    public Result deleteAllArticle() {
        log.info("删除全部文章");
        articleService.deleteAllArticle();
        return Result.success();
    }

    /**
     * 处理喜欢
     * @param articleId userId
     * @return
     */
    @PostMapping("/article/like")
    public Result addLike(@RequestParam Integer articleId, @RequestParam Integer userId) {
        log.info("添加到喜欢: articleId: {}, userId: {}", articleId, userId);
        boolean ifLike = articleService.like(articleId, userId);
        return Result.success(ifLike);
    }
}
