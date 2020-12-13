package com.liu.mapper;

import com.liu.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-05 14:31
 */
@Repository
@Mapper
public interface TypeMapper {
    //新增一个Type
    int saveType(Type type);
    //根据Id查询Type
    Type getTypeById(@Param("id") Long id);
    //根据类型名查询分类
    Type getTypeByName(String name);
    //查询所有Type
    List<Type> typeList();
    //更新Type
    int updateType(Type type);
    //删除Type
    int deleteTypeById(@Param("id") Long id);

    //查询前四个type
    List<Type> getType();
}
