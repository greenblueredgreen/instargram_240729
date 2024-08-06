package com.Instargram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Instargram.common.EncryptUtils;
import com.Instargram.user.bo.UserBO;
import com.Instargram.user.entity.UserEntity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	//아이디 중복 확인
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId){
		
		//db 조회
		UserEntity user = userBO.getUserEntityByLoginId(loginId);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		if(user != null) {
			//중복
			result.put("is_duplicated_id", true);
		} else {
			//중복아님(사용가능)
			result.put("is_duplicated_id", false);
		}
		return result;
	}
	
	
	//회원가입
	@PostMapping("/sign-up")
		public Map<String, Object> signUp(
				@RequestParam("phoneNumber") String phoneNumber,
				@RequestParam("email") String email ,
				@RequestParam("name") String name,
				@RequestParam("loginId") String loginId,
				@RequestParam("password") String password){
			
		String hashedPassword = EncryptUtils.md5(password); 
		
		//해시값 저장
		UserEntity user = userBO.addUser(phoneNumber, email, name, loginId, hashedPassword);
		
		Map<String, Object> result = new HashMap<>();
		if(user != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("result", "회원가입 실패");
		}
		return result;
	}
	
	//로그인
	@PostMapping("/sign-in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request
			){
		
		//password 해싱
		String hashedPassword = EncryptUtils.md5(password);  
		
		//DB 조회
		UserEntity user = userBO.getUserEntityByLoginIdPassword(loginId, hashedPassword);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		if(user != null) {
			// user 있음
			HttpSession session = request.getSession();
			// user은 DB조회에서 한 행을 들고옴. 그 행으로 접근해서 session에 저장하기
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 200);
			result.put("error_message", "회원가입을 먼저 해주세요. 가입되지 않은 사용자입니다.");
		}
		return result;
	}
	
	//로그아웃
}
