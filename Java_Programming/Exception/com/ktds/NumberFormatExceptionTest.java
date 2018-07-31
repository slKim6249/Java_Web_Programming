package com.ktds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFormatExceptionTest {

	public static void main(String[] args) {
		new NumberFormatExceptionTest().run();
	}

	public void run() {
		
		String numberStr = "10.0";
		
		Pattern p = Pattern.compile("[0-9]+"); // 정규 표현식, 0~9까지의 범위중에 반복 되는지
		Matcher m = p.matcher(numberStr);
		
		int number = 0;
		if ( m.matches() ) { // m.matches()는 false 반환
			number = Integer.parseInt(numberStr);
		} else {
			System.out.println("숫자 형식이 아닙니다.");
		}
		// 문자 ==> 숫자
		
		
		System.out.println(number);
		
	}
}
