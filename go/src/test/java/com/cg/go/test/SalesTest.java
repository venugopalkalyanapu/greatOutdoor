package com.cg.go.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.go.dao.SalesReportDAOinterface;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;
import com.cg.go.service.SalesReportService;


@SpringBootTest
class SalesTest {
	@Autowired
	SalesReportService service;
	
	@MockBean
	SalesReportDAOinterface sale;

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws SalesReportException {
		System.out.println("Clean up complete");
	}
	
	//Add Report Test Case
	@Test
	void testAddReport() throws SalesReportException {
		SalesReportEntity sales = new SalesReportEntity(110,"101","Mobile", 75,50000);
		when(sale.save(sales)).thenReturn(sales);
		String s = service.addSalesReport(sales);
		assertEquals("Sales Report created", s);
	}
	
	//Find All Report Test Case
	@Test
	void testfindAllSalesReport() {
		when(sale.findAll()).thenReturn(Stream.of(new SalesReportEntity(110,"101","Mobile", 75,50000)).collect(Collectors.toList()));
		assertEquals(1,service.findAllSalesReport().size());
		System.out.println("Printing all Sales Report");
	}
	
	//Delete All Reports Test Case
	@Test
	void testdeleteAllSalesReport() throws SalesReportException {
		doNothing().when(sale).deleteAll(Mockito.any());
	}
	
	//Update Reports Test Case
	@Test
	void testupdateProductReport() throws SalesReportException {
		SalesReportEntity sales = new SalesReportEntity(102,"101","Mobile", 75,50000);
		Optional<SalesReportEntity> sa=Optional.ofNullable(sales);
		when(sale.findById((long) 102)).thenReturn(sa);
		sales.setProductName("Iphone");
		when(sale.save(sales)).thenReturn(sales);
		assertEquals(sales, service.updateProductReport(sales));
		System.out.println(" Account updated successfully");
	}
	
	//Delete Report By Id Test Case
	@Test
	void testdeleteSalesReportByIdException() throws SalesReportException{
		long number = 10;
		assertThrows(SalesReportException.class, () -> service.deleteSalesReportById(number));
	}

	//Find Report By Id Test Case
	@Test
	void testfindSalesReportByProductId() {
		SalesReportEntity sales = new SalesReportEntity(110,"101","Mobile", 75,50000);
		when(sale.findAllById("101")).thenReturn(sales);
		assertEquals(sales,service.findSalesReportByProductId("101"));
	}
	
}