package com.liu.mapper;

import com.liu.pojo.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-08 14:22
 */
@Mapper
@Repository
public interface FriendLinkMapper {
    //查询所有友链
    List<FriendLink> friendLinkList();
    //添加友链
    int addFriendLink(FriendLink friendLink);
    //更新友链
    int updateFriendLink(FriendLink friendLink);
    //删除友链
    int deleteFriendLink(@Param("id") Long id);
    //根据id查找友链
    FriendLink getFriendLinkById(@Param("id") Long id);
    //根据博客地址查找友链
    FriendLink getFriendLinkByBlogAddress(String blogaddress);
}
