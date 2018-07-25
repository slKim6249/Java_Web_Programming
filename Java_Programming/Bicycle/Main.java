import java.util.Scanner;

public class Main {
	
	public static void viewHome() {
		System.out.println("==================================");
		System.out.println("따릉이 대여소");
		System.out.println("==================================");
		
		System.out.println("메뉴를 선택하세요. ");
		System.out.println("1. 대여");
		System.out.println("2. 반납");
		System.out.println("3. 종료");
	}
	
	public static void rentProcess(RentalShop rentalShop) {
		System.out.println("자전거 좀 빌릴 수 있을까요?");
		boolean isPossible = rentalShop.isPossible();
		if ( isPossible ) {
			Bicycle bicycle = rentalShop.rent();
			System.out.println(bicycle.getName() + "를 빌렸습니다.");
		} else {
			System.out.println("자전거가 모두 대여되었습니다.");
			System.out.println("대여할 자전거가 없습니다.");
		}
	}
	
	public static void returnProcess(RentalShop rentalShop, Scanner input) {
		System.out.println("자전거 반납할께요.");
		rentalShop.returnBycle();
		
		System.out.println("사용한 시간을 입력하세요 : ");
		int usageHour = input.nextInt();
		
		int fee = rentalShop.billing(usageHour);
		System.out.println(fee + "원 나왔습니다.");
	}
	
	public static void repeatProcess(RentalShop rentalShop,
										Scanner input) {
		while( true ) {
			viewHome();
			
			int menu = input.nextInt();
			
			if( menu == 1 ) {
				rentProcess(rentalShop);
			} else if( menu == 2 ) {
				returnProcess(rentalShop, input);
			} else if( menu == 3 ) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.\n다시 입력해주세요.");
			}
		}
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		
		RentalShop rentalShop = new RentalShop(20); // bicycle수 지정
		
		repeatProcess(rentalShop, input);
	}

	public static void main(String[] args) {
		// Main.main = new Main();
		// main.run();
		new Main().run();
	}

}
