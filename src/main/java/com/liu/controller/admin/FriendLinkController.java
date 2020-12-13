package com.liu.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.FriendLink;
import com.liu.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author root
 * @create 2020-12-08 14:53
 */
@Controller
@RequestMapping("/admin")
public class FriendLinkController {
    @Autowired
    FriendLinkService friendLinkService;
    @GetMapping("/friendlinks")
    public String toFriendlinks(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,5);
        List<FriendLink> friendLinks = friendLinkService.friendLinkList();
        PageInfo<FriendLink> pageInfo = new PageInfo<FriendLink>(friendLinks);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/friendlinks";
    }
    @GetMapping("/friendlinks/input")
    public String toFriendlinksInput(Model model){
        model.addAttribute("friendlink",new FriendLink());
        return "admin/friendlinks-input";
    }
    @PostMapping("/friendlinks")
    public String addFriendLink(@Valid FriendLink friendLink, BindingResult result, RedirectAttributes attributes){
        FriendLink friendLink1 = friendLinkService.getFriendLinkByBlogAddress(friendLink.getBlogAddress());
        if(friendLink1 != null){
            attributes.addFlashAttribute("msg","不能添加相同的网站");
            return "redirect:/admin/friendlinks/input";
        }
        if(result.hasErrors()){
            return "admin/friendlinks-input";
        }
        int i = friendLinkService.addFriendLink(friendLink);
        if(i>0){
            attributes.addFlashAttribute("msg","添加成功");
        }else {
            attributes.addFlashAttribute("msg","添加失败");
        }
        return "redirect:/admin/friendlinks";
    }
    @GetMapping("/friendlinks/{id}")
    public String deleteFriendLink(@PathVariable("id") Long id,RedirectAttributes attributes){
        int i = friendLinkService.deleteFriendLink(id);
        if(i>0){
            attributes.addFlashAttribute("msg","删除成功！！！");
        }else {
            attributes.addFlashAttribute("msg","删除失败！！！");
        }
        return "redirect:/admin/friendlinks";
    }
    @GetMapping("/friendlinks/input/{id}")
    public String toUpdatePage(@PathVariable("id") Long id,Model model){
        FriendLink friendLink = friendLinkService.getFriendLinkById(id);
        model.addAttribute("friendlink",friendLink);
        return "admin/friendlinks-input";
    }
    @PostMapping("/friendlinks/{id}")
    public String updateFriendlink(@Valid FriendLink friendLink,RedirectAttributes attributes){
        int i = friendLinkService.updateFriendLink(friendLink);
        if(i>0){
            attributes.addFlashAttribute("msg","修改成功");
        }else {
            attributes.addFlashAttribute("msg","修改失败");
        }
        return "redirect:/admin/friendlinks";
    }
}
