package com.cg.go.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class OrderEntity {
	@Id
	private String orderId;
	private String userId;
	@OneToMany(targetEntity = ProductEntity.class)
	private List<ProductEntity> products;
	private double Quantity;
	private double totalPrice;
	private long totalQuantity;
	private LocalDate dispatchDate;
	private LocalDate deliveryDate;
	
	
	
	public OrderEntity() {
		super();
	}
	public OrderEntity(String orderId, String userId, List<ProductEntity> products, double totalPrice,
			long totalQuantity, LocalDate dispatchDate, LocalDate deliveryDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.products = products;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public double getQuantity() {
		return Quantity;
	}
	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		OrderEntity other = (OrderEntity) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
}
