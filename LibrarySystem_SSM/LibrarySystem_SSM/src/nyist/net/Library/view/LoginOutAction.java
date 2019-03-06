package nyist.net.Library.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class LoginOutAction implements HttpRequestHandler {
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession(true).removeAttribute("Login");
		request.getSession(true).removeAttribute("id");
		request.getSession(true).removeAttribute("book");
		request.getSession(true).removeAttribute("BookAsType");
		request.getSession(true).removeAttribute("SelectBookAsIdInBook");
		request.getSession(true).removeAttribute("Mine");
		request.getSession(true).removeAttribute("brrow");
		request.getSession(true).removeAttribute("DeleteBooks");
		request.getSession(true).removeAttribute("DeleteBook_ID");
		request.getSession(true).removeAttribute("down");
		request.getSession(true).removeAttribute("selectAllBrrowInformation_person_id");
		request.getSession(true).removeAttribute("selectAllBrrowInformation_book_id");
		request.getSession(true).removeAttribute("pu");
		request.getSession(true).removeAttribute("SelectUser");
		request.getSession(true).removeAttribute("SelectUserById");
		request.getSession(true).removeAttribute("UpdateUser");
		request.getRequestDispatcher("/Login.do").forward(request, response);
	}

}
