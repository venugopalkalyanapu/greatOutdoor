package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.CustomerDAOInterface;
import com.cg.go.entity.CustomerEntity;


@Service
public class CustomerService implements CustomerServiceInterface {
	@Autowired
	public CustomerDAOInterface cd;

	
	public CustomerEntity viewCustomer(String ci) {
		//String a = ci.getCustomerId();
		Optional<CustomerEntity> oo= cd.findById(ci);
		CustomerEntity cc = oo.get();
		return cc;
	}
	
	
	public CustomerEntity addCustomerService(CustomerEntity ee) {
		return cd.save(ee);
	}

	
	public CustomerEntity updateCustomer(CustomerEntity cc) {
		return cd.save(cc);		
	}

	public String removeCustomer(CustomerEntity c1) {
		 cd.deleteById(c1.getCustomerId());
		return "Customer details deleted!";
		
	}

	@Override
	public List<CustomerEntity> getAllCustomersService() {
		List<CustomerEntity> list=new ArrayList<>();
		cd.findAll().forEach(list1->list.add(list1));
		return list;
	}
}