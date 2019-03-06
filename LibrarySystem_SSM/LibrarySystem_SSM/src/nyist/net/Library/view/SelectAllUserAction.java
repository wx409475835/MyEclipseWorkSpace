package nyist.net.Library.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.login_readperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class SelectAllUserAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("======== 进入 SelectUser ========");
		List<login_readperson> ld= libraryService.SelectUserByIdent();
		System.out.println("===========ld:"+ld);
		request.getSession(true).setAttribute("SelectUser",ld);
		request.getRequestDispatcher("/SelectAllUser.do").forward(request, response);
	}

}
