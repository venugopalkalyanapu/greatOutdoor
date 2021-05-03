package com.cg.go.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.go.dao.GrowthReportDAOinterface;
import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.service.GrowthReportService;


@SpringBootTest
class GrowthTest {
	@Autowired
	GrowthReportService service;

	@MockBean
	GrowthReportDAOinterface growth;

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws GrowthReportException {
		System.out.println("Clean up complete");
	}
	
	//Add Report Test Case
	@Test
	void testAddReport() throws GrowthReportException {
		GrowthReportEntity g1 = new GrowthReportEntity(1004,LocalDate.now(),55000,5500,5.5,"black");
		when(growth.save(g1)).thenReturn(g1);
		assertEquals(g1, service.addGrowthReport(g1));
	}
	
	//Find All Report Test Case
	@Test
	void testfindAllGrowthReport() {
		when(growth.findAll()).thenReturn(Stream.of(new GrowthReportEntity(1004,LocalDate.now(),55000,5500,5.5,"black")).collect(Collectors.toList()));
		assertEquals(1,service.findAllGrowthReport().size());
		System.out.println("Printing all growth report details");
	}
	
	//Delete Report Test Case
	@Test
	void testdeleteGrowthReportByIdException() throws GrowthReportException{
		long number = 100;
		assertThrows(GrowthReportException.class, () -> service.deleteGrowthReportById(number));
	} 
	
	//Delete All Reports Test Case
	@Test
	void testdeleteAllGrowthReport() throws GrowthReportException {
		doNothing().when(growth).deleteAll(Mockito.any());

	}
	/*	@Test
	void testdeleteGrowthReportById() throws GrowthReportException{
	GrowthReportEntity entity = new GrowthReportEntity(1003,LocalDate.now(),55000,5500,5.5,"black");
	System.out.println(entity);
	long id = entity.getGrowthReportId();
	Optional<GrowthReportEntity> og = Optional.ofNullable(entity);
	when(growth.findById(id)).thenReturn(og);
		assertEquals("No Growth Report is present with "+id,service.deleteGrowthReportById(id));
	} */
}