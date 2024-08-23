package com.Instargram.follow.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Follow {
	private int FollowerUserId;
	private int FollowingUserId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
