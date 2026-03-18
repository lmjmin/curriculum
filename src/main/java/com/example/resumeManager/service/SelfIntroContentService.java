package com.example.resumeManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resumeManager.dao.ISelfIntroContentDao;
import com.example.resumeManager.dto.IntroContentDto;

@Service
public class SelfIntroContentService {

	@Autowired
	private ISelfIntroContentDao contentDao;

	public List<IntroContentDto> contentList(int introId) {
		return contentDao.contentList(introId);
	}

	public int contentWrite(IntroContentDto dto) {
		return contentDao.contentWrite(dto);
	}

	public int contentEdit(IntroContentDto dto) {
		return contentDao.contentEdit(dto);
	}

	public int contentDelete(int contentId) {
		return contentDao.contentDelete(contentId);
	}
}