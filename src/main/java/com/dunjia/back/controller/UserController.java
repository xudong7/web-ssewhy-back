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
import java.util.Map;

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
        Integer id = userService.login(user.getUsername(), user.getPassword());
        // 返回用户id和token
        if (id != null) {
            String token = JwtUtil.createToken();
            return Result.success(Map.of("id", id, "token", token));
        }
        return Result.error("登录失败");
    }

    /**
     * 注册 添加用户
     * @param user
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        log.info("注册用户: {}", user);
        // 注册用户
        userService.register(user);
        return Result.success("注册成功");
    }

    /**
     * 修改用户信息
     * @param user
     */
    @PutMapping("/user")
    public Result updateUser(@RequestBody User user) {
        log.info("修改用户信息: {}", user);
        userService.updateUser(user);
        return Result.success("修改成功");
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

    /**
     * 删除特定id的用户
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        log.info("删除用户id: {}", id);
        userService.deleteUser(id);
        return Result.success("删除成功");
    }
}
