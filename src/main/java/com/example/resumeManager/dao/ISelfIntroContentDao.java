package com.example.resumeManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.resumeManager.dto.IntroContentDto;

@Mapper
public interface ISelfIntroContentDao {
	List<IntroContentDto> contentList(@Param("introId")int introId);

	int contentWrite(IntroContentDto dto);

	int contentEdit(IntroContentDto dto);

	int contentDelete(@Param("contentId") int contentId);
}
