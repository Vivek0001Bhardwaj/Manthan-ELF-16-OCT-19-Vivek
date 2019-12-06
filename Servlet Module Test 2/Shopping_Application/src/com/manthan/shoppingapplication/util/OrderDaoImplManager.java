package com.manthan.shoppingapplication.util;

import com.manthan.shoppingapplication.dao.OrderDao;
import com.manthan.shoppingapplication.dao.OrderDaoImpl;

public class OrderDaoImplManager {

	private OrderDaoImplManager() {}
	public static OrderDao getDaoInstance()
	{
		return new OrderDaoImpl();
	}

}//End of OrderDaoImplManager class
