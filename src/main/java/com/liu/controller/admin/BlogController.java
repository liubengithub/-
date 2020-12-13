package com.liu.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.Blog;
import com.liu.pojo.Type;
import com.liu.pojo.User;
import com.liu.service.BlogService;
import com.liu.service.TypeService;
import com.liu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author root
 * @create 2020-12-05 13:42
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    UserService userService;
    @GetMapping("/blogs")
    public String blogs(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model){
        String orderBy = "create_time desc";
        PageHelper.startPage(pageNum,5,orderBy);
        List<Blog> blogs = blogService.getBlogs();
        System.out.println(blogs);
        PageInfo pageInfo = new PageInfo(blogs);

        model.addAttribute("types",typeService.typeList());
        model.addAttribute("pageInfo",pageInfo);

        return "admin/blogs";
    }
    @PostMapping("/blogs/search")
    public String Search(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,String title,Long typeId,Model model){
        PageHelper.startPage(pageNum,5);
        List<Blog> blogList = blogService.getBlosByTitleOrType(title,typeId);
         PageInfo pageInfo = new PageInfo(blogList);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }
    @GetMapping("/blogs/input")
    public String toBlogsInput(Model model){
        List<Type> types = typeService.typeList();
        model.addAttribute("types",types);
        model.addAttribute("blog",new Blog());
        return "admin/blogs-input";
    }
    @PostMapping("/blogs")
    public String addBlog(Blog blog, RedirectAttributes attributes){
        User user = userService.queryUserByUsername("admin");
        blog.setUser(user);
        blog.setType(typeService.getTypeById(blog.getType().getId()));
        int i = blogService.addBlog(blog);
        if(i>0){
            attributes.addFlashAttribute("msg","新增成功");
        }else {
            attributes.addFlashAttribute("msg","新增失败");
        }
        return "redirect:/admin/blogs";
    }
    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") Long id,RedirectAttributes attributes){
        int i = blogService.deleteBlogById(id);
        if(i>0){
            attributes.addFlashAttribute("msg","删除成功");
        }else {
            attributes.addFlashAttribute("msg","删除失败");
        }
        return "redirect:/admin/blogs";
    }
    @GetMapping("/blogs/input/{id}")
    public String tuUpdatePage(@PathVariable("id") Long id,Model model){
        Blog blog = blogService.getBlogById(id);
        List<Type> types = typeService.typeList();
        model.addAttribute("blog",blog);
        model.addAttribute("types",types);
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/{id}")
    public String updateBlog(@Valid Blog blog,RedirectAttributes attributes){
        Long id = blog.getType().getId();
        Type type = typeService.getTypeById(id);
        blog.setType(type);
        blog.setUpdateTime(new Date());
        int i = blogService.updateBlog(blog);
        if(i>0){
            attributes.addFlashAttribute("msg","修改成功");
        }else {
            attributes.addFlashAttribute("msg","修改失败");
        }
        return "redirect:/admin/blogs";
    }
}
