package com.manthan.musicplayer.bean;

public class MusicBean {

	private int songID;
	private String songTitle;
	private String artistName;
	private String albumName;
	private String songLocation;
	private String description;
	
	public synchronized int getSongID() {
		return songID;
	}
	public synchronized void setSongID(int songID) {
		this.songID = songID;
	}
	public synchronized String getSongTitle() {
		return songTitle;
	}
	public synchronized void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public synchronized String getArtistName() {
		return artistName;
	}
	public synchronized void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public synchronized String getAlbumName() {
		return albumName;
	}
	public synchronized void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public synchronized String getSongLocation() {
		return songLocation;
	}
	public synchronized void setSongLocation(String songLocation) {
		this.songLocation = songLocation;
	}
	public synchronized String getDescription() {
		return description;
	}
	public synchronized void setDescription(String description) {
		this.description = description;
	}
	
	
}//End of class
