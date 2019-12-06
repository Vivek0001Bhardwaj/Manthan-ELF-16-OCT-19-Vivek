package com.manthan.shoppingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.manthan.shoppingapplication.bean.ProductBean;
import com.manthan.shoppingapplication.dbconnection.UserDBConnection;

public class ProductDaoImpl implements ProductDao{

	@Override
	public ArrayList<ProductBean> getProducts(String productName) {

		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		ResultSet rs = null;

		ProductBean prdb = null;

		ArrayList<ProductBean> arPB = new ArrayList<ProductBean>();

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from product_info where product_name=?");
			ps.setString(0, productName);

			rs = ps.executeQuery();

			while(rs.next())
			{
				prdb = new ProductBean();

				prdb.setProductId(rs.getInt("product_id"));
				prdb.setProductName(rs.getString("product_name"));
				prdb.setProductCost(rs.getDouble("product_cost"));
				prdb.setProductColor(rs.getString("product_color"));
				prdb.setDescription(rs.getString("description"));
				prdb.setNumberOfProducts(rs.getInt("number_of_products"));

				arPB.add(prdb);
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
		return arPB;
	}

	@Override
	public double getProductCost(int productId) {

		double prdCost = 0;
		
		//General Connection class object
		UserDBConnection jdcon = new UserDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		ResultSet rs = null;
		
		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from product_info where product_id=?");
			ps.setInt(0, productId);
			
			rs = ps.executeQuery();

			if(rs.next())
			{
				prdCost = rs.getInt("product_cost");
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
		return prdCost;
	}
}