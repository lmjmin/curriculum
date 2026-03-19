package com.example.resumeManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.resumeManager.dto.IntroContentDto;
import com.example.resumeManager.service.SelfIntroContentService;

@Controller
public class SelfIntroContentController {
	
	@Autowired
	SelfIntroContentService service;
	
	@PostMapping("/contentAdd")
	public String contentAdd(IntroContentDto dto) {
		service.contentWrite(dto);
		
		return "redirect:/introDetail?introId=" + dto.getIntroId();
	}
	
	
	@PostMapping("/contentUpdate")
	public String contentUpdate(IntroContentDto dto) {
		service.contentEdit(dto);
		
		return "redirect:/introDetail?introId=" + dto.getIntroId();
	}
	
	@PostMapping("/contentDelete")
	public String contentDelete(@RequestParam("contentId") int contentId,
								@RequestParam("introId") int introId) {
		
		service.contentDelete(contentId);
		
		return "redirect:/introDetail?introId=" + introId;
	}
}
