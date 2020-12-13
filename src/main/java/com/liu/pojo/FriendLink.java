package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 友链实体类
 * @author root
 * @create 2020-12-08 14:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendLink {
    private Long id;
    private String blogName;
    private String blogAddress;
    private String pictureAddress;
    private Date createTime;
}
