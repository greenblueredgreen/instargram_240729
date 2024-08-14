package com.Instargram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Instargram.aop.TimeTrace;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@TimeTrace
	//게시물 만들기 화면
	@GetMapping("/post-create-view")
	public String postCreateView() {
		return "/post/postCreate";
	}
}
