package com.example.resumeManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resumeManager.dao.ISelfIntroDao;
import com.example.resumeManager.dto.SelfIntroDto;

@Service
public class SelfIntroService {
	@Autowired
	ISelfIntroDao dao;
	
	public List<SelfIntroDto> introList(String userId){
		return dao.introList(userId);
	}
	
	public SelfIntroDto introDetail(int introId) {
		return dao.introDetail(introId);
	}
	
	public int introWrite(SelfIntroDto dto) {
		return dao.introWrite(dto);
	}
	
	int introEdit(SelfIntroDto dto) {
		return dao.introEdit(dto);
	}
	
	public int introDelete(int introId) {
		return dao.introDelete(introId);
	}
}
