package Test;

import java.util.Scanner;

public class _CelToFah {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("메뉴를 골라주세요\n1. 화씨 -> 섭씨\n2. 섭씨 -> 화씨");
			
			Scanner input = new Scanner(System.in);
			int select = input.nextInt();
			
			if(select == 1) {
				Scanner inputFah = new Scanner(System.in);
				System.out.print("화씨온도 입력 : ");
				double fah = inputFah.nextDouble();
			 
				double cel = (5.0 / 9.0) * (fah - 32);
				System.out.printf("화씨온도 %.3f는 섭씨온도 %.3f입니다.", fah, cel);
				flag = false;
			} else if(select == 2) {
				Scanner inputC = new Scanner(System.in);
				System.out.print("섭씨온도 입력 : ");
				double cel = inputC.nextDouble();
				
	            double fah = cel * 1.8 + 32;
	            System.out.printf("섭씨온도 %.3f는 화씨온도 %.3f입니다.", cel, fah);
	            flag = false;
			} else {
				System.out.println("메뉴를 1과 2중에 골라주세요\n");
			}
		}
		
	}

}
