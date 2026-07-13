package com.shopping.entity;

import java.sql.Date;

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

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductInfo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Product_Id")
	private Integer productId;
	@Column(name="Product_Name",nullable = false)
	private String productName;
	@Column(nullable = false, name="Product_Expiry")
	private Date productExpiry;
	@Column(name="Product_Brand")
	private String productBrand;
	@Column(name="Product_Quantity")
	private int productQuantity;
	@Column(name="Product_Review")
	private String productReview;
	@Column(nullable = false,name="Product_Price")
	private double productPrice;
	@Column(name="Product_Category")
	private String productCategory;
}
