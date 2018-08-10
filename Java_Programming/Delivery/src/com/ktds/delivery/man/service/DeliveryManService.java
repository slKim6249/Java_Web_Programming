package com.ktds.delivery.man.service;

import java.util.List;

import com.ktds.delivery.man.dao.DeliveryManDao;
import com.ktds.delivery.man.vo.DeliveryMan;
import com.ktds.delivery.vo.Delivery;

public class DeliveryManService {

	private DeliveryManDao deliveryManDao;
	
	public DeliveryManService() {
		this.deliveryManDao = new DeliveryManDao();
	}
	
	public List<DeliveryMan> findAllDeliveryMen() {
		return this.deliveryManDao.selectAllDeliveryMan();
	}
	
	public DeliveryMan findOneDeliveryMan(String phone) {
		return this.deliveryManDao.selectOneDeliveryMan(phone);
	}
	
	public boolean reigstOneDeliveryMan(DeliveryMan deliveryMan) {
		return this.deliveryManDao.insertOneDeliveryMan(deliveryMan) > 0;
	}
	
}
