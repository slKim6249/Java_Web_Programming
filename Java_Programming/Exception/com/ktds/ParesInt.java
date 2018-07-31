package com.ktds;

public class ParesInt {

	public static void main(String[] args) {
		new ParesInt().run();
	}
	
	public void run() {
		
		String ageStr = "26.0";
		
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		} catch (NumberFormatException e) {
			System.out.println( e.getMessage() );
		}
		System.out.println(age);
	}

}
