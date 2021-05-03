package com.cg.go.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.go.dao.IOrderDaoInterface;
import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.entity.UserEntity;
import com.cg.go.exception.OrderException;
import com.cg.go.service.IOrderService;

@SpringBootTest
public class OrderTest {
	@Autowired
	IOrderService service;
	
	@MockBean
	IOrderDaoInterface order;
	
	@AfterAll
	static void tearDownAfterClass() throws Exception{
		
	}
	@AfterEach
	void tearDown() throws OrderException{
		System.out.println("Clean up complete");
	}
	
	
	//Add Test Case
	@Test
	void testAddOrder() throws OrderException{
		ProductEntity p1=new ProductEntity("123","santoor",245.00,"imagee","red","essentials",2,"venu","childcare");
        UserEntity u=new UserEntity("venu","1","customer","9014475650");
		OrderEntity o=new OrderEntity("123",u,p1,2.0,980l,LocalDate.now(),LocalDate.now());
		when(order.save(o)).thenReturn(o);
		assertEquals(o, service.addOrder(o));
	}
	
	
    //FindAll Test Case
	@Test
	void testfindAllOrders() {
		ProductEntity p1=new ProductEntity("123","santoor",245.00,"imagee","red","essentials",2,"venu","childcare");
	ProductEntity p2=new ProductEntity("124","santor",245.00,"imagee","red","essentials",2,"venu","childcare");
	List<ProductEntity>p= new ArrayList<>();
	p.add(p2);
	p.add(p1);
        assertEquals(2,p.size());
	}
	
	
	//Delete All Orders Test Case
	@Test
	void testDeleteAllOrders()throws OrderException{
		doNothing().when(order).deleteAll(Mockito.any());
	}
	
	
	//UpdateDate Test Case
	@Test
	void testUpdateDate()throws OrderException{
		OrderEntity o= new OrderEntity();
		o.setOrderId("1233");
		o.setDispatchDate(LocalDate.now());
		o.setDeliveryDate(LocalDate.now());
		if(order.existsById(o.getOrderId())) {
		when(order.save(o)).thenReturn(o);
		assertEquals(o, service.updateDate(o));
		}
	}
	
	// Delete Order By Id Test Case
   /* @Test
	void testDeleteOrderById()throws OrderException{
		OrderEntity o=new OrderEntity();
		o.setOrderId("100");
		String k=o.getOrderId();
		Optional<OrderEntity> patient1=Optional.ofNullable(OrderEntity);
		when(order.findById(k)).thenReturn();
	}*/


}
