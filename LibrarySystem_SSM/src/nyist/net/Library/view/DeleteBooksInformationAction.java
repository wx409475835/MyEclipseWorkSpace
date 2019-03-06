package nyist.net.Library.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class DeleteBooksInformationAction implements HttpRequestHandler {

	
	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		List<book> bk=libraryService.SelectBookAdId1(id);
		request.getSession().setAttribute("DeleteBooks",bk);
		String down=request.getParameter("down");
		request.getSession(true).setAttribute("down",down);
		System.out.println("down:"+down);	
		if(down!=null&&down!="[]"){
			String DeleteBook_ID=(String)request.getSession(true).getAttribute("DeleteBook_ID");
			System.out.println("down_Id:"+DeleteBook_ID);
			int i = libraryService.DeleteBooks(DeleteBook_ID);
			System.err.println("下架图书:"+i);
			request.getRequestDispatcher("/QY.do").forward(request, response);
		}else {
			request.getSession().setAttribute("DeleteBook_ID",id);
			request.getRequestDispatcher("/downbook.do").forward(request, response);
		}
	}

}
