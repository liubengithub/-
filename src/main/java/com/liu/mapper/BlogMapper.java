package com.liu.mapper;

import com.liu.entity.DetailedBlog;
import com.liu.entity.FirstPageBlog;
import com.liu.entity.RecommenedArticle;
import com.liu.pojo.Blog;
import com.liu.pojo.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-07 11:41
 */
@Mapper
@Repository
public interface BlogMapper {
    //查询所有博客
    List<Blog> getBlogs();
    //根据标题或者type查询
    List<Blog> getBlosByTitleOrType(@Param("title") String title,@Param("id") Long id);
    //根据id查询博客
    Blog getBlogById(Long id);
    //新增博客
    int addBlog(Blog blog);
    //删除博客
    int deleteBlogById(@Param("id") Long id);
    //修改博客
    int updateBlog(@Param("blog") Blog blog);

    //首页展示
    //查询三个推荐博客
    List<RecommenedArticle> getIndexRecommenedArticle(Boolean recommened);
    //由首页点击显示博客展示到博客页

    //由首页根据类型id查询所有的博客显示在博客页
    List<FirstPageBlog> getFirstPageBlogByTypeId(Long typeId);
    List<FirstPageBlog> getFirstPageBlogByBlogId(Long blogId);
    //查询5条博客展示在博客页
    List<FirstPageBlog> getFirstPageBlog();
     //查询三条推荐的博客
    List<Blog> getBlogByRecommened(Boolean recommened);
    //查询十条最火的博客文章（按浏览量）
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
    //文章访问更新
    int updateViews(Long id);
    //根据博客id查询出评论数量
    int getCommentCountByid(Long id);

}
