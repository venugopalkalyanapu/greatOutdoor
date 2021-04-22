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

import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.service.GrowthReportServiceInterface;

@RestController
public class GrowthReportController {
	@Autowired
	private GrowthReportServiceInterface gi;
	@GetMapping("findall")
	List<GrowthReportEntity> findAllGrowthReport(){
		List<GrowthReportEntity> li = new ArrayList<GrowthReportEntity>();
		li=gi.findAllGrowthReport();
		return li;
	}
	@PostMapping("addReport")
		void addGrowthReport(@RequestBody GrowthReportEntity g) throws GrowthReportException{
		gi.addGrowthReport(g);
	}
	@DeleteMapping("deleteAll")
	String deleteAllGrowthReport() throws GrowthReportException {
		String s = gi.deleteAllGrowthReport();
		return s;
	}
	@DeleteMapping("deletebyId/{growthReportId}")
	String deleteGrowthReportById(@PathVariable("growthReportId") Long growthReportId) throws GrowthReportException {
		String s = gi.deleteGrowthReportById(growthReportId);
		return s;
	}
}