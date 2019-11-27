package com.manthan.musicplayer.util;

import com.manthan.musicplayer.dao.MusicDao;
import com.manthan.musicplayer.dao.MusicDaoImpl;

public class MusicDaoImplManager {

	private MusicDaoImplManager() {}
	public static MusicDao getDaoInstance()
	{
		return new MusicDaoImpl();
	}

}//End of class
