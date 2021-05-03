package com.cg.go.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.cg.go.dao.CustomerDAOInterface;
import com.cg.go.entity.*;
import com.cg.go.service.CustomerService;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	CustomerService service;
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Clean up!");
	}
	
	
	@MockBean
	private CustomerDAOInterface dao;
	
	private CustomerEntity customer1;
	
	
	//Test case for adding customer details 
	@Test
	public void testAddCustomer()  {
		
		customer1 = new CustomerEntity("2","raj kumar", "8466064954","raj@gmail.com",
				new AddressEntity("111","1","Veerannapet","Veerannapet","Mahabubnagar","Telangana","509001"));
		Mockito.when(dao.save(customer1)).thenReturn(customer1);
		CustomerEntity result = service.addCustomerService(customer1);
		assertEquals(result.getCustomerId(), customer1.getCustomerId());
	}

	
	//Method to return/ view the  customer details
	public CustomerEntity viewCustomer(){
		CustomerEntity testCustomer=new CustomerEntity("2","raj kumar", "8466064954","raj@gmail.com",
				new AddressEntity("111","1","Veerannapet","Veerannapet","Mahabubnagar","Telangana","509001"));
		return testCustomer;
	}
	//Test case for viewing customer details
	@Test  
	void testViewCustomer() {
			CustomerEntity customer=viewCustomer();
			Mockito.when(dao.save(customer)).thenReturn(customer);
			dao.findById(customer.getCustomerId());
			verify(dao,times(1)).findById(customer.getCustomerId());
		 }
	

	//Method to update the customer details
	public CustomerEntity updateCustomer(){
		CustomerEntity testCustomer= new CustomerEntity("3","Raj Kumar", "8466064954","raj@gmail.com",
				new AddressEntity("111","1","Veerannapet","Veerannapet","Mahabubnagar","Telangana","509001"));
		return testCustomer;
	}
	//Test case for updating customer details
	  @Test  
	  void testUpdateCustomer()  { 
		
		 CustomerEntity testUpdateCustomer = updateCustomer();	
		 
		 Mockito.when(dao.existsById(testUpdateCustomer.getCustomerId())).thenReturn(true);
		 Mockito.when(dao.save(testUpdateCustomer)).thenReturn(testUpdateCustomer);
		 CustomerEntity result = service.updateCustomer(testUpdateCustomer);
		 assertEquals(result.getCustomerId(), testUpdateCustomer.getCustomerId());
	 }
	
	
	  //Method to call the delete customer details 
		 public CustomerEntity deleteCustomer(){
			 CustomerEntity testCustomer= new CustomerEntity("3","Raj Kumar", "8466064954","raj@gmail.com",
						new AddressEntity("111","1","Veerannapet","Veerannapet","Mahabubnagar","Telangana","509001"));
			 return testCustomer;
		 }
		 //Test case to remove the customer details 
		 @Test 
			void testDeleteCustomer() {
			
			    CustomerEntity deleteCustomer = deleteCustomer(); 
				String customerId = deleteCustomer.getCustomerId(); 
				Mockito.when(dao.existsById(customerId)).thenReturn(true);
				service.removeCustomer(deleteCustomer);
				verify(dao, times(1)).deleteById(customerId); 
			  }
	
		 //Test case to get all the customer details
	@Test
	public void testGetAllCustomers() 
	{
		//Here, adding 2 customer details and comparing this size(2) with the size of getAllCustomersservice
		Mockito.when(dao.findAll()).thenReturn(Stream
		.of(new CustomerEntity("2","raj kumar", "8466064954","raj@gmail.com",
			new AddressEntity("111","1","Veerannapet","Veerannapet","Mahabubnagar","Telangana","509001")), 
				new CustomerEntity("2","raj kumar", "8466064954","raj@gmail.com",
					new AddressEntity("111","1","Veerannapet","Veerannapet","Mahabubnagar","Telangana","509001"))).collect(Collectors.toList()));
		assertEquals(2, service.getAllCustomersService().size());
	}
}
