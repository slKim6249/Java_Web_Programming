package Hello;

import java.util.Scanner;

public class prac {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
//		System.out.println("첫번째 숫자를 입력하세요.");
//		int one = input.nextInt();
//		System.out.println("두번째 숫자를 입력하세요.");
//		int two = input.nextInt();
//		
//		if( one > two ) {
//			System.out.printf("큰 숫자는 %d입니다.", one);
//		} else {
//			System.out.printf("큰 숫자는 %d입니다.", two);
//		}
		
		System.out.println("첫번째 숫자를 입력하세요.");
		int one = input.nextInt();
		System.out.println("두번째 숫자를 입력하세요.");
		int two = input.nextInt();
		System.out.println("세번째 숫자를 입력하세요.");
		int three = input.nextInt();
		
		if( one > two && two < three ) {
			System.out.printf("가장 작은 수는 %d입니다.", two);
		} else if( two > one && one < three ) {
			System.out.printf("가장 작은 수는 %d입니다.", one);
		} else {
			System.out.printf("가장 작은 수는 %d입니다.", three);
		}

	}

}
