package com.manthan.shoppingapplication.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.shoppingapplication.bean.UserBean;
import com.manthan.shoppingapplication.dao.UserDao;
import com.manthan.shoppingapplication.util.UserDaoImplManager;

@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	
	private UserDao udao = UserDaoImplManager.getDaoInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(session != null)
		{	
			String msg = udao.authenticateUser(email, password);
			
			int countAttempt = udao.getCount(email);
			
			if(msg!=null && countAttempt<4)
			{
				UserBean userBean = udao.getUserDetails(email);
				session.setAttribute("uId", userBean.getUserId());
				session.setAttribute("empBean", userBean);
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/loginResultJsp").forward(request, response);
			}
			else
			{
				if(countAttempt<4)
				{
					++countAttempt;
					udao.setCount(email, countAttempt);
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
			udao.setCount(email, 0);
			request.setAttribute("msg", "Please Login First");
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
		
		
	}
}
