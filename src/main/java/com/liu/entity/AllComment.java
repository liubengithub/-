package com.liu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author root
 * @create 2020-12-11 10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllComment {
    private Long id;
    private String nickName;
    private String email;
    private String avatar;
    private Date createTime;
    private String content;

    private Long parentCommentId;

    //回复评论
    private List<AllComment> replyComments=new ArrayList<>();
    private AllComment parentComment;
    private String parentNickName;

}
