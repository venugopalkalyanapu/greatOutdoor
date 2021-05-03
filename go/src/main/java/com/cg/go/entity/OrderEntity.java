package com.cg.go.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class OrderEntity {
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
	private String orderId;
	@OneToOne
	@JoinColumn(name="user_Id")
	private UserEntity userId;
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity products;
	private double Quantity;
	private double totalPrice;
	private long totalQuantity;
	private LocalDate dispatchDate;
	private LocalDate deliveryDate;


    //Constructor using fields and without using Fields
	public OrderEntity() {
		super();
	}
	public OrderEntity(String orderId, UserEntity userId, ProductEntity products, double totalPrice,
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
	
	
	//Getters and setters
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public UserEntity getUserId() {
		return userId;
	}
	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}
	public ProductEntity getProducts() {
		return products;
	}
	public void setProducts(ProductEntity products) {
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
	
	
	//Hashcode for primaryKey
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
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", userId=" + userId + ", products=" + products + ", Quantity="
				+ Quantity + ", totalPrice=" + totalPrice + ", totalQuantity=" + totalQuantity + ", dispatchDate="
				+ dispatchDate + ", deliveryDate=" + deliveryDate + "]";
	}
	

}
