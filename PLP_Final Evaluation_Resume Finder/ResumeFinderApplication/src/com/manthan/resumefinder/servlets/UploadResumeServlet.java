package com.manthan.resumefinder.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/UploadResumeServlet")
public class UploadResumeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
			File tmpDir = new File(getServletContext().getInitParameter("filePath"));

			if(!tmpDir.exists())
			{
				tmpDir.mkdir();
				System.out.println("Directory created");
			}

			MultipartRequest mr = new MultipartRequest(request,getServletContext().getInitParameter("filePath"));

			String fileName = mr.getOriginalFileName("file");

			if(fileName!=null && !fileName.isEmpty())
			{
				request.setAttribute("msg", "File Uploaded Successfully");
			}
			else
			{
				request.setAttribute("msg","No File found");
			}
		}
		catch (Exception ex)
		{
			request.setAttribute("msg", "File Upload Failed due to " + ex);
		}

		//Another method for uploading the file from browser to system

		//		if(ServletFileUpload.isMultipartContent(request))
		//		{
		//			try
		//			{
		//				List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		//				for(FileItem item : multiparts){
		//					if(!item.isFormField()){
		//						String name = new File(item.getName()).getName();
		//						item.write( new File("C:\\Users\\CBT\\Desktop\\Resumes" + File.separator + name));
		//					}
		//					//File uploaded successfully
		//					request.setAttribute("msg", "File Uploaded Successfully");
		//				}
		//			}
		//			catch (Exception ex)
		//			{
		//				request.setAttribute("msg", "File Upload Failed due to " + ex);
		//			}         		
		//		}
		//		else
		//		{
		//
		//			request.setAttribute("msg","No File found");
		//		}

		request.getRequestDispatcher("/uploadResumeJsp").forward(request, response);

	}//End of doPost method

}//End of UploadResumeServlet
