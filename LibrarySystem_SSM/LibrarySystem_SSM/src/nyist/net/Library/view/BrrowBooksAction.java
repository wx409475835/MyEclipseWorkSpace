package nyist.net.Library.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.book;
import nyist.net.Library.entity.login_readperson;
import nyist.net.Library.entity.person_user;
import nyist.net.Library.entity.personread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class BrrowBooksAction implements HttpRequestHandler {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String book_id = request.getParameter("book_id");
		System.out.println("book_id:"+book_id);
		book bk = libraryService.SelectBookAsId(book_id);		//通过传递过来的参数拿到book_id   从而找到这条记录
		libraryService.BrrowBooks(book_id);                   //找到通过超链接传输过来的book_id 找到相应的记录  在新表插入这条记录
//		int i = libraryService.DeleteBooks(book_id);		  //在旧表中下架相应的图书信息
//		System.out.println("下架图书:"+i);
		String person_id=(String)request.getSession(true).getAttribute("id");	//获取person_id
		
		/**
		 * 找到这条记录后，插入到person_user表，首先获得person_id
		 */
		person_user pu =new person_user();
		book boo=libraryService.SelectBookAsId(book_id);
		login_readperson ld = libraryService.SelectUser(person_id);
		pu.setPerson_id(ld.getPerson_id());
		pu.setUsername(ld.getUsername());
		pu.setIdent(ld.getIdent());
		pu.setBook_id(boo.getBook_id());
		pu.setBook_name(boo.getBook_name());
		pu.setBook_type(boo.getBook_type());
		pu.setBook_price(boo.getBook_price());
		pu.setBook_count("1");
		pu.setBook_add(boo.getBook_add());
		request.getSession(true).setAttribute("selectAllBrrowInformation_person_id",person_id);
		request.getSession(true).setAttribute("selectAllBrrowInformation_book_id",book_id);
		System.out.println("BrrowBooks-pu:"+pu); 
		person_user pus=libraryService.selectPerson_userByPer_bk1(person_id,book_id);
		System.out.println("=============pus:"+pus);
		if(pus==null){
			libraryService.InsertPerson_user(pu);							//表中没有这个记录  插入这条记录
		}else{	
			libraryService.updatePerson_user(person_id, book_id);			//说明person_user表中有这条记录 自动加1
		}
		/*======================================================================*/
		personread pd = new personread();
		pd.setRead_id(null);
		pd.setPerson_id(person_id);
		pd.setBook_id(bk.getBook_id());
		pd.setBook_name(bk.getBook_name());
		pd.setBook_type(bk.getBook_type());
		pd.setBook_count("1");
		pd.setBook_add(bk.getBook_add());
		personread pds = libraryService.SelectPersonOneBrrowInf(book_id,person_id);
		if(pds!=null){
			libraryService.BrrowBooksInformation(book_id,person_id);		//记录表中有这条记录  自动加+1
		}else {
			libraryService.InsertPersonBrrowInfor(pd);			//将个人借阅记录 插入到相应的表
		}	
		request.getRequestDispatcher("/QY.do").forward(request,response);
	}
}
