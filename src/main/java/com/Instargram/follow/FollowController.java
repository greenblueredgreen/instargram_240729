package com.Instargram.follow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Instargram.follow.bo.FollowBO;
import com.Instargram.user.bo.UserBO;
import com.Instargram.user.domain.User;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/follow")
@Controller
public class FollowController {

	@Autowired
	private FollowBO followBO;

	@Autowired
	private UserBO userBO;

	// 팔로워 화면
	@GetMapping("/follower-view")
	public String followerView(HttpSession session, Model model) {

		Integer userId = (Integer) session.getAttribute("userId");

		// 팔로워 객체 들고오기
		// 1. 일단 팔로워 id들을 들고온다
		// 2. 그 아이디들로 user 테이블에 접근하기
		List<Integer> followerIdList = followBO.getFollowerListByUserId(userId);
		List<User> user = new ArrayList<>();

		for (int id : followerIdList) {
			for (User u : userBO.getUserList(id)) {
				user.add(u);
			}
		}
		model.addAttribute("user", user);
		return "/follow/follower";
	}

	// 팔로잉 화면
	@GetMapping("/following-view")
	public String followingView(HttpSession session, Model model) {
		Integer userId = (Integer) session.getAttribute("userId");

		// 팔로잉 객체 들고오기
		// 1. 일단 팔로잉 id들을 들고온다
		// 2. 그 아이디들로 user 테이블에 접근하기
		List<Integer> followerIdList = followBO.getFollowingListByUserId(userId);
		List<User> user = new ArrayList<>();

		for (int id : followerIdList) {
			
			//리스트로 들고오기 때문에 1번, 3번, 5번... 
			for (User u : userBO.getUserList(id)) {
				// 다시 그 리스트에서 하나씩 꺼내서 담아야한다.그래서 이중 반복문
				user.add(u);
			}
		}
		model.addAttribute("user", user);

		return "/follow/following";
	}
}
