package com.ktds;

public class MessageLogger extends Logging {

	@Override
	public String setMessage() {
		return "안녕?";
	}

	@Override
	public String finishMessage() {
		return "잘가~";
	}
	
}
