package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.GrowthReportDAOinterface;
import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
@Service
public class GrowthReportService implements GrowthReportServiceInterface {
	@Autowired
	private GrowthReportDAOinterface gd;
	
	public List<GrowthReportEntity> findAllGrowthReport() {
		List<GrowthReportEntity> list=new ArrayList<>();
		gd.findAll().forEach(list1->list.add(list1));
		return list;	
	}
	@Override
	public GrowthReportEntity addGrowthReport(GrowthReportEntity g)throws GrowthReportException{
		Long id = g.getGrowthReportId();
		if(gd.existsById(id))
			throw new GrowthReportException("Report already exists");
		return gd.save(g);
			
	}
	@Override
	public String deleteAllGrowthReport()throws GrowthReportException{
		if(gd.count()==0)
				throw new GrowthReportException("Nothing to delete. Report table is empty");
		gd.deleteAll();
		return "All reports deleted";
	}
	@Override
	public String deleteGrowthReportById(Long growthReportId) throws GrowthReportException{
		if(!gd.existsById(growthReportId))
			throw new GrowthReportException("No Growth Report is present with "+growthReportId);
		gd.deleteById(growthReportId);
		return growthReportId+" deleted";
	}
}