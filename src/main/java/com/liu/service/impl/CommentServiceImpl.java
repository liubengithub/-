package com.liu.service.impl;

import com.liu.entity.Comment;
import com.liu.mapper.BlogMapper;
import com.liu.mapper.CommentMapper;
import com.liu.service.CommentService;
import com.liu.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author root
 * @create 2020-12-10 13:48
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    BlogMapper blogMapper;
    private List<Comment> replysList = new ArrayList<>();
    @Override
    public List<Comment> getCommentsById(Long id) {
        //查询出父节点
        List<Comment> comments = commentMapper.findByBlogIdParentIdNull(id, Long.parseLong("-1"));
        for(Comment comment : comments){
            Long parentId = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentMapper.findByBlogIdParentIdNotNull(id,parentId);
            //查询出子评论
            combineChildren(id, childComments, parentNickname1);
            comment.setReplyComments(replysList);
            replysList = new ArrayList<>();
        }
        return comments;
    }
    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
        //判断是否有一级子评论
        if(childComments.size() > 0){
            //循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                replysList.add(childComment);
                Long childId = childComment.getId();
                //查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }
    private void recursively(Long blogId, Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentMapper.findByBlogIdAndReplayId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                replysList.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }

    //新增评论
    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int comments = commentMapper.saveComment(comment);
        //文章评论计数
        blogMapper.getCommentCountByid(comment.getBlogId());

        return comments;
    }

    //删除评论
    @Override
    public void deleteComment(Comment comment,Long id) {
        commentMapper.deleteComment(id);
        blogMapper.getCommentCountByid(comment.getBlogId());
    }

}
