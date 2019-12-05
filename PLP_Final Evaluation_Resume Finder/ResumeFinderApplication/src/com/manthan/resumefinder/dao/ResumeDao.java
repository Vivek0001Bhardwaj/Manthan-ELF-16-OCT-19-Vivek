package com.manthan.resumefinder.dao;

import java.io.File;
import java.util.List;

public interface ResumeDao {

	public List<File> perform(String filePath,String searchText);
	
	public String getName(String mailId);
	
	public String getMail(File file);
	
}//End of ResumeDao interface
