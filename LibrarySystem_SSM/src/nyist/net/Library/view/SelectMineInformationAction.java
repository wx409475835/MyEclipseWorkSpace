package nyist.net.Library.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.bookperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class SelectMineInformationAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=(String)request.getSession(true).getAttribute("id");
		System.out.println("person_id:"+id);
		List<bookperson> bk = libraryService.SelectPerson(id);
		request.getSession(true).setAttribute("Mine",libraryService.SelectPerson(id));
		System.out.println("++"+request.getSession(true).getAttribute("Mine"));
		System.out.println(bk);
		request.getRequestDispatcher("/Mine.do").forward(request, response);
	}

}
