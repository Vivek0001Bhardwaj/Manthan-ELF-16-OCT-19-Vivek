package com.manthan.musicplayer.dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;

public class MusicDBConnection {

	private Connection con;

	public MusicDBConnection() {

		try {

			//load the diver
			Class.forName("com.mysql.jdbc.Driver");

			//get the connection object via DriverManager class				 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root");
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

