package nyist.net.Library.view;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nyist.net.Library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class LoginAction implements HttpRequestHandler{
	
	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		String username=request.getParameter("username").trim();
		String pw=request.getParameter("password").trim();
		String identified =request.getParameter("identified");
		System.out.println("identified:"+identified);
		System.out.println("username:"+username);
		System.out.println("password:"+pw);
		String person_id = libraryService.Login(username,pw,identified);
		System.out.println("person_id:"+person_id);
		if(person_id==null){
			out.print("<script type='text/javascript'>");
			out.print("alert('Username Or Password or Identified Error!');");
			out.print("window.location.href='http://localhost:8888/LibrarySystem_SSM/Login.do'");
			out.print("</script>");
		}else{
			if(identified.equals("a")==true){
				HttpSession session =request.getSession();
				session.setAttribute("Login",username);
				session.setAttribute("id",person_id);
				session.setAttribute("ident",identified);
				out.print("<script type='text/javascript'>");
				out.print("alert('Login Success !');");
				out.print("window.location.href='http://localhost:8888/LibrarySystem_SSM/Main.do'");
				out.print("</script>");
			}else{
				HttpSession session =request.getSession();
				session.setAttribute("Login",username);
				session.setAttribute("id",person_id);
				session.setAttribute("ident",identified);
				out.print("<script type='text/javascript'>");
				out.print("alert('Login Success !');");
				out.print("window.location.href='http://localhost:8888/LibrarySystem_SSM/Main_u.do'");
				out.print("</script>");
			}
		}
	}

	
}
