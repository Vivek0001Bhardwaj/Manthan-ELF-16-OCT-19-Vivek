package com.manthan.resumefinder.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter();  
		String filename = request.getParameter("fileName"); 
		String filepath = getServletContext().getInitParameter("filePath")+"\\";  

		if(filename.contains("pdf"))
			response.setContentType("APPLICATION/pdf");
		else
			response.setContentType("APPLICATION/doc");
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+ filename + "\"");

		FileInputStream fileInputStream = new FileInputStream(filepath + filename);

		int i;
		while ((i = fileInputStream.read()) != -1) {
			pw.write(i);
		}

		fileInputStream.close();
		pw.close();
	
	}//End of doGet method

}//End of DownloadFileServlet
