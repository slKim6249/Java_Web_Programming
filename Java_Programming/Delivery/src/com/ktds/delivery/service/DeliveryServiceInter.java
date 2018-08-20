package com.ktds.delivery.service;

import java.util.List;

import com.ktds.delivery.vo.Delivery;

public interface DeliveryServiceInter {

	public List<Delivery> findAllDeliveries();
	public Delivery findOneDelivery(String deliveryId);
	public boolean createOneDelivery(Delivery delivery);
	
}
