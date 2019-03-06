package nyist.net.Library.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;

import nyist.net.Library.entity.bookperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class RegisterPersonAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String person_name = request.getParameter("person_name");
		String age =request.getParameter("person_age");
		int person_age =Integer.parseInt(age);
		String person_sex = request.getParameter("person_sex");
		String person_we= request.getParameter("person_we");
		String person_com = request.getParameter("person_com");
		String person_mobile = request.getParameter("person_mobile");
		String person_add = request.getParameter("person_add");
		System.out.println(person_name);
		System.out.println(person_age);
		System.out.println(person_sex);
		System.out.println(person_we);
		System.out.println(person_com);
		System.out.println(person_mobile);
		System.out.println(person_add);
		bookperson bk = new bookperson();
		bk.setPerson_name(person_name);
		bk.setPerson_age(person_age);
		bk.setPersong_sex(person_sex);
		bk.setPersong_we(person_we);
		bk.setPerson_com(person_com);
		bk.setPerson_mobile(person_mobile);
		bk.setPerson_add(person_add);
		libraryService.PersonRegister(bk);
		
		request.getRequestDispatcher("/Register_Personlogin.do").forward(request, response);
	}

}
