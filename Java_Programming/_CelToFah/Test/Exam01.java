package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam01 {
	
	

	public static void main(String[] args) {
		
		int resultAvg1 = 0;
		int resultAvg2 = 0;
		int resultAvg3 = 0;
		
		List<Integer> grade1 = new ArrayList<Integer>();
		
		grade1.add(80);
		grade1.add(50);
		grade1.add(60);
		grade1.add(70);
		
		for(int j=1; j <= grade1.size(); j++) {
			resultAvg1 += grade1.get(grade1.size() - j);
		}
		
		int GradeAvg1 = resultAvg1 / grade1.size();
		
		List<Integer> Avg1 = new ArrayList<Integer>();
		
		Avg1.add(GradeAvg1);
		
		List<Integer> grade2 = new ArrayList<Integer>();
		
		grade2.add(10);
		grade2.add(50);
		grade2.add(40);
		grade2.add(50);
		
		for(int j=1; j <= grade2.size(); j++) {
			resultAvg2 += grade2.get(grade2.size() - j);
		}
		
		int GradeAvg2 = resultAvg2 / grade2.size();
		
		List<Integer> Avg2 = new ArrayList<Integer>();
		
		Avg2.add(GradeAvg2);
		
		
		
		List<Integer> grade3 = new ArrayList<Integer>();
			
		grade3.add(80);
		grade3.add(20);
		grade3.add(40);
		grade3.add(70);
		
		for(int j=1; j <= grade3.size(); j++) {
			resultAvg3 += grade3.get(grade3.size() - j);
		}
		
		int GradeAvg3 = resultAvg3 / grade3.size();
		
		List<Integer> Avg3 = new ArrayList<Integer>();
		
		Avg3.add(GradeAvg3);
		
		
		Map<String, List<Integer>> studentGrade = 
				new HashMap<String, List<Integer>>( );

		studentGrade.put("둘리", Avg1);
		studentGrade.put("또치", Avg2);
		studentGrade.put("길동", Avg3);
		
//		System.out.printf("둘리의 평균 점수 : %s\n", studentGrade.get("둘리"));
		System.out.printf("둘리의 평균 점수 : %s\n", studentGrade.get("둘리").toString().substring(1, 3));
		System.out.printf("또치의 평균 점수 : %s\n", studentGrade.get("또치").toString().substring(1, 3));
		System.out.printf("길동의 평균 점수 : %s", studentGrade.get("길동").toString().substring(1, 3));
		
	}

}
