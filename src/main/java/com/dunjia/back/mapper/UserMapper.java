package com.dunjia.back.mapper;

import com.dunjia.back.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users where id = #{id}")
    User getUserById(Integer id);

    @Select("select * from users")
    List<User> getUserList();
}
