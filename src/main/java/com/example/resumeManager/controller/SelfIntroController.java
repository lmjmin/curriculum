package com.example.resumeManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.resumeManager.dto.IntroContentDto;
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
    public String introWrite(SelfIntroDto dto,
                             @RequestParam("itemName") String itemName,
                             @RequestParam("contentText") String contentText,
                             HttpSession session) {

        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/loginForm";
        }

        dto.setUserId(userId);

        selfIntroService.introWrite(dto);

        IntroContentDto contentDto = new IntroContentDto();
        contentDto.setIntroId(dto.getIntroId());
        contentDto.setItemName(itemName);
        contentDto.setContentText(contentText);

        selfIntroContentService.contentWrite(contentDto);

        return "redirect:/introDetail?introId=" + dto.getIntroId();
    }
    
    @GetMapping("/introDetail")
    public String introDetail(@RequestParam("introId") int introId, Model model) {

        SelfIntroDto introDto = selfIntroService.introDetail(introId);
        List<IntroContentDto> contentList = selfIntroContentService.contentList(introId);

        model.addAttribute("introDto", introDto);
        model.addAttribute("contentList", contentList);

        return "introDetail";
    }
    
    @GetMapping("/introEditForm")
    public String introEditForm(@RequestParam("introId") int introId, Model model) {

        SelfIntroDto dto = selfIntroService.introDetail(introId);

        model.addAttribute("introDto", dto);

        return "introEditForm";
    }
    
    @PostMapping("/introEdit")
    public String introEdit(SelfIntroDto dto) {

        selfIntroService.introEdit(dto);

        return "redirect:/introDetail?introId=" + dto.getIntroId();
    }
}
