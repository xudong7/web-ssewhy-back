package com.dunjia.back.mapper;

import com.dunjia.back.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from comments")
    List<Comment> getAllComments();

    void addComment(Comment comment);
}
