package Hello;

import java.util.Scanner;

public class prac {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double money = 1_500_000;
		double usaPort = 2_000_000;
		
		System.out.println("현금입니까 ?\n맞으면 1 아니면 아무 키를 입력해주세요.");
		int select = input.nextInt();
		
		if( select == 1 ) {
			
			usaPort *= 0.9;
			
			if( money > usaPort ) {
				System.out.println("구입 완료");
			} else {
				System.out.println("구입 불가");
			}
			
		} else {
			
			if( money > usaPort ) {
				System.out.println("구입 완료");
			} else {
				System.out.println("구입 불가");
			}
			
		}
		
	}

}
