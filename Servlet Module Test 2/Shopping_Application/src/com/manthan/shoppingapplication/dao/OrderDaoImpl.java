package com.manthan.shoppingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manthan.shoppingapplication.bean.OrderBean;
import com.manthan.shoppingapplication.dbconnection.UserDBConnection;

public class OrderDaoImpl implements OrderDao {

	@Override
	public ArrayList<OrderBean> getOrderHistory(int userId) {

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		ResultSet rs = null;

		OrderBean orb = null;

		ArrayList<OrderBean> arOB = new ArrayList<OrderBean>();

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from order_info where userId=?");
			ps.setInt(0, userId);

			rs = ps.executeQuery();

			while(rs.next())
			{
				orb = new OrderBean();

				orb.setProductId(rs.getInt("product_id"));
				orb.setUserId(rs.getInt("user_id"));
				orb.setPrice(rs.getDouble("price"));

				arOB.add(orb);
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
		return arOB;
	}

	@Override
	public String addToCart(int productId, int userId, double price) {

		String msg=null;
		
		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//adding the data to database
			ps=con.prepareStatement("insert into order_info values(?,?,?)");
			ps.setInt(0, productId);
			ps.setInt(1, userId);
			ps.setDouble(3, price);

			int n=ps.executeUpdate();

			if(n>0) {
				msg="Order Added To Cart";
			}
			else {
				msg="Can't Add Order";
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
}