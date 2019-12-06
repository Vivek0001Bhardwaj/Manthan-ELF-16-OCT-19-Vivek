package com.manthan.hotelbillingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manthan.hotelbillingapplication.bean.HotelBillingAppBean;
import com.manthan.hotelbillingapplication.dbconnection.HotelBillingAppDBConnection;

public class HotelBillingAppDaoImpl implements HotelBillingAppDao {

	static double totalBillOfTheDay = 0;
	static double totalBillOfTheCustomer = 0;
	
	@Override
	public void showAllFoodItems() {

		//General Connection class object
		HotelBillingAppDBConnection jdcon = new HotelBillingAppDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from hotel_bill");

			rs = ps.executeQuery();

			System.out.println("Item Code\tFood Name\t\tPrice");

			while(rs.next())
			{
				System.out.println(rs.getInt("item_code")+"\t\t"+rs.getString("food_name")+"\t\t"+rs.getString("price"));
			}
		}
		catch (SQLException e) {
			System.out.println("Can't display because --> "+e);
			//e.printStackTrace();
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

	}//End of showAllFoodItems method

	@Override
	public void setTotalPriceToHotelBill(double totalDayBill) {

		totalBillOfTheDay = totalBillOfTheDay + totalDayBill;

	}//End of setTotalPriceToHotelBill method

	@Override
	public void getTotalBillOfTheDay() {

		System.out.println(totalBillOfTheDay);

	}//End of getTotalBillOfTheDay method

	@Override
	public String addFoodItem(HotelBillingAppBean hbaBean) {

		String msg=null;

		//General Connection class object
		HotelBillingAppDBConnection jdcon = new HotelBillingAppDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//adding the data to database
			ps=con.prepareStatement("insert into hotel_bill values(?,?,?)");
			ps.setInt(1, hbaBean.getItemCode());
			ps.setString(2, hbaBean.getFoodName());
			ps.setDouble(3, hbaBean.getPrice());

			int n=ps.executeUpdate();

			if(n>0) {
				msg="Food Item Added";
			}else {
				msg="Food Item not added";
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

	}//End of addFoodItem method

	@Override
	public String modifyFoodItem(HotelBillingAppBean hbaBean) {

		String msg=null;

		//General Connection class object
		HotelBillingAppDBConnection jdcon = new HotelBillingAppDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//adding the data to database
			ps=con.prepareStatement("update hotel_bill set food_name=?, price=? where item_code=?");
			ps.setString(1, hbaBean.getFoodName());
			ps.setDouble(2, hbaBean.getPrice());
			ps.setInt(3, hbaBean.getItemCode());

			int n=ps.executeUpdate();

			if(n>0) {
				msg="Food Item Updated";
			}else {
				msg="Food Item not Updated";
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

	}//End of modifyFoodItem method

	@Override
	public String removeFoodItem(int itemCode) {

		String msg=null;

		//General Connection class object
		HotelBillingAppDBConnection jdcon = new HotelBillingAppDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//adding the data to database
			ps=con.prepareStatement("delete from hotel_bill where item_code=?");
			ps.setInt(1, itemCode);

			int n=ps.executeUpdate();

			if(n>0) {
				msg="Food Item Removed";
			}else {
				msg="Food Item not Removed";
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

	}//End of removeFoodItem method

	@Override
	public void setTotalPriceToCustomerBill(double totalPrice) {
		
		totalBillOfTheCustomer = totalBillOfTheCustomer + totalPrice;

	}//End of setTotalPriceToCustomerBill method
	
	@Override
	public void getTotalBillOfTheCustomer() {
		
		System.out.println(totalBillOfTheCustomer);
	
	}//End of getTotalBillOfTheCustomer method

	@Override
	public void setTotalPriceToCustomerBillToZero(double totalPrice) {
		
		totalBillOfTheCustomer=0;
	
	}//End of setTotalPriceToCustomerBillToZero method

}//End of HotelBillingAppDaoImpl class
