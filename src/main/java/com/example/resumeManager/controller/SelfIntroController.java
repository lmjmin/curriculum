package com.example.resumeManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.resumeManager.dto.SelfIntroDto;
import com.example.resumeManager.service.SelfIntroContentService;
import com.example.resumeManager.service.SelfIntroService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SelfIntroController {
	@Autowired
    private SelfIntroService selfIntroService;

    @Autowired
    private SelfIntroContentService selfIntroContentService;
    
    @GetMapping("/introList")
    public String introList(HttpSession session, Model model) {
    	String userId = (String)session.getAttribute("userId");
    	List<SelfIntroDto> introList = selfIntroService.introList(userId);
    	model.addAttribute("introList",introList);
    	return "introList";
    }
    
    @GetMapping("/introWriteForm")
    public String introWriteForm() {
    	return "introWrite";
    }
    
    @PostMapping("/introWrite")
    public String introWrite(SelfIntroDto dto, HttpSession session) {
    	String userId=(String)session.getAttribute("id");
    	dto.setUserId(userId);

        selfIntroService.introWrite(dto);
    	return "redirect:/introList";
    }
}
