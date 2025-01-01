package com.dunjia.back.service;

import com.dunjia.back.mapper.UserMapper;
import com.dunjia.back.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

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
        String markCart = user.getMarkCart();
        // 判断是否为空
        if (markCart == null) {
            markCart = "";
        }
        // 收藏
        if (!markCart.contains(articleId + ",")) {
            markCart += articleId + ",";
            user.setMarkCart(markCart);
            userMapper.updateUser(user);
            return true;
        }
        // 取消收藏
        else {
            markCart = markCart.replace(articleId + ",", "");
            user.setMarkCart(markCart);
            userMapper.updateUser(user);
            return false;
        }
    }
}
    