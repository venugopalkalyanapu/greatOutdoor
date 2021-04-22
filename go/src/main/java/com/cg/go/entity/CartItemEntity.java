package com.cg.go.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;	

@Entity
public class CartItemEntity
{
	@Id
	private long cartId;
	private String userId;
	private double cartTotalPrice;
	private long totalQuantity;
	@OneToMany(targetEntity =  ProductEntity.class)
	private List<ProductEntity> products;


	public CartItemEntity() 
	{
		super();
	}
	public CartItemEntity(long cartId, String userId, double cartTotalPrice, long totalQuantity,
			List<ProductEntity> products)
	{
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
		this.products = products;
	}
	public long getCartId() 
	{
		return cartId;
	}
	public void setCartId(long cartId) 
	{
		this.cartId = cartId;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public double getCartTotalPrice() 
	{
		return cartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) 
	{
		this.cartTotalPrice = cartTotalPrice;
	}
	public long getTotalQuantity() 
	{
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity)
	{
		this.totalQuantity = totalQuantity;
	}
	public List<ProductEntity> getProducts()
	{
		return products;
	}
	public void setProducts(List<ProductEntity> products)
	{
		this.products = products;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemEntity other = (CartItemEntity) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

}
