package nyist.net.Library.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nyist.net.Library.Service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class DeletePerson_UserAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String person_id = request.getParameter("id");
		libraryService.DeleteFromLogin_ReadPerson(person_id);
		libraryService.DeleteFromBookPerson(person_id);
		out.print("<script type='text/javascript'>");
		out.print("alert('删 除 用 户 成 功!');");
		out.print("window.location.href='http://localhost:8888/LibrarySystem_SSM//SelectAllUser.do'");
		out.print("</script>");
	}

}
