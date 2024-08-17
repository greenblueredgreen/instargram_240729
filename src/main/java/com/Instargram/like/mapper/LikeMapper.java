package com.Instargram.like.mapper;

import java.util.List;

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
	
	//글 삭제를 위한 좋아요 삭제
	public void deleteLikeByPostId(int postId);
	
	//userId가 좋아요한 글의 글번호들을 리스트에 담아 들고오기
	public List<Integer> selectpostIdByUserIdLike(int userId);
}
