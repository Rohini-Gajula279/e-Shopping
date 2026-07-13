package com.shopping.dao;

import java.util.List;
import java.util.Optional;

import com.shopping.entity.ProductInfo;

public interface ProductDao 
{
	List<ProductInfo> getAllProductDetails();
	ProductInfo getProductDetailsById(int id);
	List<ProductInfo> getProductByFiltering(String filter);
}