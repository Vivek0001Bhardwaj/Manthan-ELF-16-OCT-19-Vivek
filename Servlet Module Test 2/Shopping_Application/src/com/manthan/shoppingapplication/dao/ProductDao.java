package com.manthan.shoppingapplication.dao;

import java.util.ArrayList;

import com.manthan.shoppingapplication.bean.ProductBean;

public interface ProductDao {

	public ArrayList<ProductBean> getProducts(String productName);
	
	public double getProductCost(int productId);
}
