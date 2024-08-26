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
	
	//팔로워 개수 가져오기
	public int getFollowerCountByFollowingUserId(int followingId) {
		return followMapper.getFollowerCountByFollowingUserId(followingId);
	}
	
	//팔로잉 개수 가져오기
	public int getFollowingCountByUserId(int userId) {
		return followMapper.getFollowingCountByUserId(userId);
	}
}
