package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;
import com.cg.go.exception.ProductException;

public interface ICartServiceInterface {

	CartItemEntity addCartItem(CartItemEntity cr)throws CartException, ProductException;

	public CartItemEntity updateCart(CartItemEntity c);

	public List<CartItemEntity> findCartList(String s);

	//public CartItemEntity findCartItem(String s,String u);

	public String deleteCart(CartItemEntity c);
}
