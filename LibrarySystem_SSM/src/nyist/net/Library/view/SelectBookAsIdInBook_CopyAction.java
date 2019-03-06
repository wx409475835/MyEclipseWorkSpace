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
public class SelectBookAsIdInBook_CopyAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bk_id =request.getParameter("book_id");
		System.out.println("book_id:"+bk_id);
		List<personread> bk = libraryService.SelectPersonOneBrrowInf1(bk_id);
		System.out.println("SelectBookAsIdInBook_Copy-bk:"+bk);
		if(bk.equals("[]")){
			request.getSession(true).setAttribute("SelectBookAsIdInBook","NotBook");
			System.out.println(bk.equals("[]"));
			request.getRequestDispatcher("ReturnBooks.jsp").forward(request, response);
		}
		request.getSession(true).setAttribute("SelectBookAsIdInBook",bk);
		request.getRequestDispatcher("/ReturnBooks.do").forward(request, response);
	}

}
