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

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {

	private UserDao udao = UserDaoImplManager.getDaoInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if(session != null)
		{
			UserBean ub = new UserBean();
			
			int userId = Integer.parseInt(request.getParameter("userId"));
			String userName = request.getParameter("userName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			ub.setUserId(userId);
			ub.setUserName(userName);
			ub.setEmail(email);
			ub.setPassword(password);
			
			String msg = udao.registerUser(ub);
			
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Please Login First");
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
	}

}
