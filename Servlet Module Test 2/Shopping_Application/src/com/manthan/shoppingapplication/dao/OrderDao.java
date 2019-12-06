package com.manthan.shoppingapplication.dao;

import java.util.ArrayList;

import com.manthan.shoppingapplication.bean.OrderBean;

public interface OrderDao {

	public ArrayList<OrderBean> getOrderHistory(int userId);
	
	public String addToCart(int productId,int userId, double price);
}
