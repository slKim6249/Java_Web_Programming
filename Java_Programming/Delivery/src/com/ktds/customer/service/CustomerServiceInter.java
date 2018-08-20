package com.ktds.customer.service;

import java.util.List;

import com.ktds.customer.vo.Customer;

public interface CustomerServiceInter {
	
	public List<Customer> findAllCustomers();
	public Customer findOneCustomer(String phone);
	public boolean registOneCustomer(Customer customer);
	
}
