package com.dunjia.back.controller;

import com.dunjia.back.pojo.Result;
import com.dunjia.back.pojo.User;
import com.dunjia.back.service.UserService;
import com.dunjia.back.utils.JwtUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (userService.login(user.getUsername(), user.getPassword())) {
            String token = JwtUtil.createToken();
            return Result.success(token);
        }
        return Result.error("登录失败");
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Result getUserById(@PathVariable Integer id) {
        log.info("查询用户id: {}", id);
        User user = userService.getUserById(id);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("用户不存在");
    }

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("/user")
    public Result getUserList() {
        log.info("查询全部用户");
        List<User> users = userService.getUserList();
        return Result.success(users);
    }
}
