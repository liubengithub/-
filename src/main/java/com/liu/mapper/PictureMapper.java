package com.liu.mapper;

import com.liu.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 * @create 2020-12-08 14:23
 */
@Mapper
@Repository
public interface PictureMapper {
    //查询所有图片
    List<Picture> pictureList();
    //增加照片
    int addPicture(Picture picture);
    //更新照片
    int updatePicture(Picture picture);
    //删除照片
    int deletePicture(@Param("id") Long id);
    //根据Id获取照片
    Picture getPictureById(@Param("id") Long id);

}
