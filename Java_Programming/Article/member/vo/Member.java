package member.vo;

public class Member {

	private String memberID;
	private String name;
	private String password;
	private String registeredDate;

	public Member() {}
	
	public Member(String memberID, String name, String password, String registeredDate) {
		this.memberID = memberID;
		this.name = name;
		this.password = password;
		this.registeredDate = registeredDate;
	}

	public Member(String memberID, String name, String password) {
		this.memberID = memberID;
		this.name = name;
		this.password = password;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
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

	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

}
