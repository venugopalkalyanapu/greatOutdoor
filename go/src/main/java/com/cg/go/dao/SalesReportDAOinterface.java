package com.cg.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.SalesReportEntity;

@Repository
public interface SalesReportDAOinterface extends JpaRepository<SalesReportEntity, Long>{
	@Query("Select s from SalesReportEntity s where s.productId =?1")
	SalesReportEntity findAllById(String productId);
}