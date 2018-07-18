package DataStructure;

import javax.xml.transform.Templates;

/**
 * 
 * 자료구조 실습
 * 
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class Arr {

	public static void main(String[] args) {
		
		int[] scoreArray = new int[4];
		
		/*
		 *    0   1   2   3
		 * ------------------
		 * | 100| 90| 97| 93|
		 * ------------------
		 * 
		 */
		
		scoreArray[0] = 100;
		scoreArray[1] = 90;
		scoreArray[2] = 97;
		scoreArray[3] = 93;
		
		int totalScore = scoreArray[0] + scoreArray[1] + scoreArray[2] +
				scoreArray[3];
		
		double average = totalScore / scoreArray.length;
		System.out.println(average);
		
		
		
		String text = "현재날씨는 10분 단위로 갱신되며, "
				+ "날씨 아이콘은 강수가 있는 경우에만 제공됩니다.";
		
		String[] spliterText = text.split(" "); // " " 걸러내기
		System.out.println(spliterText[0]);
		System.out.println(spliterText[1]);
		System.out.println(spliterText[2]);
		System.out.println(spliterText[3]);
		System.out.println(spliterText[4]);
		System.out.println(spliterText[5]);
		System.out.println(spliterText[6]);
		System.out.println(spliterText[7]);
		System.out.println(spliterText[8]);
		System.out.println(spliterText[9]);
		
		double[] todayTemp = new double[4];
		
		todayTemp[0] = 33.5;
		todayTemp[1] = 30.5;
		todayTemp[2] = 27.5;
		todayTemp[3] = 25.5;
		
		double tempResult = todayTemp[0] + todayTemp[1] +
				todayTemp[2] + todayTemp[3];
		
		average = tempResult / todayTemp.length;
		System.out.println(average);
		
	}

}
