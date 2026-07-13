package com.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CartInfo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	private int customerId;
	private String productName;
	private double productPrice;
}
