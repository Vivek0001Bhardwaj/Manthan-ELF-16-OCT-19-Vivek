package com.manthan.shoppingapplication.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.shoppingapplication.bean.ProductBean;
import com.manthan.shoppingapplication.dao.ProductDao;
import com.manthan.shoppingapplication.util.ProductDaoImplManager;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	
	private ProductDao prddao = ProductDaoImplManager.getDaoInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			String productName = request.getParameter("searchPrd");
			
			ArrayList<ProductBean> arPB = prddao.getProducts(productName);
			
			request.setAttribute("msg", "Product Details Sent");
			request.setAttribute("pbList", arPB);
			request.getRequestDispatcher("/loginResultJsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Please Login First");
			request.getRequestDispatcher("/loginUserJsp").forward(request, response);
		}
	}

}
