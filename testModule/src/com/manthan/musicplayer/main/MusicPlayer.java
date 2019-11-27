package com.manthan.musicplayer.main;

import java.util.Scanner;

import com.manthan.musicplayer.dao.MusicDao;
import com.manthan.musicplayer.util.MusicDaoImplManager;
import com.manthan.musicplayer.bean.MusicBean;

public class MusicPlayer {
	
	public static void main(String[] args) {
		
		MusicDao sedao = MusicDaoImplManager.getDaoInstance(); //getting dao class object by a dao manager class
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entered in Music Player\n");
		
		System.out.println("Press 1 to \"Play a Song\"");
		System.out.println("Press 2 to \"Search a Song\"");
		System.out.println("Press 3 to \"Show all Songs\"");
		System.out.println("Press 4 to \"Operate on Songs Database\"");
		System.out.println("Press 5 to \"Exit\"\n");
		
		int input = sc.nextInt();
		
		if(input == 1)
		{
			System.out.println("Press A to \"Play all songs\"");
			System.out.println("Press B to \"Play Songs Randomly\"");
			System.out.println("Press C to \"Play a Particular Song\"\n");
			
			String option = sc.next();
			
			if(option.equalsIgnoreCase("A"))
			{
				sedao.playAllSong();
			}
			else if(option.equalsIgnoreCase("B"))
			{
				sedao.playSongsRandomly();
			}
			else if(option.equalsIgnoreCase("C"))
			{
				System.out.println("Enter the song id");
				int songID = sc.nextInt();
				sedao.playParticularSong(songID);
			}
		}
		else if(input == 2)
		{
			sc.nextLine();
			System.out.println("Enter the song title");
			String songTitle = sc.nextLine();
			//sc.next(); // here it will not work like this
			
			sedao.searchASong(songTitle);
		}
		else if(input == 3)
		{
			sedao.showAllSongs();
		}
		else if(input == 4)
		{
			System.out.println("Press A to \"Add Song\"");
			System.out.println("Press B to \"Edit an existing Song\"");
			System.out.println("Press C to \"Delete an existing Song\"\n");
			
			String option = sc.next();
			
			if(option.equalsIgnoreCase("A"))
			{
				System.out.println("Enter song id");
				int songID = sc.nextInt();
				
				sc.nextLine();
				System.out.println("Enter song title");
				String songTitle = sc.nextLine();
				
				//sc.nextLine(); //use only one time
				System.out.println("Enter artist name");
				String artistName = sc.nextLine();
				
				
				System.out.println("Enter album name");
				String albumName = sc.nextLine();
				//sc.nextLine(); // here it will not work like this
				
				System.out.println("Enter song location");
				String songLocation = sc.nextLine();
				
				System.out.println("Enter description");
				String description=sc.nextLine();
				
				MusicBean mb = new MusicBean();
				
				mb.setSongID(songID);
				mb.setSongTitle(songTitle);
				mb.setArtistName(artistName);
				mb.setAlbumName(albumName);
				mb.setSongLocation(songLocation);
				mb.setDescription(description);
				
				String msg = sedao.addSong(mb);
				
				System.out.println(msg);
			}
			else if(option.equalsIgnoreCase("B"))
			{
				System.out.println("Enter song id");
				int songID = sc.nextInt();
				
				sc.nextLine();
				System.out.println("Enter song title");
				String songTitle = sc.nextLine();
				
				System.out.println("Enter artist name");
				String artistName = sc.nextLine();
				
				System.out.println("Enter album name");
				String albumName = sc.nextLine();
				
				System.out.println("Enter song location");
				String songLocation = sc.nextLine();
				
				System.out.println("Enter description");
				String description= sc.nextLine();
				
				MusicBean mb = new MusicBean();
				
				mb.setSongID(songID);
				mb.setSongTitle(songTitle);
				mb.setArtistName(artistName);
				mb.setAlbumName(albumName);
				mb.setSongLocation(songLocation);
				mb.setDescription(description);
				
				String msg = sedao.editSong(mb);
				
				System.out.println(msg);
				
			}
			else if(option.equalsIgnoreCase("C"))
			{
				System.out.println("Enter song id");
				int songID = sc.nextInt();
				
				String msg = sedao.deleteSong(songID);
				
				System.out.println(msg);
			}
		}
		else if(input == 5)
		{
			System.out.println("Exit from Music Player");
			System.exit(0);
		}
		sc.close();
		
	}//End of main method
	
}// End of class
