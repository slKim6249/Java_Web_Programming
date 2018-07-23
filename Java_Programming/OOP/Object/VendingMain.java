package Object;

import java.util.ArrayList;

public class VendingMain {

	public static void main(String[] args) throws InterruptedException {
		
		

		Thread th = new Thread();
		VendingMachine vm = new VendingMachine();
		
		vm.drinkList = new ArrayList<String>(); // 값 초기화
		vm.fill();
		
		
//		while( !(vm.drinkList.isEmpty()) ) {
//			System.out.println(vm.extract());
//		}
		
		while( true ) {
			
			if( vm.drinkList.size() == 0 ) {
				vm.fill();
			} else {
				th.sleep(2000, 100);
				String drink = vm.extract();
				System.out.println(drink + "를 뽑았습니다.");
			}
			
		}
		
	}

}
