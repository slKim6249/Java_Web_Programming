package Hello;

import java.util.Scanner;

public class CalculatorThreeNumbers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력해 주세요.");
		int one = input.nextInt();
		
		System.out.println("두번째 숫자를 입력해 주세요.");
		int two = input.nextInt();
		
		System.out.println("세번째 숫자를 입력해 주세요.");
		int three = input.nextInt();
		
		int result = one + two + three;
		
		System.out.println(result);

	}

}
