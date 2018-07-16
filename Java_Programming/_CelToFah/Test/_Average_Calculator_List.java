package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _Average_Calculator_List {

	public static void main(String[] args) {
		
		List<Integer> scores = new ArrayList<Integer>( );
		int c = 0, result = 0;
		
		System.out.println("수학, 영어, 물리, 프로그래밍 점수를 차례대로 입력하세요\n");
		
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i<4; i++) {
			c = input.nextInt();
			scores.add(c);
		}
		
		for(int j=0; j<scores.size(); j++) {
			result += scores.get(j);
		}
		
		System.out.printf("모든 과목의 평균은 %d입니다.", result/scores.size());
	}

}
