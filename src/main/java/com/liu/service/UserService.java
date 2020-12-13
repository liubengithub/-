package com.liu.service;

import com.liu.pojo.User;

/**
 * @author root
 * @create 2020-12-05 10:13
 */
public interface UserService {
    User queryUserByUsername(String username);
}
