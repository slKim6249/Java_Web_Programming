package Hello;

/**
 * 
 * 사칙연산 실습
 * 
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class Arithmatic {

	public static void main(String[] args) {
		
		// +
		// 1. 숫자 + 숫자
		// 2. 숫자 + 문자
		// 3. 문자 + 문자
		int scoreOne = 100;
		int scoreTwo = 80;
		int scoreThree = 90;
		
		int totalScore = scoreOne + scoreTwo + scoreThree;
		
		// 연산자의 규칙
		/*
		 *  1. 숫자 + 숫자 = 숫자
		 *  2. 숫자 + 문자 = 문자
		 *  3. 정수 + 정수 = 정수
		 *  4. 실수 + 실수 = 실수
		 *  5. 정수 + 실수 = 실수
		 *  6. 4bytes + 8bytes = 8bytes
		 *  7. 1bytes + 2bytes = 2bytes
		 *  8. int + long = long
		 */
		
		
		// -
		int numberOne = 10;
		long numberTwo = 4;
		
		long subtractionResult = numberOne - numberTwo;
		
		// *
		long bigNumber = 1_000_000L; // Java 1.7부터 자리수 가능
		int number = 3;
		
		long multiplecationResult = bigNumber * number;
		
		// /
		numberOne = 5;
		numberTwo = 3;
		double divisionResult= numberOne / (numberTwo * 1.0);
		System.out.println(divisionResult);
		
		// %
		long modResult = numberOne % numberTwo;
		System.out.println(modResult);

	}

}
