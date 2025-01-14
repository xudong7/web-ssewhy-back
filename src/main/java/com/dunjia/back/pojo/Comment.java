package com.dunjia.back.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private Integer userId;
    private Integer articleId;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer status; // 0: 回复article 非0数值: 回复id为status的评论
}
