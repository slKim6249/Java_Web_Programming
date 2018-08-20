package com.ktds.customer.service;

import java.util.List;

import com.ktds.customer.dao.CustomerDao;
import com.ktds.customer.dao.CustomerDaoInter;
import com.ktds.customer.vo.Customer;

public class CustomerService implements CustomerServiceInter {

	private CustomerDaoInter customerDao;
	
	public void setCustomerDao(CustomerDaoInter customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return this.customerDao.selectAllCustomer();
	}
	
	@Override
	public Customer findOneCustomer(String phone) {
		return this.customerDao.selectOneCustomer(phone);
	}
	
	@Override
	public boolean registOneCustomer(Customer customer) {
		return this.customerDao.insertOneCustomer(customer) > 0;
	}
	
}








