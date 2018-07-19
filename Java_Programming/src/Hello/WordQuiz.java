package Hello;

import java.util.Scanner;

/**
 * 단어 맞추기 게임
 * 사용자가 맞힐때 까지 문제를 계속 진행
 * @author Sangmoo
 *
 */
public class WordQuiz {

	public static void main(String[] args) {
		
		String answer = "Apple";
		boolean flag = true;
		
		Scanner input = new Scanner(System.in);
		
		while( flag ) {
			
			System.out.println("사과의 영단어는 무엇일까요?");
			String usersAnswer = input.nextLine();
			
			if( usersAnswer.equalsIgnoreCase(answer) ) {
				System.out.println("정답입니다.\n퀴즈를 종료합니다.");
				flag = false;
			} else {
				System.out.println("오답입니다.\n다시 시도하세요.");
			}
			
		}
		
	}

}
