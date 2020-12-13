package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author root
 * @create 2020-12-04 17:28
 * 博客分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    //类型名
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<Blog>();
}
