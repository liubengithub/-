package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author root
 * @create 2020-12-10 20:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diary {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String content;
}
