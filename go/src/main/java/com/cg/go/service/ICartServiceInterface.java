package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;


public interface ICartServiceInterface {

	CartItemEntity addCartItem(CartItemEntity cr)throws CartException;

	public CartItemEntity updateCart(CartItemEntity c);

	public List<CartItemEntity> findCartList(Long s);

	public String deleteCart(CartItemEntity c);

	List<CartItemEntity> findAll();
	
	//public CartItemEntity findCartItem(String s,String u);
}
