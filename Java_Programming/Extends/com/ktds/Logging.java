package com.ktds;

/**
 * Interface(Implements) + Extends
 * @author sangmoo
 *
 */
public abstract class Logging {
	
	// 추상 메소드
	public abstract String setMessage();
	
	public abstract String finishMessage();
	
	public void printLogging() {
		
		String startMessage = setMessage();
		
		System.out.println("로깅을 시작합니다.");
		System.out.println(startMessage);
		
		String finishMessage = finishMessage();
		System.out.println(finishMessage);
	}
	
}
