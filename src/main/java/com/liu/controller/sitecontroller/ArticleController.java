package com.liu.controller.sitecontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.entity.FirstPageBlog;
import com.liu.pojo.Blog;
import com.liu.pojo.Type;
import com.liu.service.BlogService;
import com.liu.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author root
 * @create 2020-12-09 18:56
 */
@Controller
public class ArticleController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @GetMapping("/article")
    public String toArticle(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> firstPageBlog = blogService.getFirstPageBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlog);
        model.addAttribute("pageInfo",pageInfo);

        List<Type> types = typeService.typeList();
        model.addAttribute("types",types);
        List<Blog> blogByRecommened = blogService.getBlogByRecommened(true);
        model.addAttribute("blogs",blogByRecommened);

        List<Blog> blogByViews = blogService.getBlogByViews();
        model.addAttribute("viewsBlogs",blogByViews);
        return "site/article";
    }
    @GetMapping("/article/{id}")
    public String toArticleByTypeName(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@PathVariable Long id){

        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> firstPageBlog = blogService.getFirstPageBlogByTypeId(id);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlog);
        model.addAttribute("pageInfo",pageInfo);

        List<Type> types = typeService.typeList();
        model.addAttribute("types",types);
        List<Blog> blogByViews = blogService.getBlogByViews();
        model.addAttribute("viewsBlogs",blogByViews);
        List<Blog> blogByRecommened = blogService.getBlogByRecommened(true);
        model.addAttribute("blogs",blogByRecommened);
        return "site/article";
    }
    @GetMapping("/article/query/{id}")
    public String toArticleByBlogId(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@PathVariable Long id){

        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> firstPageBlog = blogService.getFirstPageBlogByBlogId(id);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlog);
        model.addAttribute("pageInfo",pageInfo);

        List<Type> types = typeService.typeList();
        model.addAttribute("types",types);

        List<Blog> blogByViews = blogService.getBlogByViews();
        model.addAttribute("viewsBlogs",blogByViews);

        List<Blog> blogByRecommened = blogService.getBlogByRecommened(true);
        model.addAttribute("blogs",blogByRecommened);
        return "site/article";
    }
    @PostMapping("/search")
    public String search(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam String query,Model model){
        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);

        List<Type> types = typeService.typeList();
        model.addAttribute("types",types);

        List<Blog> blogByViews = blogService.getBlogByViews();
        model.addAttribute("viewsBlogs",blogByViews);

        List<Blog> blogByRecommened = blogService.getBlogByRecommened(true);
        model.addAttribute("blogs",blogByRecommened);

        return "site/article";
    }
}
