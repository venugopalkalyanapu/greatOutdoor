package com.cg.go.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;
import com.cg.go.service.SalesReportServiceInterface;

@RestController
public class SalesReportController {
	@Autowired
	private SalesReportServiceInterface si;
	
	@PostMapping("addSales")
	public String addSalesReport(@RequestBody SalesReportEntity s) {
		String ss = si.addSalesReport(s);
		return ss;
	}
	
@GetMapping("findAllSales")
public List<SalesReportEntity> findAllSalesReport(){
	List<SalesReportEntity> li = new ArrayList<SalesReportEntity>();
	li=si.findAllSalesReport();
	return li;
}
@GetMapping("findsalesbyproductId/{productId}")
SalesReportEntity findSalesReportByProductId(@PathVariable("productId") String productId) {
	SalesReportEntity sr = si.findSalesReportByProductId(productId);
	return sr;
}
@PostMapping("updatesales")
void updateProductReport(@RequestBody SalesReportEntity s) throws SalesReportException {
	si.updateProductReport(s);
}
@DeleteMapping("deleteAllSales")
String deleteAllSalesReport(){
	String s = si.deleteAllSalesReport();
	return s;
}
@DeleteMapping("deleteSalesById/{salesReportId}")
String deleteSalesReportById(@RequestBody SalesReportEntity s,@PathVariable("salesReportId") Long salesReportId) throws SalesReportException {
	String sa = si.deleteSalesReportById(salesReportId);
	return sa;
}
}