package com.manthan.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.user.bean.UserBean;
import com.manthan.user.dao.UserDao;
import com.manthan.user.util.UserDaoImplManager;

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {

	private UserDao udao = UserDaoImplManager.getDaoInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if(session != null)
		{
			UserBean ub = new UserBean();
			
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			
			ub.setUserName(userName);
			ub.setPassword(password);
			ub.setAge(age);
			ub.setGender(gender);
			
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
