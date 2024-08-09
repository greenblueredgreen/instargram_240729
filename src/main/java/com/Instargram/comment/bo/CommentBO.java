package com.Instargram.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instargram.comment.mapper.CommentMapper;

@Service
public class CommentBO {
	
	@Autowired
	private CommentMapper commentMapper;
	
	//댓글 추가하기 BO
	public void addComment(int postId, int userId, String content) {
		commentMapper.insertComment(postId, userId, content);
	}
}
