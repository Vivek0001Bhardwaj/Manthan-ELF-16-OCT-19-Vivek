package com.manthan.shoppingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manthan.shoppingapplication.bean.UserBean;
import com.manthan.shoppingapplication.dbconnection.UserDBConnection;

public class UserDaoImpl implements UserDao{

	@Override
	public String registerUser(UserBean ub) {

		String msg=null;

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//adding the data to database
			ps=con.prepareStatement("insert into user_info values(?,?,?,?)");
			ps.setInt(1, ub.getUserId());
			ps.setString(2, ub.getUserName());
			ps.setString(3, ub.getEmail());
			ps.setString(4, ub.getPassword());
			ps.setInt(5,0);

			int n=ps.executeUpdate();

			if(n>0) {
				msg="User Registered Successfully";
			}
			else {
				msg="User not Registered";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally 
		{
			try 
			{
				if(ps!=null)
					ps.close();

				if(con!=null)
					con.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}//End of finally block

		return msg;

	}//End of registerUser method

	@Override
	public String resetPassword(UserBean ub) {
		String msg=null;

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//adding the data to database
			ps=con.prepareStatement("update user_info set password=? where userName=?");
			ps.setString(1, ub.getConfPassword());
			ps.setString(2, ub.getUserName());

			int n=ps.executeUpdate();

			if(n>0) {
				msg="Password Updated Successfully";
			}
			else {
				msg="Password Not Updated";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally 
		{
			try 
			{
				if(ps!=null)
					ps.close();

				if(con!=null)
					con.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}//End of finally block

		return msg;

	}//End of resetPassword method

	@Override
	public String authenticateUser(String email, String password) {

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String msg = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from user_info where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();

			if(rs.next())
			{
				if(rs.getString("password").equals(password))
				{
					msg = "User Valid";
				}
			}
			else
			{
				msg = "User Not Present, Register first";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		finally 
		{
			try 
			{
				if(rs!=null)
					rs.close();

				if(ps!=null)
					ps.close();

				if(con!=null)
					con.close();
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}//End of finally block

		return msg;
	}//End of authenticateUser method

	@Override
	public void setCount(String email, int countAttempt) {

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("update user_info set countAttempt=? where email=?");
			ps.setInt(1, countAttempt);
			ps.setString(2, email);

			ps.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		finally 
		{
			try 
			{
				if(ps!=null)
					ps.close();

				if(con!=null)
					con.close();
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}//End of finally block

	}//End of setCount method

	@Override
	public int getCount(String email) {

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		int count = 0;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from user_info where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();

			if(rs.next())
			{
				count = rs.getInt("countAttempt");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		finally 
		{
			try 
			{
				if(rs!=null)
					rs.close();

				if(ps!=null)
					ps.close();

				if(con!=null)
					con.close();
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}//End of finally block
		return count;

	}//End of getCount method

	@Override
	public UserBean getUserDetails(String email) {
		
		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		UserBean ub = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from user_info where email = ?");
			ps.setString(1, email);
			rs = ps.executeQuery();

			if(rs.next())
			{
				ub = new UserBean();
				
				ub.setUserId(rs.getInt("user_id"));
				
				ub.setUserName(rs.getString("user_name"));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		finally 
		{
			try 
			{
				if(rs!=null)
					rs.close();

				if(ps!=null)
					ps.close();

				if(con!=null)
					con.close();
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return ub;
	}

}//End of getUserDetails method
