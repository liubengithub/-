package com.liu.service;

import com.liu.entity.DetailedBlog;
import com.liu.entity.FirstPageBlog;
import com.liu.entity.RecommenedArticle;
import com.liu.pojo.Blog;

import java.util.List;

/**
 * @author root
 * @create 2020-12-07 11:53
 */
public interface BlogService {
    //查询所有博客
    List<Blog> getBlogs();
    //根据标题或者type查询
    List<Blog> getBlosByTitleOrType(String title,Long id);
    //根据id查询博客
    Blog getBlogById(Long id);
    //新增博客
    int addBlog(Blog blog);
    //删除博客
    int deleteBlogById(Long id);
    //修改博客
    int updateBlog(Blog blog);
    //展示三条博客在首页
    List<RecommenedArticle> getIndexRecommenedArticle(Boolean recommened);
    List<FirstPageBlog> getFirstPageBlogByTypeId(Long typeId);
    List<FirstPageBlog> getFirstPageBlogByBlogId(Long blogId);
    //查询5条博客展示在博客页
    List<FirstPageBlog> getFirstPageBlog();
    List<Blog> getBlogByRecommened(Boolean recommened);
    List<Blog> getBlogByViews();
    //搜索博客列表
    List<FirstPageBlog> getSearchBlog(String query);
    //统计博客总数
    Integer getBlogTotal();
    //统计访问总数
    Integer getBlogViewTotal();
    //统计评论总数
    Integer getBlogCommentTotal();
    //统计留言总数
    Integer getBlogMessageTotal();

    //查询博客详情
    DetailedBlog getDetailedBlog(Long id);
}
