package com.liu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author root
 * @create 2020-12-10 14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommenedArticle {
    private Long id;
    private String firstPicture;
    private Long typeId;
    private String typeName;
    private String createTime;
    private String updateTime;
    private Boolean recommened;
    private String description;
}
