package com.Instargram.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Instargram.comment.bo.CommentBO;
import com.Instargram.common.FileManagerService;
import com.Instargram.like.bo.LikeBO;
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
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	//글 가져오는 BO -> 글을 가져와서 타임라인에 Model에 담아서 뿌리기
	public List<PostEntity> getPostEntityList(){
		return postRepository.findByOrderByIdDesc();
	}
	

	//글 추가 BO
	public PostEntity addPost(
			int userId, String userLoginId, 
			String content, MultipartFile file) {
		
		String imagePath = fileManagerService.uploadFile(file, userLoginId);
		
		PostEntity  a = PostEntity.builder()  //객체 받아오기
		.userId(userId)
		.content(content)
		.imagePath(imagePath)
		.build();
		// save -> extends JpaRepository<PostEntity, Integer >
		// input : PostEntity/ new 대신에 builder()로 setter처럼 받아온다
		return postRepository.save(a);
	}
	
	//글 삭제 BO
	public void deletePostByPostIdUserId(int postId, int userId) {
		//기존 글 가져오기
		PostEntity post = postRepository.findById(postId).orElse(null);
		if(post== null) {
			log.error("[delete post] postId:{}, userId:{}", postId, userId);
			return;
		}
		
		//글 삭제
		postRepository.delete(post);
		
		// 이미지 있으면 삭제
		fileManagerService.deleteFile(post.getImagePath());
		
		//댓글들 삭제
		commentBO.deleteCommentsByPostId(postId);
		
		//좋아요들 삭제
		likeBO.deletLikeByPostId(postId);
	}
}
