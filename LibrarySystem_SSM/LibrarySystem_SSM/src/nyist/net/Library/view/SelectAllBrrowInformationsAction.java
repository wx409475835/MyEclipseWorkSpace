package nyist.net.Library.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.person_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class SelectAllBrrowInformationsAction implements HttpRequestHandler {
	
	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<person_user> pu = libraryService.SelectAllPerson_UserInformations();
		System.out.println("SelectAllBrrowInformationsAction:"+pu);
		request.getSession(true).setAttribute("pu",pu);
		request.getRequestDispatcher("/SelectAllBrrowInformations.do").forward(request, response);
	}

}
