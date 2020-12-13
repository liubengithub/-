package com.liu.service.impl;

import com.liu.mapper.DiaryMapper;
import com.liu.pojo.Diary;
import com.liu.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author root
 * @create 2020-12-10 21:04
 */
@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    DiaryMapper diaryMapper;
    @Override
    public List<Diary> getAllDiary() {
        return diaryMapper.getAllDiary();
    }
}
