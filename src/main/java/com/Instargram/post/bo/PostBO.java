package com.Instargram.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Instargram.common.FileManagerService;
import com.Instargram.post.entity.PostEntity;
import com.Instargram.post.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostBO {
	
	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private PostRepository postRepository;

	//글 추가 BO
	public PostEntity addPost(
			int userId, String userLoginId, 
			String content, MultipartFile file) {
		
		String imagePath = fileManagerService.uploadFile(file, userLoginId);
		
		return postRepository.save(
				PostEntity.builder()
				.userId(userId)
				.content(content)
				.imagePath(imagePath)
				.build());
	}
	
}
