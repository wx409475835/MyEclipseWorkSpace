package com.dw.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.BookDao;
import com.dw.dao.impl.BookDaoImpl;
/**
 * 控制层-删除业务逻辑处理 
 * @author bigshuai
 *
 */
public class DeleteServlet extends HttpServlet {

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
		BookDao bkdao = new BookDaoImpl();
	
		String id=request.getParameter("id");
		int d=Integer.parseInt(id);
		boolean flag=bkdao.delBook(d);
		//如果删除成功，返回到displaystudent.jsp页面，如果不成功，给用户提示信息
		if(flag){
			RequestDispatcher dispatch=request.getRequestDispatcher("showAllBooks");
			dispatch.forward(request, response);
		}else{
			 System.out.println("删除失敗!!");
		}
	}

}
