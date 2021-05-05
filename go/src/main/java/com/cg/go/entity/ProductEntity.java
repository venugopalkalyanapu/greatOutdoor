	package com.cg.go.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProductEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	@SequenceGenerator(name="product_seq",sequenceName="product_seq", allocationSize=1)
	private int productId;
	private String productName;
	private double price;
	private String image;
	private String color;
	private String category;
	private int quantity;   
	private String manufacturer;
	private String specification;

	
	//Constructors
	public ProductEntity() 
	{
		super();
	}
	public ProductEntity(int productId, String productName, double price, String image, String color, String category,
			int quantity, String manufacturer, String specification)
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.image = image;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
		this.specification = specification;
	}
	
	//Getters And Setters
	public int getProductId()  {
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		ProductEntity other = (ProductEntity) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", image=" + image + ", color=" + color + ", category=" + category + ", quantity=" + quantity
				+ ", manufacturer=" + manufacturer + ", specification=" + specification + "]";
	}
	
	//HashCode for PrimaryKey
	

}
