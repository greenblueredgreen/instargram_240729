package com.Instargram.profile;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Instargram.user.bo.UserBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/profile")
@RestController
public class ProfileEditRestController {

	@Autowired
	private UserBO userBO;

	@PostMapping("/edit")
	public Map<String, Object> edit(@RequestParam(value = "profileImg", required = false) MultipartFile profileImg,
			@RequestParam(value = "introduce", required = false) String introduce,
			@RequestParam(value = "gender", required = false) String gender, HttpSession session) {

		// session
		// 로그인 여부
		String userLoginId = (String) session.getAttribute("userLoginId");
		Integer userId = (Integer) session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		if (userId == null) { // 로그인 안됨
			result.put("code", 403);
			result.put("result", "로그인 먼저 해주세요!");
			return result;
		}

		// db insert
		userBO.addProfileImgIntroduceGender(userLoginId, profileImg, introduce, gender);

		// 응답값
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
