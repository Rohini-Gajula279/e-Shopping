package com.shopping.dao;

import com.shopping.entity.CustomerInfo;

public interface CustomerDao
{
	CustomerInfo customerRegistration(CustomerInfo customerInfo);
	CustomerInfo customerLogin(String email, String password);
}
