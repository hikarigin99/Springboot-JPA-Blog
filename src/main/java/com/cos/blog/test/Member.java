package com.cos.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Getter
//@Setter
//@RequiredArgsConstructor  // final이 붙은 필드의 생성자를 만듦
//@AllArgsConstructor					// 모든 필드의 생성자를 만듦
@Data  												// getter + setter
@NoArgsConstructor					// 빈생성자
public class Member {
	private int id;
	private String username;	// 비밀번호는 수정될 수 있기 때문에 final(X)
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
