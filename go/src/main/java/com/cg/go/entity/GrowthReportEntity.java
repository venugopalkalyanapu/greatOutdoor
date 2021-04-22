package com.cg.go.entity;

import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name="growthReport")
public class GrowthReportEntity {
	@Id
	private long growthReportId;
	private LocalDate currentdate;
	private double revenue;
	private double amountChange;
	private double percentageGrowth;
	private String colorCode;
	
	public GrowthReportEntity() {
		
	}
	public GrowthReportEntity(long growthReportId, LocalDate currentdate, double revenue, double amountChange,
			double percentageGrowth, String colorCode) {
		super();
		this.growthReportId = growthReportId;
		this.currentdate = currentdate;
		this.revenue = revenue;
		this.amountChange = amountChange;
		this.percentageGrowth = percentageGrowth;
		this.colorCode = colorCode;
	}
	public long getGrowthReportId() {
		return growthReportId;
	}
	public void setGrowthReportId(long growthReportId) {
		this.growthReportId = growthReportId;
	}
	public LocalDate getCurrentdate() {
		return currentdate;
	}
	public void setCurrentdate(LocalDate currentdate) {
		this.currentdate = currentdate;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getAmountChange() {
		return amountChange;
	}
	public void setAmountChange(double amountChange) {
		this.amountChange = amountChange;
	}
	public double getPercentageGrowth() {
		return percentageGrowth;
	}
	public void setPercentageGrowth(double percentageGrowth) {
		this.percentageGrowth = percentageGrowth;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (growthReportId ^ (growthReportId >>> 32));
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
		GrowthReportEntity other = (GrowthReportEntity) obj;
		if (growthReportId != other.growthReportId)
			return false;
		return true;
	}
}
