package com.manthan.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manthan.user.bean.UserBean;
import com.manthan.user.dbconnection.UserDBConnection;

public class UserDaoImpl implements UserDao {

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
			ps=con.prepareStatement("insert into user_table values(?,?,?,?,?)");
			ps.setString(1, ub.getUserName());
			ps.setString(2, ub.getPassword());
			ps.setInt(3,ub.getAge());
			ps.setString(4,ub.getGender());
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
	public ArrayList<UserBean> displayUser(String userName) {

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		UserBean ub = null;

		ArrayList<UserBean> ar = new ArrayList<>();

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from user_table where userName=?");
			ps.setString(1, userName);
			rs = ps.executeQuery();

			while(rs.next())
			{
				ub = new UserBean();
				ub.setUserName(rs.getString("userName"));
				ub.setAge(rs.getInt("age"));
				ub.setGender(rs.getString("gender"));

				ar.add(ub);
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

		return ar;

	}//End of displayUser method



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
			ps=con.prepareStatement("update user_table set password=? where userName=?");
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
	public String authenticateUser(String userName, String password) {

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
			ps = con.prepareStatement("select * from user_table where userName=?");
			ps.setString(1, userName);
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
	public void setCount(String userName, int countAttempt) {

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("update user_table set countAttempt=? where userName=?");
			ps.setInt(1, countAttempt);
			ps.setString(2, userName);
			
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
	public int getCount(String userName) {

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
			ps = con.prepareStatement("select * from user_table where userName=?");
			ps.setString(1, userName);
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

}//End of class
