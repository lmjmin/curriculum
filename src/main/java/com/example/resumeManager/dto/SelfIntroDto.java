package com.example.resumeManager.dto;

import java.time.LocalDate;

import lombok.Data;

//자기소개서
@Data
public class SelfIntroDto {
	private int introId;
	private String userId;
	private String title;
	private String company;
	private String job;
	private LocalDate createdAt;
}
