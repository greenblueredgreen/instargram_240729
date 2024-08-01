package com.Instargram.test.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
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
@Getter
@Builder(toBuilder = true)    // 필드 세팅, toBuilder=true: 기존 객체에 일부 필드값만 변경 가능
@NoArgsConstructor  // 파라미터 없는 생성자
@AllArgsConstructor // 모든 필드 있는 생성자
@Table(name = "post")   // 테이블명, 지정 안하면 엔티티명이 테이블명으로 됨
@Entity  // 엔티티로 등록, name 속성 생략하면 클래스명이 엔티티명이 됨
public class TestDomain {
    @Id   // pk 식별자 등록
    @GeneratedValue(strategy = GenerationType.IDENTITY) // insert 시 id 값 가져옴
    private int id;

    @Column(name="userId")
    private int userId;

    private String subject;

    private String content;

    @Column(name="imagePath")
    private String imagePath;

    @CreationTimestamp    // 현재시간 디폴트값
    @Column(name="createdAt") 
    private LocalDateTime createdAt;

    @UpdateTimestamp   // 현재시간 디폴트값
    @Column(name="updatedAt")
    private LocalDateTime updatedAt;
}