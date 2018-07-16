package Test;

import java.util.Scanner;

public class Average_Calculator_Grade {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("점수를 입력하세요 : ");
		int score = input.nextInt();
		
		if(score >= 95) {
			System.out.println("당신의 학점은 A+입니다.");
		} else if(score >= 90 && score < 95) {
			System.out.println("당신의 학점은 A입니다.");
		} else if(score >= 85 && score < 90) {
			System.out.println("당신의 학점은 B+입니다.");
		} else if(score >= 80 && score < 85) {
			System.out.println("당신의 학점은 B입니다.");
		} else if(score >= 70 && score < 80) {
			System.out.println("당신의 학점은 C입니다.");
		} else if(score >= 60 && score < 70) {
			System.out.println("당신의 학점은 D입니다.");
		} else{
			System.out.println("당신의 학점은 F입니다.");
		}
	}

}
