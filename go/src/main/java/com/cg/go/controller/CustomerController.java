package com.cg.go.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.CustomerEntity;
import com.cg.go.service.CustomerServiceInterface;

@RestController
	public class CustomerController {
		
		@Autowired
		private CustomerServiceInterface si;
		
		@PostMapping("addCustomer")
		public CustomerEntity addCustomer(@RequestBody CustomerEntity ee) {
			return si.addCustomerService(ee);
			}
		@GetMapping("viewCustomer/{id}")
		public CustomerEntity viewCustomer(@PathVariable ("id") String ci) {
			return si.viewCustomer(ci);
		}
		
		@PutMapping("updateCustomer/{id}")
		public CustomerEntity updateCUstomer(@PathVariable ("id") String ss,@RequestBody CustomerEntity cc) {
			return si.updateCustomer(cc);
		}
		@DeleteMapping("removeCustomer/{id}")
		public String removeCustomer(@PathVariable ("id") String ss) {
			CustomerEntity c1 = new CustomerEntity();
			c1.setCustomerId(ss);
			return si.removeCustomer(c1);
		}

		@GetMapping("getAllCustomers")
		public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> cl=new ArrayList<CustomerEntity>();
		cl=si.getAllCustomersService();
		return cl;
		}

}
