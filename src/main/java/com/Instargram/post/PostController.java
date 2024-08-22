package com.Instargram.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Instargram.aop.TimeTrace;
import com.Instargram.user.bo.UserBO;
import com.Instargram.user.domain.User;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {

	@Autowired
	private UserBO userBO;
	
	@TimeTrace
	// 게시물 만들기 화면
	@GetMapping("/post-create-view")
	public String postCreateView(Model model, HttpSession session) {

		// 로그인 여부 확인
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
		
		// USER객체 들고오기
		List<User> userList = userBO.getUserList(userId);
		model.addAttribute("userList", userList);

		return "/post/postCreate";
	}
}
