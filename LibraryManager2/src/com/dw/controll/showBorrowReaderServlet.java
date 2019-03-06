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
 * Servlet implementation class showBorrowReaderServlet
 */
@WebServlet("/showBorrowReaderServlet")
public class showBorrowReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		BorrowDaoImpl Bd=new BorrowDaoImpl();
		 List list = Bd.bbListSelect();
	
				 String mainPage = "showBorrowReader.jsp";
				 request.setAttribute("list", list);
		 		 request.setAttribute("mainPage", mainPage);
		 		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		 		 dispatcher.forward(request, response);
			//}
		
		
		
		
	}

		
	}


