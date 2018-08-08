package com.ktds.delivery.man.vo;

public class DeliveryMan {

	private String phone;
	private String name;
	
	public DeliveryMan() {}
	
	// Shift + Alt + S + O -> Constructor
	public DeliveryMan(String phone, String name) {
		this.phone = phone;
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
