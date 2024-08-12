package com.Instargram.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.Instargram.comment.domain.Comment;

@Mapper
public interface CommentMapper {
	
	public int insertComment(
			//MAP타입이라 XML에 들어갈 때 순서 영향이 없다
			@Param("postId") int postId, 
			@Param("userId") int userId, 
			@Param("content") String content);

	//전체게시물 모든 댓글들
	public List<Comment> selectCommentList();

	//특정 글번호 게시물의 댓글들
	public List<Comment> selectCommentListByPostId(int postId);
}
