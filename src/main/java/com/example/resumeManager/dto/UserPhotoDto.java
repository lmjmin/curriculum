package com.example.resumeManager.dto;

import java.time.LocalDate;

import lombok.Data;

//사진
@Data
public class UserPhotoDto {
	private int photoId;
	private String userId;
	private String fileName;      // 서버 저장 이름
	private String originalName;  // 원본 파일명
	private LocalDate uploadDate;
}
