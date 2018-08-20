package com.ktds.customer.controller;

import java.util.List;

import com.ktds.customer.service.CustomerService;
import com.ktds.customer.service.CustomerServiceInter;
import com.ktds.customer.vo.Customer;
import com.ktds.utils.Common;

public class CustomerController {

	private CustomerServiceInter customerService;
	
	public void setCustomerService(CustomerServiceInter customerService) {
		this.customerService = customerService;
	}

	public boolean registOneCustomer() {
		
		System.out.println("고객 등록 프로세스");
		
		System.out.print("고객의 연락처를 입력하세요.");
		String phone = Common.INPUT.next();
		
		System.out.print("고객의 이름을 입력하세요.");
		String name = Common.INPUT.next();
		
		System.out.print("고객의 주소를 입력하세요.");
		String address = Common.INPUT.nextLine();
		
		Customer customer = new Customer(phone, name, address);
		
		return this.customerService.registOneCustomer(customer);
		
	}
	
	public void printAllCustomers() {
		System.out.println("고객 전체 조회 프로세스");
		
		List<Customer> customerList = 
				this.customerService.findAllCustomers();
		
		for (Customer customer : customerList) {
			System.out.println("========================");
			System.out.println("고객의 연락처 : " + customer.getPhone());
			System.out.println("고객의 이름 : " + customer.getName());
			System.out.println("고객의 주소 : " + customer.getAddress());
		}
	}
	
	public void printOneCustomer() {
		System.out.println("고객 조회 프로세스");
		
		System.out.println("고객의 연락처를 입력하세요.");
		String phone = Common.INPUT.next();
		
		Customer customer = 
				this.customerService.findOneCustomer(phone);
		
		System.out.println("========================");
		System.out.println("고객의 연락처 : " + customer.getPhone());
		System.out.println("고객의 이름 : " + customer.getName());
		System.out.println("고객의 주소 : " + customer.getAddress());
	}
}










