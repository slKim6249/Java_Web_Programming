package com.ktds.delivery.dao;

import java.util.List;

import com.ktds.delivery.vo.Delivery;

public interface DeliveryDaoInter {

	public List<Delivery> selectAllDelivery();
	public Delivery selectOneDelivery(String deliveryId);
	public int insertOneDeliveryMan(Delivery delivery);
	
}
