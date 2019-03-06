package nyist.net.Library.view;

import java.io.IOException;
import java.io.PrintWriter;
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
public class SelectAsBookTypeAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String book_type=request.getParameter("book_type");
		//String book_name="励志";
		List<book> bk = libraryService.SelectAsBookType(book_type);
		System.out.println("bk:"+bk);
		for (book book : bk) {
			System.out.println(book);
		}
		System.err.println("boolean:"+bk.equals("[]"));
		if(!bk.equals("[]")){
			System.err.println("[12]");
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('对不起,没有该类型的图书!\n请核对后重新输入')");
			out.print("</script>");
			request.getSession(true).setAttribute("BookAsType",null);
		}
		request.getSession(true).setAttribute("BookAsType",libraryService.SelectAsBookType(book_type));
		request.getRequestDispatcher("/SelectBooksAsType.do").forward(request, response);
	}
}
