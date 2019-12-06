package com.manthan.hotelbillingapplication.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class HotelBillingAppDBConnection {

	private Connection con;

	public HotelBillingAppDBConnection() {

		try {
			
			//load the diver
			Driver d=new Driver();
			DriverManager.registerDriver(d);

			//get the connection object via DriverManager class				 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db?user=root&password=root");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}//End of class constructor

	public Connection getConnection()
	{
		return con;
	}

}//End of class

