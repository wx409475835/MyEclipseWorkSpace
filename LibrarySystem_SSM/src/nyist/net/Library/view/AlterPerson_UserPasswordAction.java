package nyist.net.Library.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.login_readperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class AlterPerson_UserPasswordAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String person_id =request.getParameter("id");
		System.out.println("username-password-person_id:"+username+password+person_id);
		login_readperson lg =new login_readperson(username, password, person_id); 
		System.out.println("lg:"+lg);
		libraryService.AlterPassword(lg);
		System.out.println("=================------------------------------========================");
		System.out.println("username:"+username+" person_id:"+person_id);
		libraryService.UpdatePerson_UserUsernameAndPassword(username, person_id);
		request.getRequestDispatcher("/QY.do").forward(request, response);
	}

}
