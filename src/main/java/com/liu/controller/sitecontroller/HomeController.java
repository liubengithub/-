package com.liu.controller.sitecontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.entity.AllComment;
import com.liu.entity.FirstPageBlog;
import com.liu.entity.RecommenedArticle;
import com.liu.pojo.Blog;
import com.liu.pojo.Diary;
import com.liu.pojo.FriendLink;
import com.liu.pojo.Type;
import com.liu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author root
 * @create 2020-12-01 10:30
 */
@Controller
public class HomeController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    FriendLinkService friendLinkService;
    @Autowired
    DiaryService diaryService;
    @Autowired
    BCommentService commentService;
    @RequestMapping({"/","/index"})
    public String blogIndex(Model model){
        List<RecommenedArticle> articleList = blogService.getIndexRecommenedArticle(true);
        model.addAttribute("articles",articleList);
      //  System.out.println(articleList);
        return "site/index";
    }
    @RequestMapping("/message")
    public String toMessage(Model model){
        List<AllComment> comments = commentService.getAllComment();
       // System.out.println(comments);
        model.addAttribute("comments",comments);
        return "site/message";
    }
    @PostMapping("/addMessage")
    public String addMessage(@Valid AllComment allComment, RedirectAttributes attributes){
        int i = commentService.saveComment(allComment);
        List<AllComment> comments = commentService.getAllComment();
        if(i>0){
            attributes.addFlashAttribute("comments",comments);
        }
        return "redirect:/message";
    }
    @PostMapping("/toReply")
    public String toReply(@Valid AllComment allComment, RedirectAttributes attributes){
        int i = commentService.saveComment(allComment);
        List<AllComment> comments = commentService.getAllComment();
        if(i>0){
            attributes.addFlashAttribute("comments",comments);
        }
        return "redirect:/message";
    }
    @RequestMapping("/diary")
    public String toDiary(Model model){
        List<Diary> diaries = diaryService.getAllDiary();
        model.addAttribute("diaries",diaries);
        return "site/diary";
    }
    @RequestMapping("/link")
    public String toLink(Model model){
        List<FriendLink> friendLinks = friendLinkService.friendLinkList();
        model.addAttribute("friendLinks",friendLinks);
        return "site/link";
    }
    @RequestMapping("/read")
    public String toRead(){
        return "site/read";
    }
}
