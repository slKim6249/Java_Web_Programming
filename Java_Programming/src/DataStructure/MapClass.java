package DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 자료구조 실습
 * 
 * @author Sangmoo ( first_1st@naver.com )
 *
 */
public class MapClass {

	public static void main(String[] args) {
		
		Map<String, String> momstouch = new HashMap<String, String>( );
		
		momstouch.put("01", "싸이버거");
		momstouch.put("02", "휠렛버거");
		momstouch.put("03", "햄치즈휠렛버거");
		momstouch.put("04", "할라피뇨통살/통가슴살버거");

		System.out.println(momstouch.get("04"));
	}

}
