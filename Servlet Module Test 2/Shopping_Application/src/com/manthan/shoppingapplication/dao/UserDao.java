package com.manthan.shoppingapplication.dao;

import com.manthan.shoppingapplication.bean.UserBean;

public interface UserDao {

	public String registerUser(UserBean ub);
	
	public String resetPassword(UserBean ub);
	
	public String authenticateUser(String userName, String password);
	
	public void setCount(String userName, int countAttempt);
	
	public int getCount(String userName);
	
	public UserBean getUserDetails(String email);
}
