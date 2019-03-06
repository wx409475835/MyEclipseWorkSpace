package nyist.net.Library.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import nyist.net.Library.entity.login_readperson;

@Component
public class RegisterAction implements HttpRequestHandler {
	
	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ident = request.getParameter("identified");
		login_readperson login_readperson = new login_readperson();
		login_readperson.setUsername(username);
		login_readperson.setPw(password);
		login_readperson.setPerson_id(null);
		login_readperson.setIdent(ident);
		libraryService.Register(login_readperson);
		
		out.print("<script type='text/javascript'>");
		out.print("window.location.href='http://localhost:8888/LibrarySystem_SSM/Login.do'");
		out.print("</script>");
	}

}
