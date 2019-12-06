package com.manthan.shoppingapplication.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.shoppingapplication.dao.OrderDao;
import com.manthan.shoppingapplication.dao.ProductDao;
import com.manthan.shoppingapplication.util.OrderDaoImplManager;
import com.manthan.shoppingapplication.util.ProductDaoImplManager;

@WebServlet("/OrderProductServlet")
public class OrderProductServlet extends HttpServlet {
	
	private ProductDao prddao = ProductDaoImplManager.getDaoInstance();
	private OrderDao ordao = OrderDaoImplManager.getDaoInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			double price = 0;
			
			int productId = Integer.parseInt(request.getParameter("prdID"));
			
			int  userId = (int) session.getAttribute("uId");
			
			double productCost = prddao.getProductCost(productId);
			
			if(productCost<100)
			{
				price = productCost+50;
			}
			else if(productCost>100 && productCost<500)
			{
				price = productCost+25;
			}
			else if(productCost>500)
			{
				price = productCost;
			}
			
			String msg = ordao.addToCart(productId, userId, price);
			
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/loginResultJsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Please Login First");
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
	}

}
