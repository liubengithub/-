package com.liu.service;

import com.liu.pojo.Diary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-10 21:03
 */
public interface DiaryService {
    List<Diary> getAllDiary();
}
