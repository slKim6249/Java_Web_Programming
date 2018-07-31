package com.ktds;

import java.util.ArrayList;
import java.util.List;

public class NullPointerExceptionTest {

	private String message; // Default value = null
	
	public static void main(String[] args) {
		
		/*
		 * NullPointerException == Reference Type에서만 발생
		 * Primitive Type에서는 발생하지 않는다.
		 */
		
		/*
		 * Reference Type의 값이 Null을 가질 때 발생 가능성 높음.
		 */
		new NullPointerExceptionTest().run();
		new NullPointerExceptionTest().runList();
		
	}
	
	public void run() {
		String name = get(); // null
		
		try {
			System.out.println(name.length()); // 예외가 발생한 지점주터 에러 발생 - 프로그램종료
			System.out.println(message.length());
		} catch (NullPointerException e) {
			System.out.println("예외 발생 : " + e);
		}
	}
	
	public void runList() {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Sm");
		nameList.add("Sangmoo");
		nameList.add(get()); // null
		
		for( String name : nameList ) { // NullPointerException
			if( name != null ) {
				System.out.println(name.indexOf("S"));
			}
		}
	}
	
	public String get() {
		return null;
	}
	
}
