package Hello;

public class VariableScope {

	static int zipCode = 931220; // 멤버 변수
	
	public static void main(String[] args) {
		
		int age = 26; // 지역 변수
		System.out.println(zipCode);
		System.out.println(age);
		
	}

}
