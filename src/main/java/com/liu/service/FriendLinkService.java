package com.liu.service;

import com.liu.pojo.FriendLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author root
 * @create 2020-12-08 14:33
 */
public interface FriendLinkService {

    List<FriendLink> friendLinkList();

    int addFriendLink(FriendLink friendLink);

    int updateFriendLink(FriendLink friendLink);

    int deleteFriendLink(Long id);

    FriendLink getFriendLinkById(Long id);
    FriendLink getFriendLinkByBlogAddress(String blogAddress);
}
