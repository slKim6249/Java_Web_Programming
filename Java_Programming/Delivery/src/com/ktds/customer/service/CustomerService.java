package com.ktds.customer.service;

import java.util.List;

import com.ktds.customer.dao.CustomerDao;
import com.ktds.customer.vo.Customer;

public class CustomerService {

	private CustomerDao customerDao;
	
	public CustomerService() {
		this.customerDao = new CustomerDao();
	}
	
	public List<Customer> findAllCustomers() {
		return this.customerDao.selectAllCustomer();
	}
	
	public Customer findOneCustomer(String phone) {
		return this.customerDao.selectOneCustomer(phone);
	}
	
	public boolean registOneCustomer(Customer customer) {
		return this.customerDao.insertOneCustomer(customer) > 0;
	}
	
}








