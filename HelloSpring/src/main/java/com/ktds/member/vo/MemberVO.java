package com.ktds.member.vo;

import com.ktds.common.dao.support.Types;

public class MemberVO {

	@Types
	private String email;
	@Types
	private String name;
	@Types
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
