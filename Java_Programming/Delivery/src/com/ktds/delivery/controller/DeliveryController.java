package com.ktds.delivery.controller;

import java.util.List;

import com.ktds.delivery.service.DeliveryService;
import com.ktds.delivery.vo.Delivery;
import com.ktds.utils.Common;

public class DeliveryController {

	private DeliveryService deliveryService;
	
	public DeliveryController() {
		this.deliveryService = new DeliveryService();
	}
	
	public boolean createOneDelivery() {
		
		System.out.println("택배 등록 프로세스");
		
		Delivery delivery = new Delivery();
		
		System.out.print("운송장 번호를 입력하세요.");
		String deliveryId = Common.INPUT.next();
		delivery.setDeliveryId(deliveryId);
		
		System.out.print("택배 상자의 크기를 입력하세요.( 1 ~ 5 )");
		int boxSize = Common.INPUT.nextInt();
		delivery.setBoxSize(boxSize);
		
		System.out.print("택배 상품의 무게를 입력하세요.( kg )");
		double weight = Common.INPUT.nextDouble();
		delivery.setWeight(weight);
		
		System.out.print("택배 상품의 가격을 입력하세요.( 원 )");
		double price = Common.INPUT.nextDouble();
		delivery.setPrice(price);
		
		System.out.print("택배 상품의 이름을 입력하세요.");
		String name = Common.INPUT.next();
		delivery.setName(name);
		
		System.out.print("택배 상품의 종류를 입력하세요.");
		String type = Common.INPUT.next();
		delivery.setType(type);
		
		System.out.print("택배 상품이 취급주의를 요하나요? (Y/N)");
		String fragil = Common.INPUT.next();
		delivery.setFragil(fragil);
		
		System.out.print("배송거리를 입력하세요. ( km )");
		double distance = Common.INPUT.nextDouble();
		delivery.setDistance(distance);
		
		System.out.print("배송 방법을 입력하세요. ( Y(퀵)/N(택배) )");
		String quick = Common.INPUT.next();
		delivery.setQuick(quick);
		
		System.out.print("지불 방법을 입력하세요. ( Y(선불)/N(착불) )");
		String payType = Common.INPUT.next();
		delivery.setPayType(payType);
		
		System.out.print("배송비를 입력하세요. ( 원 )");
		int shippingFee = Common.INPUT.nextInt();
		delivery.setShippingFee(shippingFee);
		
		System.out.print("반송 여부를 입력하세요. ( Y/N )");
		String returnYn = Common.INPUT.next();
		delivery.setReturnYn(returnYn);
		
		System.out.print("배송시 요청사항을 입력하세요.");
		String message = Common.INPUT.nextLine();
		delivery.setMessage(message);
		
		System.out.print("받는 고객의 연락처를 입력하세요.");
		String toPhone = Common.INPUT.next();
		delivery.setToPhone(toPhone);
		
		System.out.print("보내는 고객의 연락처를 입력하세요.");
		String fromPhone = Common.INPUT.next();
		delivery.setFromPhone(fromPhone);
		
		System.out.print("배송 기사의 연락처를 입력하세요.");
		String deliveryManPhone = Common.INPUT.next();
		delivery.setDeliveryManPhone(deliveryManPhone);
		
		return this.deliveryService.createOneDelivery(delivery);
	}
	
	public void printAllDeliveries() {
		System.out.println("택배 전체 조회 프로세스");
		
		List<Delivery> deliveryList = 
				this.deliveryService.findAllDeliveries();
		
		for (Delivery delivery : deliveryList) {
			System.out.println("==========================================");
			System.out.println("운송장 번호 : " + delivery.getDeliveryId() );
			System.out.println("보내는 고객 연락처 : " + delivery.getFromPhone() );      
			System.out.println("받는 고객 연락처 : " + delivery.getToPhone() );        
			System.out.println("배송 기사 연락처 : " + delivery.getDeliveryManPhone() );
			System.out.println("택배 상자 크기 : " + delivery.getBoxSize() );           
			System.out.println("택배 무게 : " + delivery.getWeight() );         
			System.out.println("택배 상품 가격 : " + delivery.getPrice() );          
			System.out.println("택배 상품 이름 : " + delivery.getName() );           
			System.out.println("택배 상품 종류 : " + delivery.getType() );           
			System.out.println("취급주의 여부 : " + delivery.getFragil() );         
			System.out.println("배송 거리 : " + delivery.getDistance() );       
			System.out.println("배송 형태 : (Y:퀵, N:택배)" + delivery.getQuick() );          
			System.out.println("지불 방법 : (Y:선불, N:착불)" + delivery.getPayType() );        
			System.out.println("배송 비 : " + delivery.getShippingFee() );       
			System.out.println("반송 여부 : " + delivery.getReturnYn() );       
			System.out.println("배송시 요청사항 : " + delivery.getMessage() );                  
			System.out.println("배송 날짜 : " + delivery.getReceiptDate() );                  
		}
				
	}
	
	public void printOneDelivery() {
		System.out.println("택배 조회 프로세스");
		
		System.out.println("운송장 번호를 입력하세요.");
		String deliveryId = Common.INPUT.next();
		
		Delivery delivery = 
				this.deliveryService.findOneDelivery(deliveryId);
		
		System.out.println("==========================================");
		System.out.println("운송장 번호 : " + delivery.getDeliveryId() );
		System.out.println("보내는 고객 연락처 : " + delivery.getFromPhone() );      
		System.out.println("받는 고객 연락처 : " + delivery.getToPhone() );        
		System.out.println("배송 기사 연락처 : " + delivery.getDeliveryManPhone() );
		System.out.println("택배 상자 크기 : " + delivery.getBoxSize() );           
		System.out.println("택배 무게 : " + delivery.getWeight() );         
		System.out.println("택배 상품 가격 : " + delivery.getPrice() );          
		System.out.println("택배 상품 이름 : " + delivery.getName() );           
		System.out.println("택배 상품 종류 : " + delivery.getType() );           
		System.out.println("취급주의 여부 : " + delivery.getFragil() );         
		System.out.println("배송 거리 : " + delivery.getDistance() );       
		System.out.println("배송 형태 : (Y:퀵, N:택배)" + delivery.getQuick() );          
		System.out.println("지불 방법 : (Y:선불, N:착불)" + delivery.getPayType() );        
		System.out.println("배송 비 : " + delivery.getShippingFee() );       
		System.out.println("반송 여부 : " + delivery.getReturnYn() );       
		System.out.println("배송시 요청사항 : " + delivery.getMessage() ); 
		System.out.println("배송 날짜 : " + delivery.getReceiptDate() );
				
	}
	
}
