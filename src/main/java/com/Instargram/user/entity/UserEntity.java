package com.Instargram.user.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name="user")
@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	private String name;
	
	@Column(name="loginId")
	private String loginId;
	
	private String password;
	
	@Column(name="profileImg")
	private String profileImg;
	
	@UpdateTimestamp
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
	
	private String introduce;
	
	private String gender;
}
