package com.Instargram.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.Instargram.user.domain.User;

@Mapper
public interface UserMapper {

	public void addProfileImgIntroduceGender(
			@Param("loginId") String userLoginId, 
			@Param("profileImg") String profileImg, 
			@Param("introduce") String introduce, 
			@Param("gender" )String gender);
}
