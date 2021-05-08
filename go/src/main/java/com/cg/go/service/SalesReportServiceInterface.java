package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;


public interface SalesReportServiceInterface {
	List<SalesReportEntity> findAllSalesReport();

	String deleteAllSalesReport();

	String deleteSalesReportById(Long id) throws SalesReportException;

	SalesReportEntity findSalesReportByProductId(Long id);

	SalesReportEntity updateSalesReport(SalesReportEntity s) throws SalesReportException;

	String addSalesReport(SalesReportEntity s);
}
