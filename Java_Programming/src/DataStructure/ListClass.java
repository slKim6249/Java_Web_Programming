package DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 자료구조 실습
 * 
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class ListClass {

	public static void main(String[] args) {
		
		List<Integer> scoreList = new ArrayList<Integer>();
		
		scoreList.add(100);
		scoreList.add(90);
		scoreList.add(97);
		scoreList.add(93);
		
		int sum = scoreList.get(0);
		sum += scoreList.get(1);
		sum += scoreList.get(2);
		sum += scoreList.get(3);
		
		System.out.println(sum);
		
		double avg = sum / (double) scoreList.size();
		System.out.println(avg);
		
		
		scoreList.remove(0);
		System.out.println( scoreList.get(0) );
		
		scoreList.removeAll(scoreList);
		// System.out.println( scoreList.get(0) ); // Index 초과 에러
		
		
		List<Double> movieGrade = new ArrayList<Double>();
		
		movieGrade.add(7.67);
		movieGrade.add(5.89);
		movieGrade.add(9.06);
		movieGrade.add(7.98);
		movieGrade.add(4.16);
		movieGrade.add(9.47);
		movieGrade.add(8.21);
		movieGrade.add(8.49);
		movieGrade.add(9.58);
		movieGrade.add(5.99);
		
		double movieAvg = movieGrade.get(0);
		movieAvg += movieGrade.get(1);
		movieAvg += movieGrade.get(2);
		movieAvg += movieGrade.get(3);
		movieAvg += movieGrade.get(4);
		movieAvg += movieGrade.get(5);
		movieAvg += movieGrade.get(6);
		movieAvg += movieGrade.get(7);
		movieAvg += movieGrade.get(8);
		movieAvg += movieGrade.get(9);
		
		avg = movieAvg / movieGrade.size();
		System.out.println(avg);
		
	}

}
