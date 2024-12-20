package com.Instargram.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instargram.comment.bo.CommentBO;
import com.Instargram.comment.domain.CommentView;
import com.Instargram.like.bo.LikeBO;
import com.Instargram.post.bo.PostBO;
import com.Instargram.post.entity.PostEntity;
import com.Instargram.timeline.domain.CardView;
import com.Instargram.user.bo.UserBO;
import com.Instargram.user.entity.UserEntity;

@Service
public class TimelineBO {
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;

	//cardView 리스트 반환 BO
	public List<CardView> generateCardViewList(Integer userId){
		//비로그인도 타임라인 볼 수 있으므로 null 가능
		
		//cardViewList 선언
		List<CardView> cardViewList = new ArrayList<>();
		
		//글 목록 가져오기
		List<PostEntity> postList = postBO.getPostEntityList();
		
		//글 목록 반복문 순회
		//PostEntity => CardView -> cardViewList에 넣기
		for(PostEntity post : postList) {
			CardView card = new CardView();
			
			//글 1개
			card.setPost(post);
			
			//글쓴이 정보
			//반복문 순회 post변수에서 getter사용
			UserEntity user = userBO.getUserEntityById(post.getUserId());
			card.setUser(user);
			
			//댓글 n개
			List<CommentView> commentViewList = commentBO.generateCommentViewListByPostId(post.getId());
			card.setCommentList(commentViewList);
			
			//좋아요 개수
			int likeCount = likeBO.getLikeCountByPostId(post.getId());
			card.setLikeCount(likeCount);
			
			//좋아요 여부 채우기
			//true, false를 likeBO에서 받아온다.
			card.setFilledLike(likeBO.filledLikeByPostIdUserId(post.getId(), userId));
			
			//반드시 큰 리스트에 넣기
			cardViewList.add(card);
		}
		return cardViewList;
	}
}
