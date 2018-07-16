package Test;

import java.util.HashMap;
import java.util.Map;

public class _Average_Calculator_Map {

	public static void main(String[] args) {
		
		Map<String, Integer>  scores = new HashMap<String, Integer>( );
		
		scores.put("수학", 50);
		scores.put("영어", 60);
		scores.put("물리", 60);
		scores.put("프로그래밍", 80);
		
		int result = scores.get("수학");
		result += scores.get("영어");
		result += scores.get("물리");
		result += scores.get("프로그래밍");
		
		System.out.printf("모든 과목의 평균은 %d입니다.", result/scores.size());
		
	}

}
