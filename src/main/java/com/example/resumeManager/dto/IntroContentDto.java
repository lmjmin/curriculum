package com.example.resumeManager.dto;

import lombok.Data;

//자기소개서 내용
@Data
public class IntroContentDto {
	private int contentId;
	private int introId;
	private String itemName;
	private String contentText;
}
