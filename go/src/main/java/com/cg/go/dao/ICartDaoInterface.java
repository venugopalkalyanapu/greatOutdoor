package com.cg.go.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.CartItemEntity;


@Repository
public interface ICartDaoInterface extends JpaRepository<CartItemEntity, Long> {

	//Finding cart list
	//@Query("select k from CartItemEntity k where k.userId=?1")
	//public List<CartItemEntity> findCartList(String s);

	//finding cart Item
	//@Query("select k from CartItemEntity k where k.userId=?1" )
	//public CartItemEntity findCartListById(String s);




	// @Query("select t from CartItemEntity t where t.userId=?2 and CONCAT(t.productId)LIKE %?1%\"")
	// public CartItemEntity findCartItem(String s,String u);

}
