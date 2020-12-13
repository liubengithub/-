package com.liu.service.impl;

import com.liu.mapper.TagMapper;
import com.liu.pojo.Tag;
import com.liu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author root
 * @create 2020-12-06 15:24
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    @Override
    @Transactional
    public List<Tag> getTags() {
        return tagMapper.getTags();
    }

    @Override
    @Transactional
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    @Transactional
    public Tag getTagById(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    @Transactional
    public int addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    @Transactional
    public int deleteTagById(Long id) {
        return tagMapper.deleteTagById(id);
    }

    @Override
    @Transactional
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }
}
