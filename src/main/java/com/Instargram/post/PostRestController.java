package com.Instargram.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Instargram.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {
	
	@Autowired
	private PostBO postBO;

	/***
	 * 글 업로드 API
	 * @param content
	 * @param file
	 * @param session
	 * @return
	 */
	//post 글올리기(글쓰기)
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam(value = "content", required = false) String content,
			@RequestParam("file") MultipartFile file,
			HttpSession session
			){
		
		Integer userId = (Integer) session.getAttribute("userId");
		String userLoginId = (String) session.getAttribute("userLoginId");
		
		Map<String, Object> result = new HashMap<>();
		
		//만약 비로그인이라면
		if(userId == null) {
			result.put("code", 403);
			result.put("error_message", "로그인을 해주세요!");
			return result;
		}
		
		//DB에 글 내용, file 넣기
		postBO.addPost(userId, userLoginId, content, file);
		
		//응답값
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	
	/**
	 * 글 삭제 api
	 * @param postId
	 * @param session
	 * @return
	 */
	//일단 중단 (좋아요, 댓글도 함께 삭제해야하기 때문에 나중에)
	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestParam("postId") int postId,
			HttpSession session){
		
		Map<String, Object> result = new HashMap<>();
		
		Integer userId = (Integer)session.getAttribute("userId");
		if(userId == null) {
			//비로그인 상태
			result.put("code", 403);
			result.put("error_message", "로그인을 다시 해주세요!");
			return result;
		}
		
		//DB 삭제
		postBO.deletePostByPostIdUserId(postId, postId);
		
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
