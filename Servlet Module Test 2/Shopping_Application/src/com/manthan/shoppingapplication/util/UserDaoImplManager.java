package com.manthan.shoppingapplication.util;

import com.manthan.shoppingapplication.dao.UserDao;
import com.manthan.shoppingapplication.dao.UserDaoImpl;

public class UserDaoImplManager {

	private UserDaoImplManager() {}
	public static UserDao getDaoInstance()
	{
		return new UserDaoImpl();
	}

}//End of UserDaoImplManager class
