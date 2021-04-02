package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob		// 대용량 데이터
	private String content;		//섬머노트 라이브러리 <html>태그가 섞여서 디자인 됨 => 용량이 커짐
	
	private int count; 			// 조회수
	
	@ManyToOne(fetch = FetchType.EAGER)	//Many : Board, One : User , 연관 관계 맺어줌
	@JoinColumn(name="user_id")
	private User user;		//DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.  => 충돌
												// 자바 프로그램에서 데이터베이스의 자료형에 맞춰서 테이블을 만듬, But, ORM 사용시 오브젝트 사용 가능
	
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)  // mayppedBy 연관관계의 주인X(FKey X), DB에 컬럼 생성X
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
