package com.dw.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.BorrowDao;
import com.dw.dao.impl.BorrowDaoImpl;

public class ShowBorrowBook extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		String username = (String) session.getAttribute("username");
		//String id=request.getParameter("id");
		//int d=Integer.parseInt(id);
		BorrowDaoImpl Bd=new BorrowDaoImpl();
		 //boolean flag= Bd.backBook(name,d); 
		 List list = Bd.brListSelect(username);
//		 if(flag){
//			
//			 request.getRequestDispatcher("usermain.jsp").forward(request,
//						response);
//			}else{
				
				 String mainPage = "displayBorrowBook.jsp";
				 request.setAttribute("list", list);
		 		 request.setAttribute("mainPage", mainPage);
		 		RequestDispatcher dispatcher = request.getRequestDispatcher("usermain.jsp");
		 		 dispatcher.forward(request, response);
			//}
		
		
		
		
	}

}
