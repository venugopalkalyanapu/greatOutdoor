package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;

public interface GrowthReportServiceInterface {

	List<GrowthReportEntity> findAllGrowthReport();

	GrowthReportEntity addGrowthReport(GrowthReportEntity g) throws GrowthReportException;

	String deleteAllGrowthReport() throws GrowthReportException;

	String deleteGrowthReportById(Long growthReportId) throws GrowthReportException;

}
