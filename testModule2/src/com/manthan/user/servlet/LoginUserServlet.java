package com.manthan.user.servlet;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.user.bean.UserBean;
import com.manthan.user.dao.UserDao;
import com.manthan.user.util.UserDaoImplManager;

@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {

	private UserDao udao = UserDaoImplManager.getDaoInstance();

	//int countAttempt =0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(session != null)
		{	
			String msg = udao.authenticateUser(userName, password);
			int countAttempt = udao.getCount(userName);
			if(msg!=null && countAttempt<4)
			{
				ArrayList<UserBean> ar = udao.displayUser(userName);
				request.setAttribute("msg", msg);
				request.setAttribute("arUb", ar);
				request.getRequestDispatcher("/loginResultJsp").forward(request, response);
			}
			else
			{
				if(countAttempt<4)
				{
					++countAttempt;
					udao.setCount(userName, countAttempt);
					//System.out.println("In "+countAttempt);
					request.getRequestDispatcher("/loginUserJsp").forward(request, response);
				}
				else
				{
					session.setMaxInactiveInterval(10);
					response.sendRedirect("./crossedLimitJsp");
				}
			}
		}
		else
		{
			udao.setCount(userName, 0);
			request.setAttribute("msg", "Please Login First");
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
		
		
	}
}
