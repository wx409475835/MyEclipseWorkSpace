package day2.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import day2.Service.UserService;
import day2.Service.Impl.UserServcieImpl;

@SuppressWarnings("serial")
public class CheckNameAjaxServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------------");
		//1.收集数据
		String name = request.getParameter("name");
		UserService userService = new UserServcieImpl();
		String username=userService.queryUserByName(name);
		System.out.println("0---"+username);
		//2.调用Service --- DAO
		PrintWriter out = response.getWriter();
		if(username!=null){
			out.println("You name was alreay userd");
		}else{
			out.println("You Name is OK!");
		}
		out.flush();			//关闭输出流
	}
}
