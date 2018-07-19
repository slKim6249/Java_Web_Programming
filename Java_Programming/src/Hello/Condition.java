package Hello;

import java.util.ArrayList;
import java.util.List;

/**
 * if 제어문을 학습하기 위한 클래스
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class Condition {

	public static void main(String[] args) {
		 
		int age = 26;
		
		if( age > 19) {
			String welcomeMessage = "성인입니다.";
			System.out.println( welcomeMessage );
		} else {
			System.out.println("미성년자입니다.");
		}
		
		// 수학/물리/영어/프로그래밍 점수의 평균을 계산해 출력
		boolean isGrade;
		
		List<Integer> scoreList = new ArrayList<Integer>();
		scoreList.add(100); // 수학
		scoreList.add(90); // 물리
		scoreList.add(97); // 영어
		scoreList.add(98); // 프로그래밍
		
		int totalScore = scoreList.get(0) + scoreList.get(1)+
				scoreList.get(2) + scoreList.get(3);
		
		double average = totalScore / (scoreList.size() * 1.0);
		
		System.out.printf("%.2f\n" ,average);
		
		if ( isGrade = average > 95 ) {
			String grade = "A+입니다.";
			System.out.println( grade );
		}
		
	}

}
