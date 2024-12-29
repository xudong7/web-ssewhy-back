package com.dunjia.back.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id; // 用户id
    private String username; // 用户名
    private String password; // 密码
    private String avatar; // 头像
    private String cover; // 封面
    private String email; // 邮箱
    private String mobile; // 手机号
    private String markCart; // 收藏夹
    private String publishCart; // 已发布
    private String fansCart; // 粉丝
    private String followCart; // 关注
    private LocalDateTime createTime; // 注册时间
    private LocalDateTime updateTime; // 更新时间
    private Integer status; // 0 - 禁用 1 - 启用
}
