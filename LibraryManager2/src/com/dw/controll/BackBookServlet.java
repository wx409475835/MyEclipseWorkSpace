package com.dw.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.BorrowDaoImpl;

/**
 * Servlet implementation class BackBookServlet
 */
@WebServlet("/BackBookServlet")
public class BackBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		String username = (String) session.getAttribute("username");
		String id=request.getParameter("id");
		int d=Integer.parseInt(id);
		BorrowDaoImpl Bd=new BorrowDaoImpl();
		 boolean flag= Bd.backBook(username,d); 
		 List list = Bd.brListSelect(username);
		 if(flag){
			
			 System.out.print("¹é»¹³É¹¦£¡");
		 //request.getRequestDispatcher("usermain.jsp").forward(request,response);
		}else{
				System.out.println("¹é»³Ê§°Ü£¡");	 
			}
		
		 String mainPage = "displayBorrowBook.jsp";
		 request.setAttribute("list", list);
 		 request.setAttribute("mainPage", mainPage);
 		 RequestDispatcher dispatcher = request.getRequestDispatcher("usermain.jsp");
 		 dispatcher.forward(request, response);
		
		
		
		
	}

}
