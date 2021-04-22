package com.cg.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.OrderEntity;

@Repository
public interface IOrderDaoInterface extends JpaRepository<OrderEntity, String> {
   // @Query("select t from Order t where t.userId=?1 ")
   //List<OrderEntity> findOrderByUId(String k);

}
