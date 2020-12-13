package com.liu.mapper;

import com.liu.pojo.Diary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-10 21:00
 */
@Mapper
@Repository
public interface DiaryMapper {
    List<Diary> getAllDiary();
}
