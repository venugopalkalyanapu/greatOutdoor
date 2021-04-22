package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.CustomerEntity;

public interface CustomerServiceInterface {
	CustomerEntity viewCustomer(String ci);

	CustomerEntity addCustomerService(CustomerEntity ee);

	CustomerEntity updateCustomer(CustomerEntity cc);

	String removeCustomer(CustomerEntity c1);

	List<CustomerEntity> getAllCustomersService();

}
