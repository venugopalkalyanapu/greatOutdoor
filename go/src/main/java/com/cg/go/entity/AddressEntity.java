package com.cg.go.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;
	
	@Entity
	public class AddressEntity implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="add_seq")
		@SequenceGenerator(name="add_seq",sequenceName="add_seq", allocationSize=1)
		private long addressId;
		private String buildingNo;
		private String streetName;
		private String area;
		private String city;
		private String state;
		private String zip;
		
		public AddressEntity() {}
		public AddressEntity(long addressId, String buildingNo, String streetName, String area, String city, String state,
				String zip) {
			super();
			this.addressId=addressId;
			this.buildingNo = buildingNo;
			this.streetName = streetName;
			this.area = area;
			this.city = city;
			this.state = state;
			this.zip = zip;
		}
		public long getAddressId() {
			return addressId;
		}
		public void setAddressId(long addressId) {
			this.addressId = addressId;
		}
		public String getBuildingNo() {
			return buildingNo;
		}
		public void setBuildingNo(String buildingNo) {
			this.buildingNo = buildingNo;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (addressId ^ (addressId >>> 32));
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
			AddressEntity other = (AddressEntity) obj;
			if (addressId != other.addressId)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "AddressEntity [addressId=" + addressId + ", buildingNo=" + buildingNo + ", streetName=" + streetName
					+ ", area=" + area + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
		}
		
		
	}
		
