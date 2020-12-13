package com.liu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author root
 * @create 2020-12-09 11:32
 * 博客信息实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstPageBlog {
    private Long id;
    private String title;
    private String flag;
    private String firstPicture;
    private String content;
    private Long  typeId;
    private String typeName;
    private String userName;
    private Integer views;
    //推荐
    private Boolean recommened;
    private Date createTime;
    private Date updateTime;
}
