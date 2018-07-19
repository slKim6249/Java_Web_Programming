package Hello;

import java.util.Random;
import java.util.Scanner;

/**
 * 업앤다운 게임 만들기
 * @author Sangmoo
 *
 */
public class UpAndDown {

	public static void main(String[] args) {
		
		Random random = new Random();
		int answer = random.nextInt(100);
		
		Scanner input = new Scanner(System.in);
		
		while( true ) {
			
			System.out.println("숫자를 입력하세요.");
			int usersAnswer = input.nextInt();
			
			if( usersAnswer < answer ) {
				System.out.println("Up");
			} else if( usersAnswer > answer ) {
				System.out.println("Down");
			} else {
				System.out.println("정답");
				break;
			}
			
		}
		
	}

}
