package com.nyist.plantsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createQRCode.do")
public class CreateQRCode extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uuidname = request.getParameter("uuidname");
	    System.out.println("createQRCode-uuidname:"+uuidname);
	    String url = request.getParameter("url");
	    Encoder encoder = new Encoder();
	    encoder.encoderQRCode(request,uuidname,java.net.URLDecoder.decode(uuidname,"UTF-8")+".html",response);
//	    request.getRequestDispatcher("/add.do").forward(request, response);
	  
//	    response.sendRedirect("/add.do");
	    /*PrintWriter outPrintWriter = response.getWriter();
	    outPrintWriter.print("<script type='text/javascript'>");
	    outPrintWriter.print("window.location.href='add.do'");
	    outPrintWriter.print("</script>");*/
	}
}
