package com.ktds.member.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.ktds.common.dao.support.Types;
import com.ktds.member.validator.MembersValidator;

public class MembersVO {

	@Types(alias = "M_EMAIL")
	@NotEmpty(message="?΄λ©μΌ?? ?? ?? ₯ κ°μ??€."
			, groups={MembersValidator.Regist.class, MembersValidator.Login.class})
	
	@Email(message="?΄λ©μΌ ???Όλ‘? ??±?΄μ£ΌμΈ?."
			, groups={MembersValidator.Regist.class, MembersValidator.Login.class})
	private String email;
	
	@Types
	@NotEmpty(message="?΄λ¦μ? ?? ?? ₯ κ°μ??€."
			, groups={MembersValidator.Regist.class})
	private String name;
	
	@Types
	@NotEmpty(message="λΉλ?λ²νΈ? ?? ?? ₯ κ°μ??€."
			, groups={MembersValidator.Regist.class, MembersValidator.Login.class})
	@Length(min=10, max=20, message="λΉλ?λ²νΈ? 10~20κΈ?? ?¬?΄λ‘? ?? ₯?΄μ£ΌμΈ?."
			, groups={MembersValidator.Regist.class})
	private String password;
	
	@Types
	private int point;

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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		String format = "MemberVO[Email : %s, Name : %s, Password : %s, Point : %d]";
		return String.format(format
				, this.email
				, this.name
				, this.password
				, this.point);
	}

}
