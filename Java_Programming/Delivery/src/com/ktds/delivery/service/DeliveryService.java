package com.ktds.delivery.service;

import java.util.List;

import com.ktds.delivery.dao.DeliveryDaoInter;
import com.ktds.delivery.vo.Delivery;

public class DeliveryService implements DeliveryServiceInter {

	private DeliveryDaoInter deliveryDao;
	
	public void setDeliveryDao(DeliveryDaoInter deliveryDao) {
		this.deliveryDao = deliveryDao;
	}

	@Override
	public List<Delivery> findAllDeliveries() {
		return this.deliveryDao.selectAllDelivery();
	}
	
	@Override
	public Delivery findOneDelivery(String deliveryId) {
		return this.deliveryDao.selectOneDelivery(deliveryId);
	}
	
	@Override
	public boolean createOneDelivery(Delivery delivery) {
		return this.deliveryDao.insertOneDeliveryMan(delivery) > 0;
	}
	
}
