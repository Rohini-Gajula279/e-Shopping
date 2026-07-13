package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.dao.CartDao;
import com.shopping.dao.ProductDao;
import com.shopping.entity.CartInfo;
import com.shopping.entity.ProductInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController 
{
	@Autowired
	ProductDao productDao;
	@Autowired
	CartDao cartDao;
	
	@RequestMapping("/cartlist")
	public String cartList(HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession();
		String name=(String) session.getAttribute("name");
		model.addAttribute("custname", name);
		return "CartList";
	}
	
	@RequestMapping("/getproductid")
	public String addToCart(Integer productId,HttpServletRequest request, Model model)
	{
		Integer id= (Integer) request.getSession().getAttribute("id");
		ProductInfo detailsById=productDao.getProductDetailsById(productId);
		CartInfo  byProdnameCustid= cartDao.getCartDetailsByCustomerIdAndProductName(id,detailsById.getProductName());
		if(byProdnameCustid==null) 
		{
		if(detailsById!=null) 
		{
			CartInfo cartInfo = new CartInfo();
			cartInfo.setCustomerId(id);
			cartInfo.setProductName(detailsById.getProductName());
			cartInfo.setProductPrice(detailsById.getProductPrice());
			System.out.println(cartInfo);
			
			CartInfo info=cartDao.saveByDetails(cartInfo);
			if(info!=null) 
			{
				List<ProductInfo> productList= (List<ProductInfo>)request.getSession().getAttribute("listOfProducts");
				String name = (String) request.getSession().getAttribute("name");
				model.addAttribute("listOfProducts",productList);
				model.addAttribute("custname", name);
				model.addAttribute("cartmsg", detailsById.getProductName()+" added to the cart");
				return "ProductList";
			}
			else 
			{
				return "No";
			}
		}
		else 
		{
			return "No data found";
		}
		}
		else
		{
			List<ProductInfo> productList= (List<ProductInfo>)request.getSession().getAttribute("listOfProducts");
			String name = (String) request.getSession().getAttribute("name");
			model.addAttribute("listOfProducts",productList);
			model.addAttribute("custname", name);
			model.addAttribute("cartmsg", detailsById.getProductName()+" already added to the cart");
			return "ProductList";
		}
	}
	
	@RequestMapping("/cartdetails")
	public String cartDetails(HttpServletRequest request,Model model) 
	{
	HttpSession session = request.getSession();
	Integer customerId=(Integer) session.getAttribute("id");
	List<CartInfo> cartdetailsByid=cartDao.getCartDetailsById(customerId);
//	List<CartInfo> cartdetailsByid=cartDao.getAllcartDetails();
	session.setAttribute("cartdetails", cartdetailsByid);
	if(cartdetailsByid.isEmpty()) 
	{
		System.out.println("no cart details");
	}
	else 
	{
		model.addAttribute("cartdetails", cartdetailsByid);
		System.out.println(cartdetailsByid);
		return "cartlist";
	}
	return "";
	}
	@RequestMapping("/remove")
	public String removeCart(int cartid,HttpServletRequest request,Model model) 
	{
		String cartIdStr = request.getParameter("cartid");
        int cartId = Integer.parseInt(cartIdStr);
        cartDao.removeProductFromCart(cartId);
        return "cartlist";
    }
}
