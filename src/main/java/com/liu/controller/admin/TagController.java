package com.liu.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.Tag;
import com.liu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

/**
 * @author root
 * @create 2020-12-06 14:06
 */
@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    TagService tagService;
    @GetMapping("/tags")
    public String tags(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,5);
        List<Tag> tags = tagService.getTags();
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(tags);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/tags";
    }
    @GetMapping("/tags/input")
    public String toAddTag(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }
    @PostMapping("/tags")
    public String addTag(String name, RedirectAttributes attributes,@Valid Tag tag){
        Tag tag1 = tagService.getTagByName(name);
        if(tag1 != null){
            attributes.addFlashAttribute("msg","不能添加已存在的标签");
            return "redirect:/admin/tags/input";
        }
        int i = tagService.addTag(tag);
        if(i>0){
            attributes.addFlashAttribute("msg","添加成功");
        }else {
            attributes.addFlashAttribute("msg","添加失败");
        }
        return "redirect:/admin/tags";
    }
    @GetMapping("/tags/{id}")
    public String deleteTag(@PathVariable("id") Long id,RedirectAttributes attributes){
        int i = tagService.deleteTagById(id);
        if(i > 0){
            attributes.addFlashAttribute("msg","删除成功");
        }else {
            attributes.addFlashAttribute("msg","删除失败");
        }
        return "redirect:/admin/tags";
    }
    @GetMapping("/tags/input/{id}")
    public String toUpdateTag(@PathVariable("id") Long id,Model model){
        Tag tag = tagService.getTagById(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }
    @PostMapping("/tags/{id}")
    public String updateTag(String name,@PathVariable("id") Long id,RedirectAttributes attributes,Tag tag){
        Tag tag1 = tagService.getTagByName(name);
        if(tag1 != null){
            attributes.addFlashAttribute("msg","不能修改为已存在的标签");
            return "redirect:/admin/tags/input/{id}";
        }
        int i = tagService.updateTag(tag);
        if(i>0){
            attributes.addFlashAttribute("msg","修改成功");
        }else {
            attributes.addFlashAttribute("msg","修改失败");
        }
        return "redirect:/admin/tags";
    }
}
