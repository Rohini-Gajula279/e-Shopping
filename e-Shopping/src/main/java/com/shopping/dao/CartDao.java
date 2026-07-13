package com.shopping.dao;

import java.util.List;

import com.shopping.entity.CartInfo;

public interface CartDao
{
	CartInfo saveByDetails(CartInfo cartInfo);
	List<CartInfo> getCartDetailsById(int id);
	CartInfo getCartDetailsByCustomerIdAndProductName(int customerId, String productName);
	List<CartInfo> removeProductFromCart(int cartId);
}
