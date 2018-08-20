package com.ktds.delivery.man.service;

import java.util.List;

import com.ktds.delivery.man.dao.DeliveryManDao;
import com.ktds.delivery.man.dao.DeliveryManDaoInter;
import com.ktds.delivery.man.vo.DeliveryMan;

public class DeliveryManService implements DeliveryManServiceInter {

	private DeliveryManDaoInter deliveryManDao;
	
	public void setDeliveryManDao(DeliveryManDaoInter deliveryManDao) {
		this.deliveryManDao = deliveryManDao;
	}

	@Override
	public List<DeliveryMan> findAllDeliveryMen() {
		return this.deliveryManDao.selectAllDeliveryMan();
	}
	
	@Override
	public DeliveryMan findOneDeliveryMan(String phone) {
		return this.deliveryManDao.selectOneDeliveryMan(phone);
	}
	
	@Override
	public boolean reigstOneDeliveryMan(DeliveryMan deliveryMan) {
		return this.deliveryManDao.insertOneDeliveryMan(deliveryMan) > 0;
	}
	
}
