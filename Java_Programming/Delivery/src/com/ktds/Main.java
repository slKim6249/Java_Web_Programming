package com.ktds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ktds.customer.controller.CustomerController;
import com.ktds.delivery.controller.DeliveryController;
import com.ktds.delivery.man.controller.DeliveryManController;
import com.ktds.utils.Common;

public class Main {

	private CustomerController customerController;
	private DeliveryManController deliveryManController;
	private DeliveryController deliveryController;
	
	public Main() {
		customerController = new CustomerController();
		deliveryManController = new DeliveryManController();
		deliveryController = new DeliveryController();
	}
	
	public static void main(String[] args) {
		
		
		String applicationContext = "/applicationContext.xml";
		
		AbstractApplicationContext ctx =
				new ClassPathXmlApplicationContext(applicationContext);
		
		Main main = new Main();
		main.customerController = ctx.getBean("customer.controller", CustomerController.class);
		main.deliveryController = ctx.getBean("delivery.controller", DeliveryController.class);
		main.deliveryManController = ctx.getBean("deliveryMan.controller", DeliveryManController.class);
		
		main.run();
	}
	
	
	public void run() {
		while ( true ) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 고객");
			System.out.println("2. 기사");
			System.out.println("3. 택배");
			System.out.println("9. 종료");
			
			int menu = Common.INPUT.nextInt();
			if ( menu == 1 ) {
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 고객 등록");
				System.out.println("2. 고객 조회");
				System.out.println("3. 고객 검색");
				menu = Common.INPUT.nextInt();
				if ( menu == 1 ) {
					boolean isRegist = 
							customerController.registOneCustomer();
				}
				else if ( menu == 2 ) {
					customerController.printAllCustomers();
				}
				else if ( menu == 3 ) {
					customerController.printOneCustomer();
				}
			}
			else if ( menu == 2 ) {
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 기사 등록");
				System.out.println("2. 기사 조회");
				System.out.println("3. 기사 검색");
				menu = Common.INPUT.nextInt();
				if ( menu == 1 ) {
					boolean isRegist = 
							deliveryManController.registOneDeliveryMan();
				}
				else if ( menu == 2 ) {
					deliveryManController.printAllDeliveryMen();
				}
				else if ( menu == 3 ) {
					deliveryManController.printOneDeliveryMan();
				}
			}
			else if ( menu == 3 ) {
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 택배 등록");
				System.out.println("2. 택배 조회");
				System.out.println("3. 택배 검색");
				menu = Common.INPUT.nextInt();
				if ( menu == 1 ) {
					boolean isRegist = 
							deliveryController.createOneDelivery();
				}
				else if ( menu == 2 ) {
					deliveryController.printAllDeliveries();
				}
				else if ( menu == 3 ) {
					deliveryController.printOneDelivery();
				}
			}
			else if ( menu == 9 ) {
				break;
			}
		}
	}
}






