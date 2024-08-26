package com.Instargram.follow.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instargram.follow.mapper.FollowMapper;

@Service
public class FollowBO {
	
	@Autowired
	private FollowMapper followMapper;
	
	//팔로잉 추가 bo
	public void addFollowing(int userId, int followingId) {
		followMapper.insertFollowing(userId, followingId);
	}
	
	//팔로잉 해제 bo
	public void deleteFollowing(int userId, int followingId) {
		followMapper.deleteFollowing(userId, followingId);
	}
}
