package com.liu.service.impl;

import com.liu.mapper.PictureMapper;
import com.liu.pojo.Picture;
import com.liu.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author root
 * @create 2020-12-08 14:36
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureMapper pictureMapper;
    @Override
    @Transactional
    public List<Picture> pictureList() {
        return pictureMapper.pictureList();
    }

    @Override
    @Transactional
    public int addPicture(Picture picture) {
        return pictureMapper.addPicture(picture);
    }

    @Override
    @Transactional
    public int updatePicture(Picture picture) {
        return pictureMapper.updatePicture(picture);
    }

    @Override
    @Transactional
    public int deletePicture(Long id) {
        return pictureMapper.deletePicture(id);
    }

    @Override
    @Transactional
    public Picture getPictureById(Long id) {
        return pictureMapper.getPictureById(id);
    }
}
