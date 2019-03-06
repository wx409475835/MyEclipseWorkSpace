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
import com.dw.dao.impl.BookDaoImpl;
import com.dw.dao.impl.BorrowDaoImpl;
import com.dw.model.Book;

public class UserBorrowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.print("hello\n");

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		String id = request.getParameter("id");
		int d = Integer.parseInt(id);
		BorrowDao Bd = new BorrowDaoImpl();
		int flag = Bd.borrowBook(name, d);
		BookDaoImpl bn = new BookDaoImpl();
		List list = bn.StSelect();
			String mainPage=""; 
		if (flag==2) {

			 mainPage = "displayUser.jsp";
			request.setAttribute("list", list);

		} else if(flag==3){
			// System.out.println("ΩË‘ƒ ßî°!!");
				mainPage = "BorrowShowNo.jsp";

		}else if(flag==4){
		 mainPage="BackShow.jsp";
				
		}else if(flag==1)
		{
			//System.out.print("ΩË‘ƒÕº È¥Ê‘⁄“Ï≥££°");//flag==1
			mainPage = "BorrowShowNo.jsp";
		}
		
		request.setAttribute("mainPage", mainPage);
		request.getRequestDispatcher("usermain.jsp").forward(request, response);

	}

}
