package com.liu.service.impl;

import com.liu.entity.AllComment;
import com.liu.mapper.BCommentMapper;
import com.liu.service.BCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author root
 * @create 2020-12-11 10:34
 */
@Service
public class BCommentServiceImpl implements BCommentService {
    @Autowired
    private BCommentMapper commentMapper;
    //存放所有评论的集合
    List<AllComment> replyList =new ArrayList<>();
    @Override
    public List<AllComment> getAllComment() {
        //查询父节点
        List<AllComment> comments = commentMapper.findAllParentComment(Long.parseLong("-1"));
        for(AllComment comment : comments){
            Long id = comment.getId();
            String firstParentNickName = comment.getNickName();
            //查询所有的一级子节点
            List<AllComment> childComments = commentMapper.findFirstChildComment(id);
            //查询所有的一级回复并装进集合中
            queryAllChild(childComments,firstParentNickName);
            comment.setReplyComments(replyList);
            replyList = new ArrayList<>();
        }
        return comments;
    }

    @Override
    public int saveComment(AllComment comment) {
        comment.setCreateTime(new Date());
        return commentMapper.saveComment(comment);
    }

    //查询是否有子评论也就是一级回复
    private void queryAllChild(List<AllComment> childComments,String parentNickName){
        //判断是否有一级子回复
        if(childComments.size()>0){
             for (AllComment childComment : childComments){
                 String parentNickName1 = childComment.getNickName();
                 childComment.setParentNickName(parentNickName);
                 replyList.add(childComment);
                 Long childId = childComment.getId();
                 //查询所有的二级回复以及所有的子集回复  装进集合
                 querySecondAndAllChild(childId,parentNickName1);
             }
        }

    }
    private void querySecondAndAllChild(Long childId,String parentNickName1){
        //根据一级评论的id找到二级评论
        List<AllComment> replyComments = commentMapper.findReplyComment(childId);
        if(replyComments.size()>0){
            for (AllComment replyComment : replyComments){
                String parentNickName = replyComment.getNickName();
                replyComment.setParentNickName(parentNickName1);
                replyList.add(replyComment);
                Long replyId = replyComment.getId();
                //循环迭代找出所有的子集回复
                querySecondAndAllChild(replyId,parentNickName);
            }
        }
    }

}
