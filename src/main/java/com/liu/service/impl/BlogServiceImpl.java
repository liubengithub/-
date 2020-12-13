package com.liu.service.impl;

import com.liu.entity.DetailedBlog;
import com.liu.entity.FirstPageBlog;
import com.liu.entity.RecommenedArticle;
import com.liu.exception.MyException;
import com.liu.mapper.BlogMapper;
import com.liu.pojo.Blog;
import com.liu.pojo.dto.ResultEnum;
import com.liu.service.BlogService;
import com.liu.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author root
 * @create 2020-12-07 11:53
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Override
    @Transactional
    public List<Blog> getBlogs() {
        return blogMapper.getBlogs();
    }

    @Override
    @Transactional
    public List<Blog> getBlosByTitleOrType(String title, Long id) {
        return blogMapper.getBlosByTitleOrType(title,id);
    }

    @Override
    @Transactional
    public Blog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    @Transactional
    public int addBlog(Blog blog) {
        blog.setViews(0);

        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());

        return blogMapper.addBlog(blog);
    }

    @Override
    @Transactional
    public int deleteBlogById(Long id) {
        return blogMapper.deleteBlogById(id);
    }

    @Override
    @Transactional
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public List<RecommenedArticle> getIndexRecommenedArticle(Boolean recommened) {
        return blogMapper.getIndexRecommenedArticle(recommened);
    }

    @Override
    public List<FirstPageBlog> getFirstPageBlogByTypeId(Long typeId) {
        return blogMapper.getFirstPageBlogByTypeId(typeId);
    }

    @Override
    public List<FirstPageBlog> getFirstPageBlogByBlogId(Long blogId) {
        return blogMapper.getFirstPageBlogByBlogId(blogId);
    }

    @Override
    public List<FirstPageBlog> getFirstPageBlog() {
        return blogMapper.getFirstPageBlog();
    }

    @Override
    public List<Blog> getBlogByRecommened(Boolean recommened) {
        return blogMapper.getBlogByRecommened(recommened);
    }

    @Override
    public List<Blog> getBlogByViews() {
        return blogMapper.getBlogByViews();
    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogMapper.getSearchBlog(query);
    }

    @Override
    public Integer getBlogTotal() {
        return blogMapper.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogMapper.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogMapper.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogMapper.getBlogMessageTotal();
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlog(id);
        if(detailedBlog == null){
            throw new MyException(ResultEnum.NOT_FOUND_BLOG);
        }

//        String content = detailedBlog.getContent();
//         detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));

        blogMapper.updateViews(id);
        blogMapper.getCommentCountByid(id);

        Long preId = detailedBlog.getId()-1;
        Long nextId = detailedBlog.getId()+1;

        detailedBlog.setPreId(preId);
        detailedBlog.setNextId(nextId);

        return detailedBlog;
    }


}
