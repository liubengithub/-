package com.liu.service;

import com.liu.entity.Comment;

import java.util.List;

/**
 * @author root
 * @create 2020-12-10 13:45
 */
public interface CommentService {
    //根据博客Id查询评论信息
    List<Comment> getCommentsById(Long id);
    //添加保存评论
    int saveComment(Comment comment);
    //删除评论
    void deleteComment(Comment comment, Long id);
}
