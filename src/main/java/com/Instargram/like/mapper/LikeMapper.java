package com.Instargram.like.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {

	//좋아요 개수 들고오기 mapper
	public int selectLikeCountByPostIdOrUserId(
			@Param("postId") int postId,
			@Param("userId") Integer userId);
	
	//좋아요 추가 mapper
	public void insertLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	//좋아요 삭제 mapper
	public void deleteLikeByPostIdUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
}
