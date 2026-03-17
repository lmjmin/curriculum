package com.example.resumeManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.resumeManager.dto.UserDto;
import com.example.resumeManager.service.RmUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RmUserController {
	@Autowired
	RmUserService service;
	
	@GetMapping("/")
	public String main() {
		System.out.println("메인페이지 실행...");
		return "redirect:/loginForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("로그인 페이지 이동...");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userId")String id,
							@RequestParam("pw")String pw,
							HttpSession session) {
		UserDto user = service.login(id, pw);
		if(user!=null) {
			 session.setAttribute("userId", user.getUserId());
	         return "redirect:/introList";
		}else {
			return "redirect:/loginForm";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
	}
	
	@GetMapping("/signupForm")
	public String signupForm() {
		System.out.println("회원가입 페이지 이동...");
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(UserDto dto) {
		System.out.println(dto);
		int result = service.signup(dto);
		if (result == 1) {
		    return "redirect:/loginForm";
		} else {
		    return "redirect:/signupForm";
		}
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
}
