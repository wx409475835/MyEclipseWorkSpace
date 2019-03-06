package nyist.net.Library.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class AlterBookInformationAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String book_id = request.getParameter("book_id");
		List<book> bk = libraryService.SelectBookAdId1(book_id);
		System.out.println("AlterBookInformation:"+bk);
		request.getSession(true).setAttribute("BookInformations",bk);
		request.getSession(true).setAttribute("BookInformations_ID",book_id);
		request.getRequestDispatcher("/AlterBookInformation.do").forward(request, response);
	}

}
