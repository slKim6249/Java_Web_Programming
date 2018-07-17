package Test;

import java.util.Scanner;

public class _Average_Calculator {

	public static void main(String[] args) {
		
		int result = 0;
		int[] score = new int[4];
		
		System.out.println("수학, 영어, 물리, 프로그래밍 점수를 차례대로 입력하세요\n");
		
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i < score.length; i++) {
			score[i] = input.nextInt();
			result += score[i];
		}
		
		result = result/score.length;
		System.out.printf("모든 과목의 평균은 %d입니다.", result);
		
	}
}
