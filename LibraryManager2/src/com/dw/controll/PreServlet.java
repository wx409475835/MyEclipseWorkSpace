package com.dw.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.BookDao;
import com.dw.dao.impl.BookDaoImpl;
import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.Book;
import com.dw.model.User;

/**
 * �߼�����ҳ����ת
 * @author bisghaui
 * 
 */
public class PreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = (String) request.getParameter("method");
		if ("bookAdd".equals(method)) {
			BookAdd(request, response);
		} else if ("updateStudent".equals(method)) {
			updateBook(request, response);
		}else if("preupdatetepwd".equals(method)){
			preupdatetepwd(request, response);
		}else if(method==null){
			updatetepwd(request, response);
		}
	}
	/**
	 * ���ѧ������Ϣǰ-ʵ��ҳ����ת
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void BookAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mainPage = "bookAdd.jsp";
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * ����ѧ������Ϣǰ-�Ȳ�ѯ���û�����Ϣ����ʵ��ҳ����ת
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BookDao bkdao = new BookDaoImpl();
		int ids = Integer.parseInt(id);
		Book book = bkdao.findBookByid(ids);
		request.setAttribute("book", book);
		String mainPage = "bookUpdate.jsp";
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * ���Ĺ���Ա����-ʵ��ҳ����ת
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void preupdatetepwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mainPage = "updatepwd.jsp";
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * ���Ĺ���Ա����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatetepwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("username");
		 String repassword=request.getParameter("repassword");
		 User user=new User(username,repassword);
		 UserDaoImpl userdao=new UserDaoImpl();
		 int a=userdao.updateUserPassWord(user);
		 if(a!=0){
			 String mainPage = "updatepwdSuccess.jsp";
			 request.setAttribute("mainPage", mainPage);
		 }else{
			 request.setAttribute("error", "����ʧ��");
		 }
		    RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
	}
	
	
}
