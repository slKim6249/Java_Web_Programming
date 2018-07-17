package Test;

import java.util.Scanner;

public class Average_Calculator_Grade_Infinite_Loop {

	public static void main(String[] args) {
		
		boolean b = true;
		boolean bb = true;
		int n = 0;
		String s = null;
		
		Scanner input = new Scanner(System.in);
		Scanner inputS = new Scanner(System.in);
		
		while(b) {
			if(n > 0) {
				while(bb) {
					System.out.println("계속 학점을 구하려면 keep을 입력\n그만하려면 quit를 입력하세요.");
					s = inputS.nextLine();
					
					if(s.equals("keep")) {
						System.out.println("계속 진행합니다.");
						bb = false;
					}else if(s.equals("quit")) {
						System.out.println("종료합니다.");
						b = false;
						bb = false;
					}else {
						System.out.println("다시 입력하세요.");
					}
				}
			}
			if(b == true) {
				System.out.println("점수를 입력하세요 : ");
				int score = input.nextInt();
				n++;
				bb = true;
				
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
	}

}
