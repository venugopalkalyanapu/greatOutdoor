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
public class CartItemEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(name="cart_seq",sequenceName="cart_seq", allocationSize=1)
	private Long cartId;
	@OneToOne
	@JoinColumn(name="user_Id")
	private UserEntity userId;
	private double cartTotalPrice;
	private int quantity;
	private long totalQuantity;
	@ManyToOne
    @JoinColumn(name="product_id")
	private ProductEntity products;
	
	
	//constructors
	public CartItemEntity() 
	{
		super();
	}
	public CartItemEntity(Long cartId, UserEntity userId, double cartTotalPrice, long totalQuantity,
			ProductEntity products,int quantity)
	{
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
		this.products = products;
		this.quantity=quantity;
	}
	
	//Getters and Setters 
	public Long getCartId() 
	{
		return cartId;
	}
	public void setCartId(Long cartId) 
	{
		this.cartId = cartId;
	}
	public UserEntity getUserId()
	{
		return userId;
	}
	public void setUserId(UserEntity userId)
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
	public ProductEntity getProducts()
	{
		return products;
	}
	public void setProducts(ProductEntity products)
	{
		this.products = products;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
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
		CartItemEntity other = (CartItemEntity) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		return true;
	}
	
	

}
