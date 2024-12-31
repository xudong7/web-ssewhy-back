package com.dunjia.back.mapper;

import com.dunjia.back.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users where id = #{id}")
    User getUserById(Integer id);

    @Select("select * from users")
    List<User> getUserList();

    @Select("select * from users where username = #{username} and password = #{password}")
    User getUserByUsernameAndPassword(String username, String password);

    void insertUser(User user);

    void updateUser(User user);

    @Delete("delete from users where id = #{id}")
    void deleteUser(Integer id);
}
