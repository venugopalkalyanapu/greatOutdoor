package com.cg.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.GrowthReportEntity;

@Repository
public interface GrowthReportDAOinterface extends JpaRepository<GrowthReportEntity, Long>{

}