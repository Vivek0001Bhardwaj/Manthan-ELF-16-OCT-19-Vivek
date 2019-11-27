package com.manthan.user.dao;

import java.util.ArrayList;

import com.manthan.user.bean.UserBean;

public interface UserDao {

	public String registerUser(UserBean ub);
	
	public ArrayList<UserBean> displayUser(String userName);
	
	public String resetPassword(UserBean ub);
	
	public String authenticateUser(String userName, String password);
	
	public void setCount(String userName, int countAttempt);
	
	public int getCount(String userName);
}
