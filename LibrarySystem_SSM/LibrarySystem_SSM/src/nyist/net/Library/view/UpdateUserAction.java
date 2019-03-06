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
public class UpdateUserAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String person_id=request.getParameter("id");	
		System.out.println("Upte==-===-=-=-=:"+person_id);
		login_readperson lp = libraryService.SelectPerson_User(person_id);
		request.getSession(true).setAttribute("UpdateUser",lp);
		request.getRequestDispatcher("/updateUser.do").forward(request, response);
	}

}
