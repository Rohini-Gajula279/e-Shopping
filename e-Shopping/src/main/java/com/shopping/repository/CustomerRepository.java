package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping.entity.CustomerInfo;


public interface CustomerRepository extends JpaRepository<CustomerInfo, Integer> 
{
	CustomerInfo findByCustomerEmailIdAndCustomerPassword(String customerEmailId, String customerPassword);
	@Query("select customerInfo from CustomerInfo customerInfo where (customerInfo.customerEmailId=?1 or customerInfo.customerMobileNo=?2) and customerInfo.customerPassword=?3")
	CustomerInfo findByCustomerEmailIdOrCustomerMobileNoAndCustomerPassword(String customerEmailId, String customerPassword,String customerMobileNo);
}
