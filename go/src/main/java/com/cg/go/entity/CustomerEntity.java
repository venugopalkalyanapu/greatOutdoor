package com.cg.go.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;	

@Entity
public class CustomerEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//private static final long SerialVersionUID = 10l;
	@Id
	private String customerId;
	private String customerName;
	private String mobileNo;
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private AddressEntity address;
	
	public CustomerEntity() {}
	
	public CustomerEntity(String customerId,String customerName, String mobileNo, String email, AddressEntity address) {
		super();
		this.customerId=customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		CustomerEntity other = (CustomerEntity) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
	
}

	
	

