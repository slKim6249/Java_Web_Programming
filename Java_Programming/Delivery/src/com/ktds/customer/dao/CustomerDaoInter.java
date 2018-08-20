package com.ktds.customer.dao;

import java.util.List;

import com.ktds.customer.vo.Customer;

public interface CustomerDaoInter {

	public List<Customer> selectAllCustomer();
	public Customer selectOneCustomer(String phone);
	public int insertOneCustomer(Customer customer);
	
}
