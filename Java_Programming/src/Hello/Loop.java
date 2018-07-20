package Hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DataStructure.Arr;

/**
 * 
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class Loop {

	public static void main(String[] args) {
		
		Random random = new Random();
		
//		while( true ) {
//			System.out.println("안녕하세요.");
//			
//			int number = random.nextInt(45);
//			number++;
//			
//			System.out.println(number);
//		}
		
		List<Integer> lottoNumberList = new ArrayList<Integer>();
		
		while( true ) {
			
			int lottoNumber = random.nextInt(45);
			lottoNumber++;
			
			if( !lottoNumberList.contains(lottoNumber) ) {
				lottoNumberList.add(lottoNumber);
			} 
			
			if ( lottoNumberList.size() == 6) {
				break;
			}
			
		}
		
		for (Integer number : lottoNumberList) {
			System.out.printf("로도 번호 : %d\n", number);
		}
		
	}

}
