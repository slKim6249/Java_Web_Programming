package Hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		List<String> nameList = new ArrayList<String>();
		
		int select;
		String name;
		String selectYN;
		boolean flag = true;
		
		System.out.println("수강생 등록 프로그램입니다.");
		
		while( true ) {
			
			System.out.println("수강생 등록을 하시려면 1");
			System.out.println("수강생 조회를 하시려면 2");
			
			select = input.nextInt();
			
			if ( select == 1 ) {
				flag = true;
				while( flag ) {
					System.out.println("수강생의 이름을 입력하세요.");
					name = input.next();
					nameList.add(name);
					
					System.out.println("계속 등록 하시겠습니까? (Y/N)");
					selectYN = input.next();
					
					if( selectYN.equalsIgnoreCase("Y") ) {
						flag = true;
					} else if ( selectYN.equalsIgnoreCase("N") ) {
						flag = false;
					}
				}
				
				
			} else if ( select == 2 ) {
				
				for (String namePrint : nameList) {
					System.out.println(namePrint);
				}
				
			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		
	}

}
