package Object;

public class Person {

	int money;
	
	int rent() {
		
		if( money > 0) {
			System.out.println("100만원 빌립시다.");
			money -= 1_000_000;
			return 1_000_000;
		} else {
			System.out.println("돈이 없어요..");
			return 0;
		}
		
	}
	
	int receive() {
		money += 1_000_000;
		System.out.println("감사합니다.");
		return money;
	}
	
}
