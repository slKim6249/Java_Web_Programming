package Hello;

/** Document Comment
 * 변수의 종류와 범위를 실습하는 코드
 * 
 * @author Sangmoo ( first_1st@naver.com )
 * @since 1.0
 */
public class VariableScope {

	/**
	 * 멤버변수 : 우편번호
	 * */
	static int zipCode = 931220;
	
	/**
	 * 
	 * Java Application의 시작점
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		
		int age = 26;
		System.out.println(zipCode);
		System.out.println(age);
		
	}

}
