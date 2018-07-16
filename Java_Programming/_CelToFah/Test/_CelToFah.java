package Test;

import java.util.Scanner;

public class _CelToFah {

	public static void main(String[] args) {
		
		boolean b = true;
		
		while(b) {
			
			System.out.println("메뉴를 골라주세요\n1. 화씨 -> 섭씨\n2. 섭씨 -> 화씨");
			
			Scanner input = new Scanner(System.in);
			int s = input.nextInt();
			
			if(s == 1) {
				Scanner inputF = new Scanner(System.in);
				System.out.print("화씨온도 입력 : ");
				double f = inputF.nextDouble();
			 
				double c = (5.0 / 9.0) * (f - 32);
				System.out.printf("화씨온도 %.3f는 섭씨온도 %.3f입니다.", f, c);
				b = false;
			} else if(s == 2) {
				Scanner inputC = new Scanner(System.in);
				System.out.print("섭씨온도 입력 : ");
				double c = inputC.nextDouble();
				 
	            double f = c * 1.8 + 32;
	            System.out.printf("섭씨온도 %.3f는 화씨온도 %.3f입니다.", c, f);
	            b = false;
			} else {
				System.out.println("메뉴를 1과 2중에 골라주세요\n");
			}
		}
		
	}

}
