package Object;

import java.util.List;

public class VendingMachine {

	List<String> drinkList = null;
	
	void fill() {
		System.out.println("음료를 채웠습니다.");
		drinkList.add("콜라");
		drinkList.add("사이다");
		drinkList.add("환타");
	}
	
	String extract() {
		System.out.println("음료를 추출합니다.");
		String drink = drinkList.get(0);
		drinkList.remove(0);
		return drink;
		
	}
	
}
