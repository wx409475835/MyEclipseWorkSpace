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
 *  控制层 -更新逻辑处理
 * @author bisgahui
 * 
 */
public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int BookId = Integer.parseInt(request.getParameter("BookId"));
		String BookName = request.getParameter("BookName");
		String writer = request.getParameter("writer");
		String price = request.getParameter("price");
		Long num = Long.parseLong(request.getParameter("num"));
		String BookDept = request.getParameter("BookDept");
		String BookAddress = request.getParameter("BookAddress");
		Book stu = new Book(BookId, BookName, writer, price, num, BookDept,
				BookAddress);
		BookDao bkdao = new BookDaoImpl();

		boolean flag = bkdao.updateBook(stu);
		if (flag) {
			request.getRequestDispatcher("showAllBooks").forward(request,
					response);
		} else {
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
		}
	}

}
