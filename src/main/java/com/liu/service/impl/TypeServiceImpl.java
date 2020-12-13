package com.liu.service.impl;

import com.liu.mapper.TypeMapper;
import com.liu.pojo.Type;
import com.liu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author root
 * @create 2020-12-05 14:37
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    @Transactional
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    @Transactional
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    @Transactional
    public List<Type> typeList() {
        return typeMapper.typeList();
    }

    @Override
    @Transactional
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    @Transactional
    public int deleteTypeById(Long id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    @Transactional
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

}
