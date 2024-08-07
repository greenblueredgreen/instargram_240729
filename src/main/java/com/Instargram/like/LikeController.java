package com.Instargram.like;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/like")
public class LikeController {

	//좋아요 목록 화면
	@GetMapping("/like-list-view")
	public String likeListView() {
		return "/like/likeList";
	}
}
