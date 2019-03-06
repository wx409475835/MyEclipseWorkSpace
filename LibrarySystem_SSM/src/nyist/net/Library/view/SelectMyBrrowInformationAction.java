package nyist.net.Library.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.personread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class SelectMyBrrowInformationAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String person_id=(String)request.getSession(true).getAttribute("id");	//获取person_id
		System.out.println("person_id:"+person_id);
		List<personread> pd = libraryService.PersonReadInformation(person_id);
		request.getSession(true).setAttribute("brrow",pd);
		System.out.println(pd);
		request.getRequestDispatcher("/MyBrrowInformation.do").forward(request, response);
	}

}
