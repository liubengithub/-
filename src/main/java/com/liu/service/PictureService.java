package com.liu.service;

import com.liu.pojo.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author root
 * @create 2020-12-08 14:34
 */
public interface PictureService {

    List<Picture> pictureList();

    int addPicture(Picture picture);

    int updatePicture(Picture picture);

    int deletePicture(Long id);

    Picture getPictureById(Long id);
}
