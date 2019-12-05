package com.manthan.resumefinder.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.resumefinder.dao.ResumeDao;
import com.manthan.resumefinder.dao.ResumeDaoImpManager;

@WebServlet("/SearchResumeServlet")
public class SearchResumeServlet extends HttpServlet {

	ResumeDao rdao = ResumeDaoImpManager.getDaoInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = getServletContext().getInitParameter("filePath");

		String searchText = request.getParameter("searchText");
		searchText = searchText.trim();

		List<File> af= new ArrayList<File>();
		List<String> userNames= new ArrayList<String>();
		List<String> userMails= new ArrayList<String>();
		
		if(!searchText.isEmpty())
		{	
			af = rdao.perform(filePath, searchText);
		}

		if(af!=null && !af.isEmpty())
		{
			for(File file : af)
			{
				String mailId = rdao.getMail(file);
				userMails.add(mailId);

				String uname = rdao.getName(mailId);
				userNames.add(uname);
			}
			request.setAttribute("userNames", userNames);
			request.setAttribute("userMails", userMails);
			request.setAttribute("filesList", af);
			request.setAttribute("message", "Message is not empty");
		}
		request.getRequestDispatcher("/searchResultJsp").forward(request, response);

	}//End of doPost method

}//End of SearchResumeServlet
