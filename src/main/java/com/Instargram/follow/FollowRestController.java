package com.Instargram.follow;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Instargram.follow.bo.FollowBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/follow")
@RestController
public class FollowRestController {
	
	@Autowired
	private FollowBO followBO;
	
	//팔로잉 추가
	@PostMapping("/add")
	public Map<String, Object> addFollowing(HttpSession session,
			@RequestParam("followingId") int followingId){
		
		Integer userId = (Integer) session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		if (userId == null) { // 로그인 안됨
			result.put("code", 403);
			result.put("result", "로그인 먼저 해주세요!");
			return result;
		}

		//팔로잉할 사람 db에 담기(로그인한 사람, 팔로잉 할 사람)
		followBO.addFollowing(userId, )

		// 응답값
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
