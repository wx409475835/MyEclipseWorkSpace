package nyist.net.Library.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.personread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class ReturnBooksAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入--ReturnBooks");
		String person_id =(String)request.getSession(true).getAttribute("id");
		String book_id =request.getParameter("book_id"); 
		System.out.println("Return book_id:"+book_id);
		personread pd = libraryService.SelectPersonOneBrrowInf(book_id,person_id);		//通过图书ID 拿到这条记录    从而得到book_count 借阅数量
		libraryService.DeletePerson_User(person_id, book_id);							//通过person_id和book_id组合的逐渐删除person_user表中的唯一一条记录
		String em = libraryService.ReturnBoooks(pd.getBook_count(),book_id);
		System.out.println("Return_book_count:"+pd.getBook_count());
		System.out.println("ReturnBooks-em:"+em);
		request.getRequestDispatcher("/QY.do").forward(request, response);
	}

}
