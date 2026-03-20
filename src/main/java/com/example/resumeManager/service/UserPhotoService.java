package com.example.resumeManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resumeManager.dao.IUserPhotoDao;
import com.example.resumeManager.dto.UserPhotoDto;

@Service
public class UserPhotoService {

    @Autowired
    IUserPhotoDao dao;

    public int insertPhoto(UserPhotoDto dto) {
        return dao.insertPhoto(dto);
    }

    public UserPhotoDto getPhotoByUserId(String userId) {
        return dao.getPhotoByUserId(userId);
    }

    public int deletePhotoByUserId(String userId) {
        return dao.deletePhotoByUserId(userId);
    }
}