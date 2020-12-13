package com.liu.mapper;

import com.liu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author root
 * @create 2020-12-05 11:18
 */
@Mapper
@Repository
public interface UserMapper {
    User queryUserByUsername(String username);
}
