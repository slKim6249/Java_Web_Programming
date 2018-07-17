package Hello;

import java.util.Scanner;

public class UsersInput {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("숫자를 입력해 주세요.");
		int one = input.nextInt();
		System.out.println(one + "을 입력했습니다.");
		
		System.out.println("숫자를 입력해 주세요.");
		int two = input.nextInt();
		System.out.println(two + "을 입력했습니다.");
		
		int result = one + two;
		
		System.out.println(result);

	}

}
