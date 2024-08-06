package com.Instargram.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/profile")
@Controller
public class ProfileController {

	//프로필 화면
	@GetMapping("/profile-view")
	public String profileView() {
		return "/profile/profile";
	}
}
