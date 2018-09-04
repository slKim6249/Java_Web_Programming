package com.ktds.member.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.ktds.common.dao.support.Types;
import com.ktds.member.validator.MembersValidator;

public class MembersVO {

	@Types(alias = "M_EMAIL")
	@NotEmpty(message="?��메일?? ?��?�� ?��?�� 값입?��?��."
			, groups={MembersValidator.Regist.class, MembersValidator.Login.class})
	
	@Email(message="?��메일 ?��?��?���? ?��?��?��주세?��."
			, groups={MembersValidator.Regist.class, MembersValidator.Login.class})
	private String email;
	
	@Types
	@NotEmpty(message="?��름�? ?��?�� ?��?�� 값입?��?��."
			, groups={MembersValidator.Regist.class})
	private String name;
	
	@Types
	@NotEmpty(message="비�?번호?�� ?��?�� ?��?�� 값입?��?��."
			, groups={MembersValidator.Regist.class, MembersValidator.Login.class})
	@Length(min=10, max=20, message="비�?번호?�� 10~20�??�� ?��?���? ?��?��?��주세?��."
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
