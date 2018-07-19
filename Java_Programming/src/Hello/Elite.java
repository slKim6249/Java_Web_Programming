package Hello;

import java.util.Scanner;

public class Elite {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Java의 점수를 입력하세요 : ");
		int java = input.nextInt();
		
		System.out.println("Python의 점수를 입력하세요 : ");
		int python = input.nextInt();
		
		// ShortCut 평가
		if ( java >= 90 && python >= 90 ) {
			System.out.println("A등급");	
		} else if( java >= 90 || python >= 90 ) {
			System.out.println("B등급");
		}
		
		String name = "Moo";
		if ( !(name.equalsIgnoreCase(name)) ) {
			System.out.println("틀렸습니다.");
		}
		
	}

}
