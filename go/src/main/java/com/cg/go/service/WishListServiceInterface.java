package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;



public interface WishListServiceInterface {

	
	List<WishlistItemEntity> findAllItems();



	void deleteWishlistByUserId(Long wid) throws WishlistException;




//	List<WishlistItemEntity> readWishList(String userId);


	List<WishlistItemEntity> findWishlist(Long wish);


	//List<WishlistItemEntity> findWishlistItem(String productId, String userId) throws WishlistException;

	//void deleteBywishlistitem(String productId,String userId) throws WishlistException;

	WishlistItemEntity addWishlistItem(WishlistItemEntity w);



	void deleteAll() throws WishlistException;
	

}
