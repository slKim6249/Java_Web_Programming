package Object;

public class PersonMain {

	public static void main(String[] args) {
		
		Person Sangmoo = new Person();
		Sangmoo.money = 1_500_000;
		
		System.out.println("Sangmoo는 " + Sangmoo.money + "를 가지고 있습니다.");
		
		int rentMoney = Sangmoo.money;
		System.out.println("Sangmoo에게 " + rentMoney + "를 빌렸습니다.");
		System.out.println("Sangmoo는 " + Sangmoo.money + "를 가지고 있습니다.");
		
		Sangmoo.receive();
		System.out.println("Sangmoo에게 " + rentMoney +"를 갚았습니다.");
		
	}

}
