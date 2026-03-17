package com.example.resumeManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resumeManager.dao.IRmUserDao;
import com.example.resumeManager.dto.UserDto;

@Service
public class RmUserService {
	@Autowired
	IRmUserDao dao;
	
	public int signup(UserDto dto) {
		return dao.signup(dto);
	}
	
	public UserDto login(String userId,String pw) {
		return dao.login(userId, pw);
	}
	
	public UserDto getUser(String userId) {
		return dao.getUser(userId);
	}
	
	public int updateUser(UserDto dto) {
		return dao.updateUser(dto);
	}
	
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}
}
