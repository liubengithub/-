package com.liu.mapper;

import com.liu.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-10 11:02
 */
@Repository
@Mapper
public interface CommentMapper {
    //查询父级评论
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);
    //查询一级回复
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId")Long blogId, @Param("id") Long id);
    //查询二级回复
    List<Comment> findByBlogIdAndReplayId(@Param("blogId")Long blogId, @Param("childId") Long childId);
    //添加一个评论
    int saveComment(Comment comment);
    //删除评论
    int deleteComment(Long id);
}
