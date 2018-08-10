package com.ktds.delivery.service;

import java.util.List;

import com.ktds.delivery.dao.DeliveryDao;
import com.ktds.delivery.vo.Delivery;

public class DeliveryService {

	private DeliveryDao deliveryDao;
	
	public DeliveryService() {
		this.deliveryDao = new DeliveryDao();
	}
	
	public List<Delivery> findAllDeliveries() {
		return this.deliveryDao.selectAllDelivery();
	}
	
	public Delivery findOneDelivery(String deliveryId) {
		return this.deliveryDao.selectOneDelivery(deliveryId);
	}
	
	public boolean createOneDelivery(Delivery delivery) {
		return this.deliveryDao.insertOneDeliveryMan(delivery) > 0;
	}
	
}
