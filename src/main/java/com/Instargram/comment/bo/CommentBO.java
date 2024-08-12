package com.Instargram.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instargram.comment.domain.Comment;
import com.Instargram.comment.domain.CommentView;
import com.Instargram.comment.mapper.CommentMapper;
import com.Instargram.user.bo.UserBO;
import com.Instargram.user.entity.UserEntity;

@Service
public class CommentBO {

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private UserBO userBO;

	// 댓글 추가하기 BO
	public void addComment(int postId, int userId, String content) {
		commentMapper.insertComment(postId, userId, content);
	}

	// input:글번호 output:List<CommentView>
	public List<CommentView> generateCommentViewListByPostId(int postId) {
		List<CommentView> commentViewList = new ArrayList<>();

		// 댓글들 가져옴
		List<Comment> commentList = commentMapper.selectCommentListByPostId(postId);

		// 반복문 순회 => Comment -> CommentView => list에 담음
		for (Comment comment : commentList) {
			CommentView commentView = new CommentView();

			// 댓글 1개
			commentView.setComment(comment);

			// 댓글쓰니
			// comment.getUserId(); 로 가져와야했다. (에러원인)
			UserEntity user = userBO.getUserEntityById(comment.getUserId());
			commentView.setUser(user);

			// !!!!!! list에 넣기
			commentViewList.add(commentView);
			
		}

		return commentViewList;
		
	}

//	// 댓글 뿌리기 BO
//	// input : 글번호
//	// output : List<CommentView> //특정 게시물의 댓글들
//	public List<CommentView> generateCommentViewListByPostId(int postId) {
//
//		// 화면에 뿌릴 리스트 선언
//		List<CommentView> commentViewList = new ArrayList<>();
//
//		// 특정 게시물의 댓글들 가져오기
//		List<Comment> commentList = commentMapper.selectCommentListByPostId(postId);
//
//		// 반복문 순회(특정 게시물 댓글들을 순회)
//		for (Comment comment : commentList) {
//			// comment : 1번댓글이에용
//
//			// CommentView 객체 선언 (1번댓글쓰니, 1번댓글이에용)
//			CommentView commentView = new CommentView();
//
//			// 댓글 1개 - 1번댓글이에용
//			commentView.setComment(comment); // 리스트에 특정 게시물의 댓글을 하나씩 넣기 // 1번이에용
//
//			// 댓글쓰니 (댓글 쓴 사람의 정보들) - 1번댓글쓰니
//			// userBO를 통해서 userRepository로 접근
//			UserEntity user = userBO.getUserEntityById(postId);
//			commentView.setUser(user);
//
//			// commentView를 commentViewlist(화면에 뿌릴 리스트)에 담기
//			// (1번댓글쓰니, 1번댓글이에용) -> 리스트에 담기
//			commentViewList.add(commentView);
//		}
//
//		// 정보들이 담긴 화면에 뿌릴 리스트를 최종 반환
//		// 반복문 안에서 반환해서 에러발생. 반복문 밖에서 return
//		return commentViewList;
//		// 정보들(댓글쓰니이름, 댓글내용)을 이제 타임라인에 뿌릴 준비 완료!
//	}
}
