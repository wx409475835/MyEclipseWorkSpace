package nyist.net.Library.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class InsertBooksInformationAction implements HttpRequestHandler{

	@Autowired
	private LibraryService libraryService; 
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String book_name=request.getParameter("book_name");
		String book_type = request.getParameter("book_type");
		String price=request.getParameter("book_price");
		Double book_price=Double.parseDouble(price);
		String book_count=request.getParameter("book_count");
		String book_add = request.getParameter("book_add");
		book bk=new book();
		bk.setBook_id(null);
		bk.setBook_name(book_name);
		bk.setBook_type(book_type);
		bk.setBook_price(book_price);
		bk.setBook_count(book_count);
		bk.setBook_add(book_add);
		
		libraryService.InsertBooks(bk);
		request.getRequestDispatcher("/QY.do").forward(request, responce);
	}

}
