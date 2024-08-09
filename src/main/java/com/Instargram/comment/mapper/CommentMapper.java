package com.Instargram.comment.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
	
	public int insertComment(
			//MAP타입이라 XML에 들어갈 때 순서 영향이 없다
			@Param("postId") int postId, 
			@Param("userId") int userId, 
			@Param("content") String content);
	
}
