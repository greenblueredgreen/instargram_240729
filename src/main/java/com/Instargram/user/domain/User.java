package com.Instargram.user.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {

	private int id;

	private String phoneNumber;

	private String email;

	private String name;

	private String loginId;

	private String password;

	private String profileImg;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private String introduce;

	private String gender;
}
