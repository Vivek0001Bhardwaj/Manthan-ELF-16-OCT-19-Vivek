package com.manthan.shoppingapplication.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDBConnection {

	private Connection con;

	public UserDBConnection() {

		try {

			//load the diver
			Class.forName("com.mysql.jdbc.Driver");

//			//2nd way to load the diver
//			Driver d=new Driver();
//			DriverManager.registerDriver(d);

			//get the connection object via DriverManager class				 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart?user=root&password=root");
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

