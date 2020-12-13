package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 照片实体类
 * @author root
 * @create 2020-12-08 14:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private Long id;
    private String pictureName;
    private String pictureTime;
    private String pictureAddress;
    private String pictureDescription;
}
