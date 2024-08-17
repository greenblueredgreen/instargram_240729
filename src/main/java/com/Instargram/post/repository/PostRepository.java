package com.Instargram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Instargram.post.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer >{
	
	//글 가져오는 repository
	public List<PostEntity> findByOrderByIdDesc();

}
