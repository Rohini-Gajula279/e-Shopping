package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping.entity.CartInfo;

public interface CartRepository extends JpaRepository<CartInfo, Integer> 
{
	List<CartInfo> getByCustomerId(int customerId);
	CartInfo findByCustomerIdAndProductName(int customerId, String productName);
	@Query("DELETE FROM CartInfo c WHERE c.cartId = ?1")
	List<CartInfo> deleteByCartId(int cartId);
}
