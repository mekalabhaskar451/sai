package com.training.demobatch.model;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZipooTradingCompany")
public class ZipooTradingCompany {

	@Id
	private Integer customerid;
	private String customername;
	private Date dateOfBirth;
	private String address;
	private Integer zip;
	private String phone;
	private String email;
	private String gender;

	public ZipooTradingCompany(Integer customerid, String customername, Date dateOfBirth, String address, Integer zip,
			String phone, String email, String gender) {

		this.customerid = customerid;
		this.customername = customername;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}

	public ZipooTradingCompany() {

	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ZipooTradingCompany [customerid=" + customerid + ", customername=" + customername + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", zip=" + zip + ", phone=" + phone + ", email=" + email
				+ ", gender=" + gender + "]";
	}

}
