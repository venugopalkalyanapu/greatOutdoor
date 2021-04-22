package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<WishlistItemEntity> findWishlist(String userId) {
		WishlistItemEntity w1 = new WishlistItemEntity();

		List<WishlistItemEntity> list = new ArrayList<>();
		//if (w1.getUserId().equalsIgnoreCase(userId))
		list=wd.findAllById(userId);
		System.out.println(list);
		return list;
	}
	 

	
	@Override
	public void deleteWishlistByUserId(String userId) throws WishlistException {
			List<WishlistItemEntity> w2= wd.findAllById(userId);
			if(w2.isEmpty()) {
				throw new WishlistException("Unable to delete without userId");
			}
			wd.deleteAll(w2);
			
		
		
	}
	
	
	  @Override
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
	  }
	 

	
	

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity w) {
		// TODO Auto-generated method stub
		
		WishlistItemEntity o=wd.save(w);
		return o;
	}

	



	
	  @Override public void deleteBywishlistitem(String productId,String userId) throws WishlistException {
	  
		  List<WishlistItemEntity> w2= wd.findAll();
		  for(WishlistItemEntity w1:w2) {
			  if(!w1.getUserId().equalsIgnoreCase(userId)) {
				  throw new WishlistException("Unable to delete without productId and userId");
			  }
			  wd.deleteById(w1.getWishlistId());
		  }
	  
	  }
	 
	 



	
	  
	 
	
	 
	 
	
	
	
	


}
