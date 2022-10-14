package com.training.demobatch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ChennaiNationalBank")
public class ChennaiNationalBank {
	@Column(name="CUSTOMER_ID")
	@NotNull(message = "Id must be not null")
	@Id
	private Integer customerid;
	
	@Column(name="CUSTOMER_NAME")
	private String customername;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ZIP_CODE")
	private Integer zipcode;
	
	@Column(name="MOBILE_NO")
	private Integer mobileno;
	
	@Email(message = "Email must be valid")
    @NotEmpty(message = "Email must be not null/empty")
	@Column(name="EMAIL_ID")
	private String emailid;
	
	@Column(name="GENDER")
	private String gender;

	
	public ChennaiNationalBank() {

	}

	public ChennaiNationalBank(Integer customerid, String customername, String dob, String address, Integer zipcode,
			Integer mobileno, String emailid, String gender) {

		this.customerid = customerid;
		this.customername = customername;
		this.dob = dob;
		this.address = address;
		this.zipcode = zipcode;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.gender = gender;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getMobileno() {
		return mobileno;
	}

	public void setMobileno(Integer mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ChennaiNationalBank [customerid=" + customerid + ", customername=" + customername + ", dob=" + dob
				+ ", address=" + address + ", zipcode=" + zipcode + ", mobileno=" + mobileno + ", emailid=" + emailid
				+ ", gender=" + gender + "]";
	}
}
