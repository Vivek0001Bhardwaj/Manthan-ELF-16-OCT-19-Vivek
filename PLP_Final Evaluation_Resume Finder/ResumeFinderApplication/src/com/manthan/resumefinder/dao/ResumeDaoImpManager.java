package com.manthan.resumefinder.dao;

public class ResumeDaoImpManager {

	private ResumeDaoImpManager() {}
	
	public static ResumeDao getDaoInstance()
	{
		return new ResumeDaoImpl();
	}

}//End of ResumeDaoImpManager class
