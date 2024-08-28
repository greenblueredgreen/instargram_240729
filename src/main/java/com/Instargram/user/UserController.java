package com.Instargram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

	//회원가입 화면
	@GetMapping("/sign-up-view")
	public String signUpView() {
		return "user/signUp";
	}
	
	//로그인화면
	@GetMapping("/sign-in-view")
	public String singInView() {
		return "user/signIn";
	}
	
	//로그아웃 API /user/sign-out
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		return "redirect:/user/sign-in-view";
	}
}
