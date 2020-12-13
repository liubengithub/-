package com.liu.service;

import com.liu.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author root
 * @create 2020-12-06 15:24
 */
public interface TagService {
    List<Tag> getTags();
    Tag getTagByName(String name);
    Tag getTagById(Long id);
    int addTag(Tag tag);
    int deleteTagById(Long id);
    int updateTag(Tag tag);
}
