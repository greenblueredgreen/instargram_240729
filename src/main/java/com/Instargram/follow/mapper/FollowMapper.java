package com.Instargram.follow.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowMapper {

	//팔로잉 추가 mapper
	public void insertFollowing(
			@Param("FollowerUserId")int userId, 
			@Param("FollowingUserId") int followingId);
	
	//팔로잉 제거 mapper
	public void deleteFollowing(
			@Param("FollowerUserId")int userId, 
			@Param("FollowingUserId") int followingId);
	
	//팔로워 개수 가져오기
	public int getFollowerCountByFollowingUserId(int followingId);
	
	//팔로잉 개수 가져오기
	public int getFollowingCountByUserId(int FollowerUserId);
}
