package com.liu.service;

import com.liu.entity.AllComment;

import java.util.List;

/**
 * @author root
 * @create 2020-12-11 10:34
 */
public interface BCommentService {
    //查询所有评论
    List<AllComment> getAllComment();
    //保存评论
    int saveComment(AllComment comment);
}
