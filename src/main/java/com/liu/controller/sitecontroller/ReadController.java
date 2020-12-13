package com.liu.controller.sitecontroller;

import com.liu.entity.Comment;
import com.liu.entity.DetailedBlog;
import com.liu.pojo.Blog;
import com.liu.pojo.User;
import com.liu.service.BlogService;
import com.liu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author root
 * @create 2020-12-10 10:56
 */
@Controller
public class ReadController {
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @GetMapping("/read/{id}")
    public String read(@PathVariable Long id, Model model){
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
       // System.out.println(detailedBlog);
        Blog preBlog = blogService.getBlogById(detailedBlog.getPreId());
        Blog nextBlog = blogService.getBlogById(detailedBlog.getNextId());
        if(preBlog != null){
            detailedBlog.setPreTitle(preBlog.getTitle());
        }else {
            detailedBlog.setPreTitle("无");
            detailedBlog.setPreId(detailedBlog.getId());
        }
        if(nextBlog != null){
            detailedBlog.setNextTitle(nextBlog.getTitle());
        }else {
            detailedBlog.setNextTitle("无");
            detailedBlog.setNextId(detailedBlog.getId());
        }
        model.addAttribute("blog",detailedBlog);
        return "site/read";
    }

    /**
     * 局部页面更新-----更新页面下的th：fragment="commentList" 的区域
     * @return
     * 查询所有评论
     */
//查询评论列表
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.getCommentsById(blogId);
        model.addAttribute("comments", comments);
        return "site/read :: commentList";
    }

    //新增评论
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session, Model model) {
        Long blogId = comment.getBlogId();

        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        List<Comment> comments = commentService.getCommentsById(blogId);
        model.addAttribute("comments", comments);
        return "site/read :: commentList";
    }

    //删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId, @PathVariable Long id, Comment comment, RedirectAttributes attributes, Model model){
        commentService.deleteComment(comment,id);
        DetailedBlog detailedBlog = blogService.getDetailedBlog(blogId);
        List<Comment> comments = commentService.getCommentsById(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "site/read";
    }

}
