package com.example.resumeManager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.resumeManager.dto.UserPhotoDto;

@Mapper
public interface IUserPhotoDao {

    int insertPhoto(UserPhotoDto dto);

    UserPhotoDto getPhotoByUserId(@Param("userId") String userId);

    int deletePhotoByUserId(@Param("userId") String userId);
}