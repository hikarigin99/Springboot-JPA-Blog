package com.cos.blog.model;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.dto.ReplySaveRequestDto;
import com.cos.blog.repository.ReplyRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	 // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne			// Many : 답변, One : 게시물
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne        // Many : 답변, One: 사람 
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Override
	public String toString() {
		return "Reply [id=" + id + ", content=" + content + ", board=" + board + ", user=" + user + ", createDate="
				+ createDate + "]";
	}
}
