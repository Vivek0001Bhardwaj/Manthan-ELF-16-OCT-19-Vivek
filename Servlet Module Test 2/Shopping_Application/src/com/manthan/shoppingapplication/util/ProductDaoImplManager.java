package com.manthan.shoppingapplication.util;

import com.manthan.shoppingapplication.dao.ProductDao;
import com.manthan.shoppingapplication.dao.ProductDaoImpl;

public class ProductDaoImplManager {

	private ProductDaoImplManager() {}
	public static ProductDao getDaoInstance()
	{
		return new ProductDaoImpl();
	}

}//End of ProductDaoImplManager class
