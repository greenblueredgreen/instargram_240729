package com.Instargram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Instargram.post.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer >{
	//가장 최신의 것 가져오기
	public List<PostEntity> findByOrderByIdDesc();
}
