package com.dunjia.back.mapper;

import com.dunjia.back.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from articles where id = #{id}")
    Article getArticleById(Integer id);

    @Select("select * from articles")
    List<Article> getArticleList();

    void addArticle(Article article);

    void updateArticle(Article article);
}
