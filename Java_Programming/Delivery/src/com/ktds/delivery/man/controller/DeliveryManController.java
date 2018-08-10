package com.ktds.delivery.man.controller;

import java.util.List;

import com.ktds.delivery.man.service.DeliveryManService;
import com.ktds.delivery.man.vo.DeliveryMan;
import com.ktds.utils.Common;

public class DeliveryManController {

	private DeliveryManService deliveryManService;
	
	public DeliveryManController() {
		this.deliveryManService = new DeliveryManService();
	}
	
	public boolean registOneDeliveryMan() {
		System.out.println("배송기사 등록 프로세스");
		
		System.out.print("배송기사의 연락처를 입력하세요.");
		String phone = Common.INPUT.next();
		
		System.out.print("배송기사의 이름을 입력하세요.");
		String name = Common.INPUT.next();
		
		DeliveryMan deliveryMan = new DeliveryMan(phone, name);
		
		return this.deliveryManService
					.reigstOneDeliveryMan(deliveryMan);
	}
	
	public void printAllDeliveryMen() {
		System.out.println("배송기사 전체 조회 프로세스");
		
		List<DeliveryMan> deliveryManList = 
				this.deliveryManService.findAllDeliveryMen();
		
		for (DeliveryMan deliveryMan : deliveryManList) {
			System.out.println("------------------------------");
			System.out.println("배송기사 연락처 : " + deliveryMan.getPhone());
			System.out.println("배송기사 이름 : " + deliveryMan.getName());
		}
	}
	
	public void printOneDeliveryMan() {
		System.out.println("배송기사 조회 프로세스");
		
		System.out.print("배송기사의 연락처를 입력하세요.");
		String phone = Common.INPUT.next();
		
		DeliveryMan deliveryMan = 
				this.deliveryManService.findOneDeliveryMan(phone);
		
		System.out.println("------------------------------");
		System.out.println("배송기사 연락처 : " + deliveryMan.getPhone());
		System.out.println("배송기사 이름 : " + deliveryMan.getName());
	}
}











