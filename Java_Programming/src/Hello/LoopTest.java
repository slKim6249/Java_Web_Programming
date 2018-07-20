package Hello;

import java.util.Scanner;

public class LoopTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		String answer = "";
		String exit = "exit";
		
		while ( true ) {
			
			
			if( answer.equalsIgnoreCase(exit) ) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			System.out.println("단어를 입력해 주세요.");
			answer = input.next();
			System.out.println(answer);
			
		}
		
	}

}
