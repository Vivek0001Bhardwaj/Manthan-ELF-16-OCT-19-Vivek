package com.manthan.user.util;

import com.manthan.user.dao.UserDao;
import com.manthan.user.dao.UserDaoImpl;

public class UserDaoImplManager {

	private UserDaoImplManager() {}
	public static UserDao getDaoInstance()
	{
		return new UserDaoImpl();
	}

}//End of class
