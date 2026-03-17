package com.example.resumeManager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.resumeManager.dto.UserDto;

@Mapper
public interface IRmUserDao {

	int signup(UserDto dto);

	UserDto login(@Param("userId") String userId,
                  @Param("pw") String pw);

	UserDto getUser(@Param("userId") String userId);

	int updateUser(UserDto dto);

	int deleteUser(@Param("userId") String userId);
}