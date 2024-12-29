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
        log.info("状态: {}", article.getStatus());
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
}
