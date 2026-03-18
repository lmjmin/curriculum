package com.example.resumeManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.resumeManager.dto.SelfIntroDto;

@Mapper
public interface ISelfIntroDao {
	List<SelfIntroDto> introList(@Param("userId") String userId);
	
	SelfIntroDto introDetail(@Param("introId")int introId);
	
	int introWrite(SelfIntroDto dto);
	
	int introEdit(SelfIntroDto dto);
	
	int introDelete(@Param("introId")int introId);
}
