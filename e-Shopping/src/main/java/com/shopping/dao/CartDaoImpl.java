package com.shopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.entity.CartInfo;
import com.shopping.repository.CartRepository;

@Component
public class CartDaoImpl implements CartDao 
{
	@Autowired
	CartRepository cartRepository;
	@Override
	public CartInfo saveByDetails(CartInfo cartInfo)
	{	
		return cartRepository.save(cartInfo);
	}
	@Override
	public List<CartInfo> getCartDetailsById(int id)
	{	
		return cartRepository.getByCustomerId(id);
	}
	@Override
	public CartInfo getCartDetailsByCustomerIdAndProductName(int customerId, String productName)
	{
		return cartRepository.findByCustomerIdAndProductName(customerId, productName);
	}
	@Override
	public List<CartInfo> removeProductFromCart(int cartId) 
	{
		return cartRepository.deleteByCartId(cartId);
	}
}
