package com.Instargram.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Instargram.comment.bo.CommentBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/comment")
@RestController
public class CommentRestController {

	@Autowired
	private CommentBO commentBO;
	
	//댓글 추가 API  
	//글 id, 댓글쓴사람, 댓글내용
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("postId") int postId,
			@RequestParam("content") String content,
			HttpSession session
			){
		
		//로그인 여부
		Integer userId = (Integer)session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		if(userId == null) { //로그인 안됨
			result.put("code", 403);
			result.put("result", "로그인 먼저 해주세요!");
			return result;
		}
		
		//댓글 db에 삽입
		commentBO.addComment(postId, postId, content);
		
		//응답값
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}