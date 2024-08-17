package com.Instargram.like.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instargram.like.mapper.LikeMapper;
import com.Instargram.post.entity.PostEntity;
import com.Instargram.post.mapper.PostMapper;

@Service
public class LikeBO {

	@Autowired
	private LikeMapper likeMapper;
	
	@Autowired
	private PostMapper postMapper;
	
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
	
	//TimelineBO 에서 호출
	//게시글의 좋아요 개수 들고오기 -> timeline.html의 좋아요 개수 가져오는 bo
	public int getLikeCountByPostId(int postId) {
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, null);
	}
	
	//TimelineBO 에서 호출
	// 좋아요 채울지 여부 => 만약 false면 빈하트 보여줌(timeline.html 타임리프)
	public boolean filledLikeByPostIdUserId(int postId, Integer userId) {
		if(userId ==  null) {
			return false;
		}
		
		//행이 있으면 true, 없으면 false (있으면 채워진 하트 보여준다)
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, userId) == 1 ? true : false;
	}
	
	//글 삭제를 위한 좋아요 삭제 BO
	public void deletLikeByPostId(int postId) {
		likeMapper.deleteLikeByPostId(postId);
	}
	
	//userId가 좋아요 한 글번호들을 리스트에 담아 들고오는 BO
	public List<Integer> postIdByUserIdLike(int userId){
		return likeMapper.selectpostIdByUserIdLike(userId);
	}

}
