package com.Instargram.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instargram.like.mapper.LikeMapper;

@Service
public class LikeBO {

	@Autowired
	private LikeMapper likeMapper;
	
	//좋아요 여부 체크 후 좋아요 삭제, 추가 BO
	public void likeToggle(int postId, int userId) {
		//좋아요 개수 들고오기
		int count = likeMapper.selectLikeCountByPostIdOrUserId(postId, userId);
		
		if(count > 0) {
			//좋아요 삭제
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else {
			//좋아요 추가
			likeMapper.insertLike(postId, userId);
		}
	}
	
	//user와 post의 좋아요 개수 들고오기
	public int getLikeCountByPostIdUserId(int postId, int userId) {
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, userId);
	}
	
	//게시글의 좋아요 개수 들고오기
	public int getLikeCountByPostId(int postId) {
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, null);
	}
}
