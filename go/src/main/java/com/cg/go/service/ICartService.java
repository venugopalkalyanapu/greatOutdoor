package com.cg.go.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.ICartDaoInterface;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;

@Service
public class ICartService implements ICartServiceInterface {
	@Autowired
	private ICartDaoInterface icd;

	
	//AddCart Item
	@Override
	public CartItemEntity addCartItem(CartItemEntity cr) throws CartException{
		
		if(cr==null) {
			throw new CartException("cart Not Found");
		}
		else {
		CartItemEntity c=icd.save(cr);
		return c;
		}
	}

	
	//Update Cart Item
	@Override
	public CartItemEntity updateCart(CartItemEntity c) {
		CartItemEntity g=icd.save(c);
		return g;
	}


	//finding cartList
	@Override
	public java.util.List<CartItemEntity> findCartList(Long s) {
		Optional<CartItemEntity> k= icd.findById(s);
		CartItemEntity g= k.get();
		List<CartItemEntity> p=new ArrayList<>();
		p.add(g);
		return p;
		
	}


	//delete Cart Item
	@Override
	public String deleteCart(CartItemEntity c) {
		long k=c.getCartId();
		if(icd.existsById(k)) {
			icd.deleteById(k);
			return "Cart Deleted successfully";
		}
		return "Not found";
	}


	@Override
	public List<CartItemEntity> findAll() {
		return icd.findAll();
		
	}


	/*	@Override
	public CartItemEntity findCartItem(String s,String u) {
		  return icd.findCartItem(s,u);

		 //return null;
		//return icd.findCartItem(s);

	}*/

}
