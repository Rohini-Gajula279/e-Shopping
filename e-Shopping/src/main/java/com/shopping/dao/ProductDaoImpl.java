package com.shopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.entity.ProductInfo;
import com.shopping.repository.ProductRepository;
@Component
public class ProductDaoImpl implements ProductDao 
{
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<ProductInfo> getAllProductDetails() 
	{
		return productRepository.findAll();
	}
	@Override
	public ProductInfo getProductDetailsById(int id) 
	{
		return productRepository.findById(id).get();
	}
	@Override
	public List<ProductInfo> getProductByFiltering(String filter) 
	{
		return productRepository.findByProductName(filter);
	}

}
