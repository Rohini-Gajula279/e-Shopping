package com.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerInfo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Customer_Id")
	private Integer customerId;
	@Column(name="Customer_Name")
	private String customerName;
	@Column(unique=true, nullable = false, length=40,name="Customer_EmailId")
	private String customerEmailId;
	@Column(unique=true, nullable = false, length=6, name="Customer_Password")
	private String customerPassword;
	@Column(unique=true, nullable = false, length=10,name="Customer_MobileNo")
	private String customerMobileNo;
	@Column(nullable = false, name="Customer_Address")
	private String customerAddress;
	@Column(name="Customer_Gender")
	private String customerGender;
	
}
