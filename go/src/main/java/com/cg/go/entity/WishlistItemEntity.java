package com.cg.go.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class WishlistItemEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(name="cart_seq",sequenceName="cart_seq", allocationSize=1)
	private Long wishlistId;
	@OneToOne
	@JoinColumn(name="user_Id")
	private UserEntity userId;

	@ManyToOne
	@JoinColumn(name="product_Id")
	private ProductEntity product;
	

	public WishlistItemEntity() {
			super();
		}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public long getWishlistId() {
		return wishlistId;
	}

	public WishlistItemEntity(Long wishlistId, UserEntity userId,  ProductEntity product) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.product = product;
	}


	public void setWishlistId(Long wishlistId) {
		this.wishlistId = wishlistId;
	}
	public UserEntity getUserId() {
		return userId;
	}
	public void setUserId(UserEntity userId) {
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
