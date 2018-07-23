package Object;

public class Name {
	
	String name;
	
	/**
	 * 문자열의 길이를 가져와 출력
	 */
	void printLengthOfName() {
		
		name = "Sangmoo";
		
		int lengthOfName = name.length();
		System.out.println(lengthOfName);
		
	}
	
	int getLengthOfName() {
		
		name = "Jeon Sang moon";
		
		int lengthOfName = name.length();
		return lengthOfName;
	}
	
}
