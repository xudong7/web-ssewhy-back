package com.dunjia.back.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id; // 博客id
    private Integer userId; // 用户id
    private String title; // 标题
    private String content; // 内容
    private String cover; // 封面
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    private Integer status; // 0 - 草稿 1 - 发布
    private Integer views; // 浏览量
    private Integer likes; // 点赞
    private Integer marks; // 收藏
    private Integer comments; // 评论
}
