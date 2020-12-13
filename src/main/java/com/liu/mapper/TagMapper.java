package com.liu.mapper;

import com.liu.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-06 15:18
 */
@Mapper
@Repository
public interface TagMapper {
    List<Tag> getTags();
    Tag getTagByName(String name);
    Tag getTagById(@Param("id") Long id);
    int addTag(Tag tag);
    int deleteTagById(@Param("id")Long id);
    int updateTag(Tag tag);
}
