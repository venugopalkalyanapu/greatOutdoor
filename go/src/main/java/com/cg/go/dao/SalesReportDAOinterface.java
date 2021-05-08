package com.cg.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.SaleEntity;



@Repository
public interface SalesReportDAOinterface extends JpaRepository<SaleEntity, Long>{
    
    	// Find SalesReport by Product Id
//    
//	@Query("Select s from SaleEntity s where s.productId =?1")
//	SaleEntity findAllById(String productId);
}