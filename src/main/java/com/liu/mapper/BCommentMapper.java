package com.liu.mapper;

import com.liu.entity.AllComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-11 10:32
 */
@Mapper
@Repository
public interface BCommentMapper {
     //查询所有父级评论
    List<AllComment> findAllParentComment(@Param("parentId") Long parentId);
    //查询父级评论的一级回复
    List<AllComment> findFirstChildComment(@Param("parentId") Long parentId);
    //查询二级回复以及所有子集回复
    List<AllComment> findReplyComment(@Param("parentId") Long parentId);
    //添加一个评论
    int saveComment(AllComment comment);
}
