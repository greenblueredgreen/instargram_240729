package com.Instargram.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Instargram.follow.bo.FollowBO;
import com.Instargram.post.bo.PostBO;
import com.Instargram.post.entity.PostEntity;
import com.Instargram.user.bo.UserBO;
import com.Instargram.user.domain.User;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/profile")
@Controller
public class ProfileController {
	
	@Autowired
	private PostBO postBO;

	@Autowired
	private UserBO userBO;
	
	@Autowired
	private FollowBO followBO;

	// 프로필 화면
	@GetMapping("/profile-view")
	public String profileView(Model model, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");
		int postCount = postBO.getPostCountByUserId(userId);

		// 게시물 개수 가져오기
		model.addAttribute("postCount", postCount);

		// 내가 올린 게시물 들고오기
		List<PostEntity> postList = postBO.getPostEntityListByUserId(userId);
		model.addAttribute("postList", postList);

		// USER객체 들고오기 -> 프로필편집에서 설정된 정보를 프로필 화면에 뿌리기 위해
		List<User> userList = userBO.getUserList(userId);
		model.addAttribute("userList", userList);

		//팔로워 개수 프로필 화면에 뿌리기
		int followerCount = followBO.getFollowerCountByFollowingUserId(userId);
		model.addAttribute("followerCount", followerCount);
		
		//팔로잉 개수 프로필 화면에 뿌리기
		int followingCount = followBO.getFollowingCountByUserId(userId);
		model.addAttribute("followingCount", followingCount);
		
		return "/profile/profile";
	}

	// 프로필 편집 화면
	@GetMapping("/profile-edit-view")
	public String profileEdit() {
		return "/profile/profileEdit";
	}

	// 다른 사람 프로필 화면
	@GetMapping("/profile-another-view")
	public String profileAnother(Model model, 
			@RequestParam("userId") int userId) {
	
		//timeline 의 userId를 받아와야하는데 어떻게 받아오지?
		List<User> userList = userBO.getUserList(userId);
	
		model.addAttribute("userList", userList);
		
		//400에러가 발생한 이유 - 파라미터 에러
		//필수파라미터로 설정한 userId가 경로에 붙지 않고 와서 에러가 발생한거다
		//무조건 쿼리스트링 형식으로 userId가 붙어와야 경로로 접근이 가능하다
		// /profile-another-view?userId = 
		// 나는 /profile-another-view로 치고들어가면 404가 뜨는지 이해가 안됐는데
		// 필수파라미터 때문에 그런거다.
		
		//userId에 해당하는(다른 사람)이 쓴 게시물 들고오기
		List<PostEntity> postList = postBO.getPostEntityListByUserId(userId);
		model.addAttribute("postList", postList);
		
		//userId에 해당하는(다른사람)이 쓴 게시물 개수 들고오기
		int postCount = postBO.getPostCountByUserId(userId);
		model.addAttribute("postCount", postCount);
		
		//팔로워 개수 프로필 화면에 뿌리기
		int followerCount = followBO.getFollowerCountByFollowingUserId(userId);
		model.addAttribute("followerCount", followerCount);
				
		//팔로잉 개수 프로필 화면에 뿌리기
		int followingCount = followBO.getFollowingCountByUserId(userId);
		model.addAttribute("followingCount", followingCount);
		
		return "/profile/profileAnother";
	}
}
