package com.cg.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.CustomerEntity;

@Repository
public interface CustomerDAOInterface extends JpaRepository <CustomerEntity, Long>{

}
