package Test;

import java.util.Scanner;

public class _Average_Calculator {

	public static void main(String[] args) {
		
		double result = 0;
		double[] score = new double[4];
		
		System.out.println("수학, 영어, 물리, 프로그래밍 점수를 차례대로 입력하세요\n");
		
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i < score.length; i++) {
			score[i] = input.nextInt();
			result += score[i];
		}
		
		result = result/score.length;
		System.out.printf("모든 과목의 평균은 %.2f입니다.", result);
		
	}
}
