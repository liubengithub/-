package com.liu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author root
 * @create 2020-12-10 10:11
 * 博客详情实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedBlog {
    //博客id
    private Long id;
    //博客作者
    private String nickName;
    //浏览量
    private Integer views;
    //更新时间
    private Date updateTime;
    //创建时间
    private Date createTime;
    //内容
    private String content;
    //博客标题
    private String title;
    //博客评论数量
    private Integer commentCount;
    //开启评论
    private Boolean commentabled;
    //版权开启
    private Boolean shareStatement;
    //赞赏开启
    private Boolean apperciation;
    //上一篇
    private Long preId;
    private String preTitle;
    //下一篇
    private Long nextId;
    private String nextTitle;
}
