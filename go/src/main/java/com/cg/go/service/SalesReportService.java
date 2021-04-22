
package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.SalesReportDAOinterface;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;
@Service
public class SalesReportService implements SalesReportServiceInterface{
	@Autowired
	private SalesReportDAOinterface sd;
	@Override
	public List<SalesReportEntity> findAllSalesReport() {
		List<SalesReportEntity> list=new ArrayList<>();
		sd.findAll().forEach(list1->list.add(list1));
		return list;
	}
	@Override
	public String deleteAllSalesReport(){
		sd.deleteAll();
		return "All sales reports deleted";
	}
	@Override
	public String deleteSalesReportById(Long salesReportId)throws SalesReportException {
		if(!sd.existsById(salesReportId))
			throw new SalesReportException(salesReportId+" does not exist to delete");
		sd.deleteById(salesReportId);
		return salesReportId+" deleted";
		
	}
	@Override
	public SalesReportEntity findSalesReportByProductId(String productId) {
		return sd.findAllById(productId);	
	}
	
	@Override
	public SalesReportEntity updateProductReport(SalesReportEntity s) throws SalesReportException{
		Long id = s.getSalesReportId();
		Optional<SalesReportEntity> sa = sd.findById(id);
		if(!sa.isPresent())
			throw new SalesReportException(id+" does not exist to update");
		return sd.save(s);
	}
	@Override
	public String addSalesReport(SalesReportEntity s) {
		sd.save(s);
		return "Sales Report created";
	}
}