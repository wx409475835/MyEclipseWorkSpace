package day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CheckNameServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Thread.currentThread().sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		//1.收集数据
		String name = request.getParameter("name");
		System.out.println(name);
		//2.调用service	--- DAO
		request.setAttribute("name",name);
		if("suns".equals(name)){
			request.setAttribute("message","Your name is already usered please change!");
		}else{
			request.setAttribute("message","You name is OK");
		}

	}
}
