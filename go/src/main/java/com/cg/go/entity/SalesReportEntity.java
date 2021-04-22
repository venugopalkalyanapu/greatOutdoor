package com.cg.go.entity;

import javax.persistence.*;
@Entity
@Table(name="salesReport")
public class SalesReportEntity {
	@Id
	private long salesReportId;
	private String productId;
	private String productName;
	private Integer quantitySold;
	private double totalSale;

	public SalesReportEntity() {
		
	}
	public SalesReportEntity(long salesReportId, String productId, String productName, Integer quantitySold,
			double totalSale) {
		super();
		this.salesReportId = salesReportId;
		this.productId = productId;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.totalSale = totalSale;
	}
	public long getSalesReportId() {
		return salesReportId;
	}
	public void setSalesReportId(long salesReportId) {
		this.salesReportId = salesReportId;
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
		result = prime * result + (int) (salesReportId ^ (salesReportId >>> 32));
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
		if (salesReportId != other.salesReportId)
			return false;
		return true;
	}	
}