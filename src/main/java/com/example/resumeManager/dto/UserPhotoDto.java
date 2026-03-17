package com.example.resumeManager.dto;

import java.time.LocalDate;

import lombok.Data;

//사진
@Data
public class UserPhotoDto {
	private int photoId;
	private String userId;
	private String fileName;
	private String filePath;
	private LocalDate uploadDate;
}
