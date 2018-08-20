package com.ktds.delivery.man.service;

import java.util.List;

import com.ktds.delivery.man.vo.DeliveryMan;

public interface DeliveryManServiceInter {
	
	public List<DeliveryMan> findAllDeliveryMen();
	public DeliveryMan findOneDeliveryMan(String phone);
	public boolean reigstOneDeliveryMan(DeliveryMan deliveryMan);
	
}
