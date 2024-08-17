package com.Instargram.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Instargram.like.bo.LikeBO;
import com.Instargram.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@RestController
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
	//좋아요 요청 
	@RequestMapping("/like/{postId}")
	public Map<String, Object> liekToggle(
			@PathVariable(name="postId") int postId,
			HttpSession session
			){
		
		//로그인 여부 확인
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId == null) {
			result.put("code", 403);
			return result;
		}
		
		//LIKE BO 요청 // 좋아요 여부 체크 (있으면 삭제, 없으면 추가)
		likeBO.likeToggle(postId, userId);
		
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
