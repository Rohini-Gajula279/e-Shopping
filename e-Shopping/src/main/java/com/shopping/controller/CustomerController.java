package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.dao.CustomerDao;
import com.shopping.dao.ProductDao;
import com.shopping.entity.CustomerInfo;
import com.shopping.entity.ProductInfo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController
{
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/registration")
	public String registrationPage()
	{
		return "CustomerRegistration";
	}
	
	@RequestMapping("/customerdetails")
//	@ResponseBody
	public String customerDetails(CustomerInfo customerInfo)
	{
		System.out.println(customerInfo);
		CustomerInfo info=customerDao.customerRegistration(customerInfo);
		if(info!=null)
		{
			return "LogIn";
		}
		else 
		{
			return "CustomerRegistration";
		}
	}
	
	@RequestMapping("/customerlogin")
	public String customerLogin(@RequestParam("mail")String email,  @RequestParam("customerPassword")String password,Model model, HttpServletRequest request)
	{
		System.out.println(email);
		System.out.println(password);
		CustomerInfo login = customerDao.customerLogin(email, password);
		String customerName = login.getCustomerName();
		HttpSession session = request.getSession();
		session.setAttribute("name",customerName);
		session.setAttribute("id", login.getCustomerId());
		if(login!=null)
		{
//			System.out.println("Login successfull...!");
			return "CustomerOptions";
		}
		else
		{
//			System.out.println("Invalid details");
			model.addAttribute("msg","Invalid details");
			return "LogIn";
		}
	}
	
	@RequestMapping("/loginpage")
	public String customerLoginPage()
	{
		return "LogIn";
	}
	
	@RequestMapping("/listofproducts")
	public String productListPage(HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession();
		String name=(String) session.getAttribute("name");
		model.addAttribute("custname", name); 
		List<ProductInfo> products = productDao.getAllProductDetails();
		session.setAttribute("listOfProducts", products);
		if(products.isEmpty())
		{
			System.out.println("No product details");
		}
		else 
		{
			model.addAttribute("listofproducts", products);
			return "ProductList";
		}
		return "ProductList";
	}
	@RequestMapping("/searchby")
	public String productFilter(String filtervalue,Model model,HttpServletRequest request)
	{
		List<ProductInfo> productByFiltering= productDao.getProductByFiltering(filtervalue);
		model.addAttribute("listofproducts",productByFiltering);
		String name=(String)request.getSession().getAttribute("name");
		model.addAttribute("customername",name);
		return "ProductList";	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
