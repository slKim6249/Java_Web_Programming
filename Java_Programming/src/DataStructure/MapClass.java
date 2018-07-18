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
		
		
		Map<String, Double> movie = new HashMap<String, Double>( );
		
		movie.put("스카이스크래퍼", 8.25);
		movie.put("앤트맨와스프", 8.69);
		movie.put("시카리오", 8.56);
		movie.put("오션스8", 7.86);
		movie.put("쥬라기월드", 8.17);
		movie.put("한솔로", 7.90);
		movie.put("데드풀2", 8.76);
		movie.put("어벤져스", 8.97);
		movie.put("삼손", 7.22);
		movie.put("크리미널스쿼드", 5.54);
		
		System.out.printf("데드풀2의 평점 : %s", movie.get("데드풀2"));
		
	}

}
