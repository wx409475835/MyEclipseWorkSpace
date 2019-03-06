package com.dw.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.BookDao;
import com.dw.dao.impl.BookDaoImpl;
import com.dw.model.Book;

/**
 * @author bigshuai
 *@date 2017年5月15日
 *
 */
public class AddServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Student(stId,stName,stSex,stAge,stTel,stDept,stAddress)
		String BookName = request.getParameter("BookName");
		String writer = request.getParameter("writer");
		String price = request.getParameter("price");
		Long num = Long.parseLong(request.getParameter("num"));
		String BookDept = request.getParameter("BookDept");
		String BookAddress = request.getParameter("BookAddress");
		Book stu = new Book(BookName, writer, price, num, BookDept,
				BookAddress);
		BookDao bkdao = new BookDaoImpl();
		boolean flag = bkdao.addBook(stu);
		if (flag && !(num == null) && !"".equals(num)) {
			request.setAttribute("msg", "添加成功!!");
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
			System.out.println("添加失败!!");
		}

	}

}
