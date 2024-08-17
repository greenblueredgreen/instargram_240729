package com.Instargram.post.domain;

import java.time.LocalDateTime;

import com.Instargram.comment.domain.Comment;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Post {

	private int id;
	private int userId;
	private String imagePath;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
