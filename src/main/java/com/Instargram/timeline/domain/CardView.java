package com.Instargram.timeline.domain;

import java.util.List;

import com.Instargram.comment.domain.CommentView;
import com.Instargram.post.entity.PostEntity;
import com.Instargram.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

//view용
//글 1개와 매핑
//카드 형식으로 한 카드안에 하나의 글, 글쓴이, 댓글 좋아요 등이 담겨있다
@ToString
@Data
public class CardView {
	
	//글 1개
	private PostEntity post;
	
	//글쓴이 정보
	private UserEntity user;
	
	//댓글 n개
	private List<CommentView> commentList;
	
	//좋아요 n개
	private int likeCount;
	
	//좋아요 눌렀는지 여부
	private boolean filledLike;
}
