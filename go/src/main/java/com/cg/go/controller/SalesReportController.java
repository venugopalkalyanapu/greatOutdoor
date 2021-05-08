package com.cg.go.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.SaleEntity;
import com.cg.go.exception.SalesReportException;

import com.cg.go.service.SalesReportServiceInterface;
@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/")
@RestController
public class SalesReportController {
	@Autowired
	private SalesReportServiceInterface SalesInterface;
	
	
	// Find All Sales Reports
	
	@GetMapping("/FindAllSalesReports")
        public List<SaleEntity> findAllSalesReport(){
        	List<SaleEntity> list = new ArrayList<SaleEntity>();
        	list = SalesInterface.findAllSalesReport();
        	return list;
        }
	
	// Find Sales Report by ProductId
	
	@GetMapping("/FindSalesReportbyProductId/{id}")
	SaleEntity findSalesReportByProductId(@PathVariable("id") Long id) {
	    SaleEntity sr = SalesInterface.findSalesReportByProductId(id);
	    return sr;
	}
	
	// Update Sales Reports
	
//	@PostMapping("/UpdateSalesReports")
//	void updateSalesReport(@RequestBody SaleEntity s) throws SalesReportException{
//	    SalesInterface.updateSalesReport(s);
//	}
//	
	// Delete All Sales Reports
	
	@DeleteMapping("/DeleteAllSalesReports")
	String deleteAllSalesReport(){
	    String s = SalesInterface.deleteAllSalesReport();
	    return s;
	}
	
	// Delete Sales Report by Id
	
	@DeleteMapping("/DeleteSalesReportbyId/{id}")
	String deleteSalesReportById(@PathVariable("id") Long id) throws SalesReportException{
	    String sa = SalesInterface.deleteSalesReportById(id);
	    return sa;
	}
	// Add Sales Report
	
	
		@PostMapping("/AddSalesReport")
		public String addSalesReport(@RequestBody SaleEntity s) {
			String str = SalesInterface.addSalesReport(s);
			return str;
		}
		
}