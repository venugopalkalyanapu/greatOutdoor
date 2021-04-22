package com.cg.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.dao.ProductDAOInterface;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;
import com.cg.go.exception.ProductException;
import com.cg.go.service.ICartServiceInterface;

@RestController
public class ICartController {
	@Autowired
	private ICartServiceInterface ics;
	@Autowired
	private ProductDAOInterface ipd;
	//Add To Cart
	@PostMapping(value="addCart")
	public CartItemEntity addCartItem(@RequestBody CartItemEntity ppp) throws CartException, ProductException
	{
		CartItemEntity c=ics.addCartItem(ppp);
		return c;
	}

	@PutMapping("updateCart")
	public CartItemEntity updateCart(@RequestBody CartItemEntity c) {

		CartItemEntity k=ics.updateCart(c);
		return k;
	}



	/*@GetMapping("findCartItem/{pid}")
 public CartItemEntity findCartItem(@PathVariable("pid") String p, @PathVariable("uid") String u) {
	CartItemEntity cc=ics.findCartItem(p,u);

	return cc;
	//return ics.findCartItem(s);
}*/




	@DeleteMapping("deleteCart/{Id}")
	public String updateCart(@PathVariable("Id") Long s) {
		CartItemEntity c=new CartItemEntity();
		c.setCartId(s);
		String p= ics.deleteCart(c);
		return p;
	}




	@GetMapping("findCartList/{cartid}")
	public List<CartItemEntity> findCartList(@PathVariable("cartid") String s){

		List<CartItemEntity> k= ics.findCartList(s);

		return k;
	}
}
