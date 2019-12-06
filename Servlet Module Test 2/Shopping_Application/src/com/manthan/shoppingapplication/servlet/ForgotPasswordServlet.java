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

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	
	private UserDao udao = UserDaoImplManager.getDaoInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if(session != null)
		{
			UserBean ub = new UserBean();

			int userId = Integer.parseInt(request.getParameter("userId"));
			String password = request.getParameter("password");
			String confPassword = request.getParameter("confPassword");

			ub.setUserId(userId);
			ub.setPassword(password);
			ub.setConfPassword(confPassword);

			if(password.equals(confPassword))
			{
				String msg = udao.resetPassword(ub);
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/loginUserJsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Password and Confirm-Password must be same");
				request.getRequestDispatcher("/fgtPassJsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("msg", "Please Login First");
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
	}

}
