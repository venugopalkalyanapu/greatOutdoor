package com.cg.go.service;

import java.util.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.SalesReportDAOinterface;
import com.cg.go.entity.SaleEntity;
import com.cg.go.exception.SalesReportException;



@Service
public class SalesReportService implements SalesReportServiceInterface{
    
	@Autowired
	private SalesReportDAOinterface SalesDAO;
	
	// Find All Sales Reports
	
	@Override
	public List<SaleEntity> findAllSalesReport() {
		List<SaleEntity> list=new ArrayList<>();
		SalesDAO.findAll().forEach(list1->list.add(list1));
		return list;
	}
	
	// Find Sales Report by ProductId
	
		@Override
		public SaleEntity findSalesReportByProductId(Long id) {
		    
		    Optional<SaleEntity> sa = SalesDAO.findById(id);
			return sa.get();
		}
		
	
	// Delete All Sales Reports
	
	@Override
	public String deleteAllSalesReport(){
	    SalesDAO.deleteAll();
		return "All sales Reports deleted";
	}
	
	// Delete Sales Report by Id
	
	@Override
	public String deleteSalesReportById(Long id) throws SalesReportException{
		if(!SalesDAO.existsById(id))
			throw new SalesReportException(id+" does not exist to delete");
			System.out.println("err");
		SalesDAO.deleteById(id);
		return id+" deleted";		
	}
	
	
	// Update Sales Reports
	
	@Override
	public SaleEntity updateSalesReport(SaleEntity s) throws SalesReportException{
		Long id = s.getId();
		Optional<SaleEntity> sa = SalesDAO.findById(id);
		if(!sa.isPresent())
			throw new SalesReportException(id+" does not exist to update");
		return SalesDAO.save(s);
	}
	
	// Add Sales Report
	
	@Override
	public String addSalesReport(SaleEntity s) {
	    SalesDAO.save(s);
		return "Sales Report created";
	}

}