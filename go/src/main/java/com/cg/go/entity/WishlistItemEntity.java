package com.cg.go.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist_Table1")
public class WishlistItemEntity {
	
	@Id
	private long wishlistId;
	private String userId;

	@OneToMany(targetEntity = ProductEntity.class)
	    private List<ProductEntity> product;
	

	public WishlistItemEntity() {
			super();
		}

	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}

	public long getWishlistId() {
		return wishlistId;
	}

	public WishlistItemEntity(long wishlistId, String userId,  List<ProductEntity> product) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.product = product;
	}


	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	/*
	 * public void addProduct(ProductEntity1 productEntity) {
	 * productEntity.setW1(this); //this will avoid nested cascade
	 * this.getProductId().add(productEntity.getProductId1()); }
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (wishlistId ^ (wishlistId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishlistItemEntity other = (WishlistItemEntity) obj;
		if (wishlistId != other.wishlistId)
			return false;
		return true;
	}
	

}
