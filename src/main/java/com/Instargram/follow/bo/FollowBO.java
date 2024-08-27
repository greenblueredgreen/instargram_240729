package com.Instargram.follow.bo;

import java.util.List;

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
	
	//팔로워 리스트 가져오기
	public List<Integer> getFollowerListByUserId(int userId){
		return followMapper.getFollowerListByUserId(userId);
	}
	
	//팔로잉 리스트 가져오기
	public List<Integer> getFollowingListByUserId(int userId){
		return followMapper.getFollowingListByUserId(userId);
	}
	
	//팔로잉 체크 BO -> 팔로잉 버튼을 위한 BO
	public boolean checkFollowing(int userId, int followingId) {
		int result = followMapper.checkFollowing(userId, followingId);
		if (result > 0) {
			//팔로잉 되어있음
			return true;
		} else {
			//팔로잉 안되어있음
			return false;
		}
	}
	
}
