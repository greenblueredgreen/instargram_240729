package com.Instargram.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Instargram.common.FileManagerService;
import com.Instargram.user.domain.User;
import com.Instargram.user.entity.UserEntity;
import com.Instargram.user.mapper.UserMapper;
import com.Instargram.user.repository.UserRepository;

@Service
public class UserBO {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileManagerService fileManagerService;

	@Autowired
	private UserMapper userMapper;

	// ID 중복확인 BO
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}

	// 회원가입 BO
	public UserEntity addUser(String phoneNumber, String email, String name, String loginId, String password) {
		return userRepository.save(UserEntity.builder().phoneNumber(phoneNumber).email(email).name(name)
				.loginId(loginId).password(password).build());
	}

	// 로그인 : 아이디, 비번 BO
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
	}

	// 댓글 쓴 사람의 정보를 가져오는 BO
	public UserEntity getUserEntityById(int userId) {
		return userRepository.findById(userId).orElse(null); 
	}

	// 회원정보 수정 BO (jpa)
//	public UserEntity updateUser(
//				String profileImg, String introduce, 
//				String gender) {
//			
//			UserEntity a = userRepository.findById(userId).orElse(null);
//			
//			a.toBuilder(profileImg, introduce, gender);
//			
//			return userRepository.save(UserEntity.builder()  //new
//					.profileImg(profileImg)
//					.introduce(introduce)
//					.gender(gender)
//					.build());
//		}

	// 프로필 편집
	// 프로필이미지, 소개, 성별 DB에 넣는 BO
	public void addProfileImgIntroduceGender(
			String userLoginId, MultipartFile profileImg, String introduce, String gender) {
		
		String imagePath = fileManagerService.uploadFile(profileImg, userLoginId);
		
		userMapper.addProfileImgIntroduceGender(userLoginId, imagePath, introduce, gender);
	}

	//userId에 해당하는 USER객체 들고오는 bo -> 성별, 자기소개, 프로필 이미지 꺼내기 위한 bo
	public List<User> getUserList(int userId){
		return userMapper.selectUserList(userId);
	}
}
