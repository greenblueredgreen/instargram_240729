package com.Instargram.like;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Instargram.like.bo.LikeBO;
import com.Instargram.post.bo.PostBO;
import com.Instargram.post.entity.PostEntity;
import com.Instargram.user.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/like")
public class LikeController {

	@Autowired
	private LikeBO likeBO;
	
	@Autowired
	private PostBO postBO;
	
	//좋아요 목록 화면
	@GetMapping("/like-list-view")
	public String likeListView(HttpSession session, Model model) {
		
		//로그인 여부 확인
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
		
		//좋아요한 글번호들이 담긴 list
		List<Integer> postIdList = likeBO.postIdByUserIdLike(userId);
		
		List<PostEntity> post  =  new ArrayList<>();
		
		for( int postListId : postIdList) {
			for (PostEntity p : postBO.getPostEntityListByPostID(postListId)) {
				post.add(p);
			}
		}
		
		model.addAttribute("post", post);
		
		return "/like/likeList";
	}
}
