package com.liu.service.impl;

import com.liu.mapper.FriendLinkMapper;
import com.liu.pojo.FriendLink;
import com.liu.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author root
 * @create 2020-12-08 14:35
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {
    @Autowired
    FriendLinkMapper friendLinkMapper;
    @Override
    @Transactional
    public List<FriendLink> friendLinkList() {
        return friendLinkMapper.friendLinkList();
    }

    @Override
    @Transactional
    public int addFriendLink(FriendLink friendLink) {
        return friendLinkMapper.addFriendLink(friendLink);
    }

    @Override
    @Transactional
    public int updateFriendLink(FriendLink friendLink) {
        return friendLinkMapper.updateFriendLink(friendLink);
    }

    @Override
    @Transactional
    public int deleteFriendLink(Long id) {
        return friendLinkMapper.deleteFriendLink(id);
    }

    @Override
    @Transactional
    public FriendLink getFriendLinkById(Long id) {
        return friendLinkMapper.getFriendLinkById(id);
    }

    @Override
    @Transactional
    public FriendLink getFriendLinkByBlogAddress(String blogAddress) {
        return friendLinkMapper.getFriendLinkByBlogAddress(blogAddress);
    }
}
