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
public class AlterMineInformationAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=(String)request.getSession(true).getAttribute("id");
		String name=request.getParameter("name");
		String person_age=request.getParameter("age");
		int age =Integer.parseInt(person_age);
		String sex=request.getParameter("sex");
		String we=request.getParameter("we");
		String com=request.getParameter("com");
		String phone=request.getParameter("phone");
		String add= request.getParameter("add");
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		System.out.println(sex);
		System.out.println(we);
		System.out.println(com);
		System.out.println(phone);
		System.out.println(add);
		
		bookperson bp = new bookperson();
		bp.setPerson_id(id);
		bp.setPerson_name(name);
		bp.setPerson_age(age);
		bp.setPerson_sex(sex);
		bp.setPersong_we(we);
		bp.setPerson_com(com);
		bp.setPerson_mobile(phone);
		bp.setPerson_add(add);
		System.out.println("AlterMineInformation:"+id);
//		libraryService.DeleteMineInformation(id);
		libraryService.AlterBookPersonInformations(bp);
		request.getRequestDispatcher("/QY.do").forward(request, response);
	}

}
