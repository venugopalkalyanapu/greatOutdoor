package com.cg.go.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;
import com.cg.go.service.WishListServiceInterface;

@RestController
public class WishListController {
	@Autowired
	private WishListServiceInterface ws;
	

	@GetMapping("findAllItems")
	public List<WishlistItemEntity> findAllItems() {
		List<WishlistItemEntity> ll = new ArrayList<WishlistItemEntity>();
		ll = ws.findAllItems();
		return ll;
	}

	@PostMapping("addproductstowishlist")
	public WishlistItemEntity addWishlistItem(@RequestBody WishlistItemEntity w) {
		WishlistItemEntity o = ws.addWishlistItem(w);
		return o;
	}

	@GetMapping("findwishlist/{wishlistid}")
	public List<WishlistItemEntity> findWishlist(@PathVariable("wishlistid") Long wishlistid) {
		//WishlistItemEntity wish=new WishlistItemEntity();
		//wish.setWishlistId(wishlistid);
		 List<WishlistItemEntity> products=ws.findWishlist(wishlistid);
		return products;

	}
	
 
	
	@DeleteMapping("deletewishlist/{wid}")
	public void deleteWishlistByUserId(@PathVariable("wid") Long wid) throws WishlistException {
		ws.deleteWishlistByUserId(wid);
	}
	
	@DeleteMapping("deleteAllWishList")
	public void deleteAll() throws WishlistException {
		ws.deleteAllWishlist();
	}
	

	
	 /* @GetMapping("findWishlistItem/{productId}/{userId}")
	  public List<WishlistItemEntity> findWishlistItem(@PathVariable String productId,@PathVariable String userId) throws WishlistException {
	  WishlistItemEntity wish=new WishlistItemEntity();
	  
	  List<WishlistItemEntity> w2 = new ArrayList<WishlistItemEntity>(); 
	  return w2=ws.findWishlistItem(productId,userId);
	  
	  }*/
	
	 /* @DeleteMapping("deleteWishlistItem/{productId}/{userId}")
	  public void deleteBywishlistitem(@PathVariable String productId, @PathVariable String userId) throws WishlistException {
	  
	  ws.deleteBywishlistitem(productId, userId);
	  
	  }*/
	 
	
	

}
