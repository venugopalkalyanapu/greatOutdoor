package com.cg.go.entity;

import javax.persistence.*;
@Entity
@Table(name="Report")
public class SalesReportEntity {
	@Id
	private long id;
	private String productId;
	private String productName;
	private Integer quantitySold;
	private double totalSale;

	public SalesReportEntity() {
	    
	}
	public SalesReportEntity(long id, String productId, String productName, Integer quantitySold, double totalSale) {
	    super();
	    this.id = id;
	    this.productId = productId;
	    this.productName = productName;
	    this.quantitySold = quantitySold;
	    this.totalSale = totalSale;
	}
	public long getId() {
	    return id;
	}
	public void setId(long id) {
	    this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + (int) (id ^ (id >>> 32));
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
	    SalesReportEntity other = (SalesReportEntity) obj;
	    if (id != other.id)
		return false;
	    return true;
	}
		
}