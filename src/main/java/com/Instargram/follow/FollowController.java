package com.Instargram.follow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/follow")
@Controller
public class FollowController {

	//팔로워 화면
	@GetMapping("/follower-view")
	public String followerView() {
		return "/follow/follower";
	}
	
	//팔로잉 화면
	@GetMapping("/following-view")
	public String followingView() {
		return "/follow/following";
	}
}
