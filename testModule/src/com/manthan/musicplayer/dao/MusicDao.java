package com.manthan.musicplayer.dao;

import com.manthan.musicplayer.bean.MusicBean;

public interface MusicDao {

	public void playAllSong();
	public void playSongsRandomly();
	public void playParticularSong(int songID);
	public void searchASong(String songTitle);
	public void showAllSongs();
	public String addSong(MusicBean mb);
	public String editSong(MusicBean mb);
	public String deleteSong(int songID);
	
}//End of interface
