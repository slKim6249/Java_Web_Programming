package Hello;

/**
 * 
 * 명시적 Casting 실습
 * 
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class TypeCasting {

	public static void main(String[] args) {
		
		int price = (int) 10_000_000_000L;
		System.out.println(price);
		
		// 2147483647
		System.out.println(Integer.MAX_VALUE);
		// -2147483647
		System.out.println(Integer.MIN_VALUE);
		// 최대값 +1 => 다시 음수로 가서 반복 한 -2147483648 - overflow
		System.out.println(Integer.MAX_VALUE+1);
		
		double pi = 3.14;
		int number = (int) pi;
		
		// "123" => 123
		String age = "26";
		int newAge = Integer.parseInt(age);
		
	}

}
