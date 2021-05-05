package com.cg.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;
import com.cg.go.service.ICartServiceInterface;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ICartController {
	@Autowired
	private ICartServiceInterface ics;


	//Add To Cart
	@PostMapping(value="addCart")
	public CartItemEntity addCartItem(@RequestBody CartItemEntity ppp) throws CartException
	{
		CartItemEntity c=ics.addCartItem(ppp);
		return c;
	}


	//Update Cart
	@PutMapping("updateCart")
	public CartItemEntity updateCart(@RequestBody CartItemEntity c) {
		CartItemEntity k=ics.updateCart(c);
		return k;
	}


	//Delete Cart by using CartId
	@DeleteMapping("deleteCart/{cid}")
	public String updateCart(@PathVariable("cid") Long s) {
		CartItemEntity c=new CartItemEntity();
		c.setCartId(s);
		String p= ics.deleteCart(c);
		return p;
	}


	//Find CartList using CartId
	@GetMapping("findCartList/{cartid}")
	public List<CartItemEntity> findCartList(@PathVariable("cartid") Long s){

		List<CartItemEntity> k= ics.findCartList(s);

		return k;
	}

	@GetMapping("/findAll")
	public List<CartItemEntity> findAll(){
		return ics.findAll();
	}
	/*@GetMapping("findCartItem/{pid}")
    public CartItemEntity findCartItem(@PathVariable("pid") String p, @PathVariable("uid") String u) {
	CartItemEntity cc=ics.findCartItem(p,u);

	return cc;
	//return ics.findCartItem(s);
    }*/
}
