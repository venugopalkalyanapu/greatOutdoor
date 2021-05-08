package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.SaleEntity;
import com.cg.go.exception.SalesReportException;


public interface SalesReportServiceInterface {
	List<SaleEntity> findAllSalesReport();

	String deleteAllSalesReport();

	String deleteSalesReportById(Long id) throws SalesReportException;

	SaleEntity findSalesReportByProductId(Long id);

	SaleEntity updateSalesReport(SaleEntity s) throws SalesReportException;

	String addSalesReport(SaleEntity s);
}
