package com.example.resumeManager.dto;


import java.time.LocalDate;

import lombok.Data;
//회원
@Data
public class UserDto {
	private String userId;
	private String pw;
	private String name;
	private LocalDate birth;
	private String email;
	private String phone;
	private String education;
	private String skill;
	private String desiredJob;
	private String desiredArea;
}
