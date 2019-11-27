package com.manthan.musicplayer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.manthan.musicplayer.dbconnection.MusicDBConnection;
import com.manthan.musicplayer.bean.MusicBean;



public class MusicDaoImpl implements MusicDao {

	@Override
	public void playAllSong() {
		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from musicfiles");

			rs = ps.executeQuery();

			while(rs.next())
			{
				//rs.notify();
				System.out.println("Playing --> "+rs.getString("song_title"));
				//rs.wait(20000);
				Thread.sleep(2000);
			}
		}
		catch (SQLException | InterruptedException e) {
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

	}//End of playAllSong method

	@Override
	public void playSongsRandomly() {

		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from musicfiles");

			rs = ps.executeQuery();

			ArrayList<String> al = new ArrayList<String>(); 

			while(rs.next())
			{
				al.add(rs.getString("song_title"));
			}

			Collections.shuffle(al);

			for(String s : al)
			{
				//al.notify();
				System.out.println("Playing --> "+s);
				//al.wait(20000);
				Thread.sleep(2000);
			}
		}
		catch (SQLException | InterruptedException e) {
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
	
	}//End of playSongsRandomly method

	@Override
	public void playParticularSong(int songID) {

		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from musicfiles where song_id=?");
			ps.setInt(1, songID);
			rs = ps.executeQuery();

			if(rs.next())
			{
				System.out.println("Playing --> "+rs.getString("song_title"));
			}
			else
			{
				System.out.println("Can't Play");
			}
		}
		catch (SQLException e) {
			System.out.println("Song id not present");
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
	
	}//End of playParticularSong method

	@Override
	public void searchASong(String songTitle) {

		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from musicfiles where song_title=?");
			ps.setString(1,songTitle);
			rs = ps.executeQuery();

			System.out.println("Song ID\t\tSong Title\t\tArtist Name\t\tAlbum Name\t\tSong Location\t\tDescription");

			if(rs.next())
			{
				System.out.println(rs.getInt("song_id")+"\t\t"+rs.getString("song_title")+"\t\t"+rs.getString("artist_name")
				+"\t\t"+rs.getString("album_name")+"\t\t"+rs.getString("song_location")
				+"\t\t\t"+rs.getString("description"));
			}
			else
			{
				System.out.println("Can't Search");
			}
		}
		catch (SQLException e) {
			System.out.println("Song not found");
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

	}//End of searchASong method

	@Override
	public void showAllSongs() {

		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			//getting the data from database
			ps = con.prepareStatement("select * from musicfiles");

			rs = ps.executeQuery();

			System.out.println("Song ID\t\tSong Title\t\tArtist Name\t\tAlbum Name\t\tSong Location\t\tDescription");

			while(rs.next())
			{
				System.out.println(rs.getInt("song_id")+"\t\t"+rs.getString("song_title")+"\t\t"+rs.getString("artist_name")
				+"\t\t"+rs.getString("album_name")+"\t\t"+rs.getString("song_location")
				+"\t\t"+rs.getString("description"));
			}
		}
		catch (SQLException e) {
			System.out.println("Song not found");
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
	
	}//End of showAllSongs method

	@Override
	public String addSong(MusicBean mb) {

		String msg=null;

		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//adding the data to database
			ps=con.prepareStatement("insert into musicfiles values(?,?,?,?,?,?)");
			ps.setInt(1, mb.getSongID());
			ps.setString(2, mb.getSongTitle());
			ps.setString(3,mb.getArtistName());
			ps.setString(4,mb.getAlbumName());
			ps.setString(5,mb.getSongLocation());
			ps.setString(6,mb.getDescription());

			int n=ps.executeUpdate();

			if(n>0) {
				msg="Song Added";
			}else {
				msg="Song not added";
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
	
	}//End of addSong method

	@Override
	public String editSong(MusicBean mb) {

		String msg=null;

		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//updating the data to database
			ps=con.prepareStatement("update musicfiles set song_title=?, artist_name=?, album_name=?, song_location=?, description=? where song_id=?");
			
			ps.setString(1, mb.getSongTitle());
			ps.setString(2,mb.getArtistName());
			ps.setString(3,mb.getAlbumName());
			ps.setString(4,mb.getSongLocation());
			ps.setString(5,mb.getDescription());
			ps.setInt(6, mb.getSongID());

			int n=ps.executeUpdate();

			if(n>0) {
				msg="Song Edited";
			}else {
				msg="Song not Edited";
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
	
	}//End of editSong method

	@Override
	public String deleteSong(int songID) {
		String msg=null;

		//General Connection class object
		MusicDBConnection jdcon = new MusicDBConnection();

		//getting the connection object
		Connection con = jdcon.getConnection();

		PreparedStatement ps = null;

		try
		{
			//deleting the data from database
			ps=con.prepareStatement("delete from musicfiles where song_id=?");
			ps.setInt(1, songID);

			int n = ps.executeUpdate();

			if(n>0) {
				msg="Song Deleted";
			}
			else {
				msg="Song not Deleted";
			}
		}
		catch (SQLException e) {
			System.out.println("Song not found");
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
	
	}//End of deleteSong method

}//End of class
