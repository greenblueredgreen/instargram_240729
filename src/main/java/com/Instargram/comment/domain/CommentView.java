package com.Instargram.comment.domain;

import com.Instargram.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

//댓글 한 개 
@ToString
@Data
public class CommentView {
	
	//댓글 1개
	private Comment comment;

	//댓글 쓴사람
	private UserEntity user;
}
