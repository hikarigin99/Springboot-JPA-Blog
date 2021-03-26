package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java(다른 언어) Object -> 테이블로 매핑해주는 기술
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder	// 빌터 패턴!
@Entity	// 클래스를 테이블화시키는 어노테이션, User 클래스가 자동으로 MySQL에 테이블이 생성됨
// @DynamicInsert  // insert 시에 null인 필드를 제회시켜준다.
public class User {
	
	@Id		//Primary key
	@GeneratedValue(strategy  = GenerationType.IDENTITY)	// 넘버링 전략, 해당 프로젝트에서 연결된 DB의 넘버링 전략(IDENTITY)을 따라간다.
	private int id;	// 오라클 : 시퀀스, MySQL : auto_increment로 넘버링
	
	@Column(nullable = false, length=30)
	private String username;	//아이디
	
	@Column(nullable = false, length=100)	// 123456 => 해쉬 (비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	// @ColumnDefault("user")
	// DB는 RoleType이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role;	// 어떤 데이터의 도메인(범위)을 만들 수 있는 Enum 을 쓰는게 좋다. 
											// ADMIN, USER 강제 권한을 주는 role (에러 위험 managerrrrr)
	
	@CreationTimestamp	// 시간이 자동입력
	private Timestamp createDate;	// 회원가입한 시간
	
}
