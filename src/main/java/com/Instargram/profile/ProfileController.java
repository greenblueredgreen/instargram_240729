package com.Instargram.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Instargram.post.bo.PostBO;
import com.Instargram.post.entity.PostEntity;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/profile")
@Controller
public class ProfileController {

	@Autowired
	private PostBO postBO;
	
	//프로필 화면
	@GetMapping("/profile-view")
	public String profileView(Model model, HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		int postCount = postBO.getPostCountByUserId(userId);
		
		// 게시물 개수 가져오기
		model.addAttribute("postCount", postCount);
		
		// 내가 올린 게시물 들고오기
		List<PostEntity> postList = postBO.getPostEntityList();
		model.addAttribute("postList", postList);
		
		return "/profile/profile";
	}
	
	//프로필 편집 화면
	@GetMapping("/profile-edit-view")
	public String profileEdit() {
		return "/profile/profileEdit";
	}
}
