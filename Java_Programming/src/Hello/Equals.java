package Hello;

import java.util.Scanner;

/**
 * 
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class Equals {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String answer = "3";
		
		System.out.println("숫자를 입력하세요 : ");
		String check = input.nextLine();
		
		if( check.equals(answer) ) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}
		
	}

}
