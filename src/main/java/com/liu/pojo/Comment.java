package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author root
 * @create 2020-12-04 17:33
 * 博客评论
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    //昵称
    private String nickName;
    //邮箱
    private String email;
    //头像
    private String content;
    //评论内容
    private String avatar;
    //管理员评论
    private Boolean adminComment;

    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne()
    private Blog blog;
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();
    @ManyToOne
    private Comment parentComment;
}
