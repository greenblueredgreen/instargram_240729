package com.Instargram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
