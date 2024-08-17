package com.Instargram.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Instargram.post.entity.PostEntity;

@Mapper
public interface PostMapper {

	public int getPostCountByUserId(int userId);
	
	public List<PostEntity> selectPostEntityListByPostID(int id);
}
