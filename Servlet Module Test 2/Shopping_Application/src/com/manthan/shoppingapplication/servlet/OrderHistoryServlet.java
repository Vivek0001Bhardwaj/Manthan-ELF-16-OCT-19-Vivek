package com.manthan.shoppingapplication.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.shoppingapplication.bean.OrderBean;
import com.manthan.shoppingapplication.dao.OrderDao;
import com.manthan.shoppingapplication.util.OrderDaoImplManager;

@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
	
	private OrderDao ordao = OrderDaoImplManager.getDaoInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			int userId = (int) session.getAttribute("uId");
			
			ArrayList<OrderBean> arOB = ordao.getOrderHistory(userId);
			
			request.setAttribute("msg", "Order History");
			request.setAttribute("obList", arOB);
			request.getRequestDispatcher("/loginResultJsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Please Login First");
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
	}

}
