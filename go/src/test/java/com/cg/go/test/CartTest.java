package com.cg.go.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.go.dao.ICartDaoInterface;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.entity.UserEntity;
import com.cg.go.exception.CartException;
import com.cg.go.exception.OrderException;
import com.cg.go.exception.ProductException;
import com.cg.go.service.ICartService;

@SpringBootTest
public class CartTest {
	@Autowired
	ICartService ics;
	@MockBean
	ICartDaoInterface icd;
	@AfterAll
	static void tearDownAfterClass() throws Exception{

	}
	@AfterEach
	void tearDown() throws OrderException{
		System.out.println("Clean up complete");
	}

	//Add Cart Test case
	@Test
	void testAddCart() throws ProductException, CartException{
		ProductEntity p1=new ProductEntity(123,"santoor",245.00,"imagee","red","essentials",2,"venu","childcare");
		UserEntity u=new UserEntity("venu","1","customer","9014475650");
		
		CartItemEntity cr=new CartItemEntity(123l,u,432.00,1299l,p1);
		when(icd.save(cr)).thenReturn(cr);
		assertEquals(cr, ics.addCartItem(cr));
	}
	
	//UpdateCart TestCase
	@Test
	void testUpdateCart() {
		ProductEntity p1=new ProductEntity(123,"santoor",245.00,"imagee","red","essentials",2,"venu","childcare");
		ProductEntity p2=new ProductEntity(124,"santor",245.00,"imagee","red","essentials",2,"venu","childcare");
		UserEntity u=new UserEntity("venu","1","customer","9014475650");
		List<ProductEntity> p=new ArrayList<>();
		p.add(p1);
		p.add(p2);
		CartItemEntity cr=new CartItemEntity(123l,u,432.00,1299l,p1);
		when(icd.save(cr)).thenReturn(cr);
		assertEquals(cr, ics.updateCart(cr));
	}
	
	/*//findCartList Test Case
	void testFindCartList()throws CartException{
		ProductEntity p1=new ProductEntity("123","santoor",245.00,"imagee","red","essentials",2,"venu","childcare");
		List<ProductEntity> p=new ArrayList<>();
		p.add(p1);
		CartItemEntity cr=new CartItemEntity(123l,"venu",432.00,1299l,p);
	   
		
	}*/
	
	//DeleteById Test Case
	/*@Test
	void testDeleteById() {
		CartItemEntity c=new CartItemEntity();
		c.setCartId(123);
		icd.deleteById(c.getCartId());
		Iterable<CartItemEntity> k=icd.findAll();
		asserThat(k).hasSize(2).contains(c);
        		
	}*/
	


}
