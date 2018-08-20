package com.ktds.delivery.man.dao;

import java.util.List;

import com.ktds.delivery.man.vo.DeliveryMan;

public interface DeliveryManDaoInter {

	public List<DeliveryMan> selectAllDeliveryMan();
	public DeliveryMan selectOneDeliveryMan(String phone);
	public int insertOneDeliveryMan(DeliveryMan deliveryMan);
	
}
