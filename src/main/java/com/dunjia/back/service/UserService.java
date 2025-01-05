package com.dunjia.back.service;

import com.dunjia.back.mapper.ArticleMapper;
import com.dunjia.back.mapper.UserMapper;
import com.dunjia.back.pojo.Article;
import com.dunjia.back.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Resource
    private ArticleMapper articleMapper;

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public Integer login(String username, String password) {
        User user = userMapper.getUserByUsernameAndPassword(username, password);
        return user.getId();
    }

    public void register(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    public boolean collect(Integer userId, Integer articleId) {
        User user = userMapper.getUserById(userId);
        Article article = articleMapper.getArticleById(articleId);
        String markCart = user.getMarkCart();
        // 判断是否为空
        if (markCart == null) {
            markCart = "";
        }
        // 收藏
        if (!markCart.contains("," + articleId + ",")) {
            markCart += "," + articleId + ",";
            user.setMarkCart(markCart);
            article.setMarks(article.getMarks() + 1);
            articleMapper.updateArticle(article);
            userMapper.updateUser(user);
            return true;
        }
        // 取消收藏
        else {
            markCart = markCart.replace("," + articleId + ",", "");
            user.setMarkCart(markCart);
            article.setMarks(article.getMarks() - 1);
            articleMapper.updateArticle(article);
            userMapper.updateUser(user);
            return false;
        }
    }

    public boolean fan(Integer userId, Integer fanId) {
        User user = userMapper.getUserById(userId);
        User fan = userMapper.getUserById(fanId);
        String followCart = fan.getFollowCart();
        String fanCart = user.getFansCart();
        // 判断是否为空
        if (fanCart == null) {
            fanCart = "";
        }
        if (followCart == null) {
            followCart = "";
        }
        // 关注
        if (!fanCart.contains("," + fanId + ",")) {
            fanCart += "," + fanId + ",";
            user.setFansCart(fanCart);
            // fan的followCart也要更新
            followCart += "," + userId + ",";
            fan.setFollowCart(followCart);
            userMapper.updateUser(fan);
            userMapper.updateUser(user);
            return true;
        }
        // 取消关注
        else {
            fanCart = fanCart.replace("," + fanId + ",", "");
            user.setFansCart(fanCart);
            // fan的followCart也要更新
            followCart = followCart.replace("," + userId + ",", "");
            fan.setFollowCart(followCart);
            userMapper.updateUser(fan);
            userMapper.updateUser(user);
            return false;
        }
    }
}
    