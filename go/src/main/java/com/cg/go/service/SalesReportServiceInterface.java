package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;

public interface SalesReportServiceInterface {

	List<SalesReportEntity> findAllSalesReport();

	String deleteAllSalesReport();

	String deleteSalesReportById(Long salesReportId) throws SalesReportException;

	SalesReportEntity findSalesReportByProductId(String productId);

	SalesReportEntity updateProductReport(SalesReportEntity s) throws SalesReportException;

	String addSalesReport(SalesReportEntity s);

}