package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping.entity.ProductInfo;

public interface ProductRepository extends JpaRepository<ProductInfo, Integer> 
{
	@Query("select product from ProductInfo product where product.productName=?1 or product.productBrand=?1 or product.productCategory=?1 or product.productPrice<=?1")
	List<ProductInfo> findByProductName(String filter);
}
