package com.cg.go.service;

import java.util.List;
import java.util.Optional;



import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.WishListDaoInterface;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;


@Service
public class WishListService implements WishListServiceInterface{
	
	@Autowired
	private WishListDaoInterface wd;

	@Override
	public List<WishlistItemEntity> findAllItems() {
		List<WishlistItemEntity> list=new ArrayList<>();
		wd.findAll().forEach(list1->list.add(list1));
		return list;
		
	}
	
	
	
	
	@Override
	public List<WishlistItemEntity> findWishlist(Long wish) {
		
		Optional<WishlistItemEntity> k=wd.findById(wish);
		WishlistItemEntity l=k.get();
		List<WishlistItemEntity> list=new ArrayList<>();
		list.add(l);
		return list;
	}
	 

	
	@Override
	public void deleteWishlistByUserId(Long wid) throws WishlistException {
		
		Optional<WishlistItemEntity> k=wd.findById(wid);
		WishlistItemEntity l=k.get();
			if(l.equals(null)) {
				throw new WishlistException("Unable to find items in wishlist to delete");
			}
			wd.deleteById(wid);
			
		
		
	}
	
	
	
	
	/*  @Override
	  public List<WishlistItemEntity> findWishlistItem(String productId, String userId) throws WishlistException {
	  List<WishlistItemEntity> w3=new ArrayList<WishlistItemEntity>();
	  
	  List<WishlistItemEntity> w2= wd.findAll();
	  for(WishlistItemEntity w1:w2) {
		  if(!w1.getUserId().equalsIgnoreCase(userId)) {
			  throw new WishlistException("Unable to find without productId and userId");
		  }
		  w3=wd.findAllById(w1.getUserId());
	  }
		  
	  
	  
	  
	  return w3;
	  }*/
	 

	
	

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity w) {
		
		WishlistItemEntity o=wd.save(w);
		return o;
	}




	@Override
	public void deleteAll() throws WishlistException {
		
		if(wd.findAll().isEmpty()) {
			throw new WishlistException("There are no items in wishlist to delete");
			
		}
		wd.deleteAll();
		
	}


	
	/*  @Override public void deleteBywishlistitem(String productId,String userId) throws WishlistException {
	  
		  List<WishlistItemEntity> w2= wd.findAll();
		  for(WishlistItemEntity w1:w2) {
			  if(!w1.getUserId().equals(w2)) {
				  throw new WishlistException("Unable to delete without productId and userId");
			  }
			  wd.deleteById(w1.getWishlistId());
		  }
	  
	  }*/
	 
	 



	
	  
	 
	
	 
	 
	
	
	
	


}