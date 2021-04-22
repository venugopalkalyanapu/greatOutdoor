package com.cg.go.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.ICartDaoInterface;
import com.cg.go.dao.ProductDAOInterface;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;

@Service
public class ICartService implements ICartServiceInterface {
    @Autowired
    private ICartDaoInterface icd;
    @Autowired
    private ProductDAOInterface ipd;

	@Override
	public CartItemEntity addCartItem(CartItemEntity cr) throws CartException{
		System.out.println(cr.getProducts());
		CartItemEntity c=icd.save(cr);
		return c;
	}
	
	@Override
	public CartItemEntity updateCart(CartItemEntity c) {
	
		CartItemEntity g=icd.save(c);
		return g;
	}

	
	
	
	

	@Override
	public java.util.List<CartItemEntity> findCartList(String s) {
		return icd.findCartList(s);
	
	}

	
	
	
/*	@Override
	public CartItemEntity findCartItem(String s,String u) {
		  return icd.findCartItem(s,u);
		
		 //return null;
		//return icd.findCartItem(s);
		
	}*/

	
	
	
	@Override
	public String deleteCart(CartItemEntity c) {
		Long k= c.getCartId();
		if(icd.existsById(k)) {
	    icd.deleteById(k);
	    return "Cart Deleted successfully";
		}
		return "Not found";
	}


}
