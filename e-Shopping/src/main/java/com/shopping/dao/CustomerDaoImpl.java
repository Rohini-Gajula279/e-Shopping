package com.shopping.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.entity.CustomerInfo;
import com.shopping.repository.CustomerRepository;
@Component 
public class CustomerDaoImpl implements CustomerDao
{
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public CustomerInfo customerRegistration(CustomerInfo customerInfo) 
	{
		CustomerInfo info = customerRepository.save(customerInfo);
		return info;
	}
	@Override
	public CustomerInfo customerLogin(String email, String password)
	{
//		return customerRepository.findByCustomerEmailIdAndCustomerPassword(email, password);
		return customerRepository.findByCustomerEmailIdOrCustomerMobileNoAndCustomerPassword(email, email, password);
	}
}
