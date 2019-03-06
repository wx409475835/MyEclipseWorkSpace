package nyist.net.Library.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyist.net.Library.Dao.LibraryMapper;
import nyist.net.Library.Service.LibraryService;
import nyist.net.Library.entity.book;
import nyist.net.Library.entity.bookperson;
import nyist.net.Library.entity.login_readperson;
import nyist.net.Library.entity.person_user;
import nyist.net.Library.entity.personread;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryMapper libraryMapper;
	
	@Override
	public String ReturnBoooks(String book_count, String book_id) {
		String ef;
		try {
			libraryMapper.ReturnBookToLibrary(book_count, book_id);
			libraryMapper.DeleteBrrowInformation(book_id);
			ef="归还成功";
		} catch (Exception e) {
			e.printStackTrace();
			ef="归还失败";
		}
		return ef;
	}

	@Override
	public List<book> SelectAllBook() {
		List<book> bk=null;
		try {
			bk = libraryMapper.QueryAllBookInformation();
		} catch (Exception e) {
			e.printStackTrace();
			bk=null;
		}
		return bk;
	}

	@Override
	public List<book> SelectAsBookType(String book_name) {
		List<book> pd = null;
		try {
			pd = libraryMapper.QueryBookType(book_name);
		} catch (Exception e) {
			e.printStackTrace();
			pd=null;
		}
		return pd;
	}

	@Override
	public int InsertBooks(book bk) {
		try {
			libraryMapper.InsertBookInformation(bk);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int DeleteBooks(String book_id) {
		try {
			libraryMapper.DeleteBookInformation(book_id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int PersonRegister(bookperson bk) {
		try {
			libraryMapper.PersonRegister(bk);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int Register(login_readperson login_readperson) {
		try {
			libraryMapper.Register(login_readperson);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public String Login(String username, String password, String ident) {
		String person_id=null;
		try {
			person_id=libraryMapper.Login(username, password, ident);
		} catch (Exception e) {
			e.printStackTrace();
			person_id=null;
		}
		return person_id;
	}

	@Override
	public List<bookperson> SelectPerson(String id) {
		List<bookperson> pd = null;
		try {
			pd=libraryMapper.SelectMineInformation(id);
		} catch (Exception e) {
			e.printStackTrace();
			pd=null;
		}
		return pd;
	}

	@Override
	public List<personread> PersonReadInformation(String id) {
		List<personread> pd = null;
		try {
			pd=libraryMapper.PersonBrrowRecord(id);
		} catch (Exception e) {
			e.printStackTrace();
			pd=null;
		}
		return pd;
	}

	@Override
	public int InsertBookPersonInformation(bookperson bp) {
		try {
			libraryMapper.InsertBookPersonInformation(bp);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public void BrrowBooks(String book_id) {
		try {
			libraryMapper.BrrowBooks(book_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public book SelectBookAsId(String book_id) {
		book bk=null;
		try {
			bk=libraryMapper.SelectBookAsId(book_id);
		} catch (Exception e) {
			e.printStackTrace();
			bk=null;
		}
		return bk;
	}

	@Override
	public List<book> SelectBookAdId1(String book_id) {
		List<book> bk = null;
		try {
			bk=libraryMapper.SelectBookAsId1(book_id);
		} catch (Exception e) {
			e.printStackTrace();
			bk=null;
		}
		return bk;
	}

	@Override
	public void InsertPersonBrrowInfor(personread pd) {
		try {
			libraryMapper.InsertPersonBrrowInformation(pd);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void DeleteMineInformation(String person_id) {
		try {
			libraryMapper.DeleteMineInformation(person_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void AlterBookPersonInformations(bookperson bp) {
		try {
			libraryMapper.AlterBookPersonInformations(bp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void AlterPassword(login_readperson lg) {
		try {
			libraryMapper.AlterPassword(lg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public personread SelectPersonOneBrrowInf(String book_id, String person_id) {
		personread pd = null;
		try {
			pd=libraryMapper.SelectPersonOneBrrowInf(book_id, person_id);
		} catch (Exception e) {
			e.printStackTrace();
			pd=null;
		}
		return pd;
	}

	@Override
	public void BrrowBooksInformation(String book_id, String person_id) {
		try {
			libraryMapper.BrrowBooksInformation(book_id, person_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<personread> SelectPersonOneBrrowInf1(String book_id) {
		List<personread> pd=null;
		try {
			pd=libraryMapper.SelectPersonOneBrrowInf1(book_id);
		} catch (Exception e) {
			e.printStackTrace();
			pd=null;
		}
		return pd;
	}

	@Override
	public void updateBookInformation(book bk) {
		try {
			libraryMapper.updateBooksInformation(bk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public login_readperson SelectUser(String person_id) {
		login_readperson ld = null;
		try {
			ld = libraryMapper.SelectUser(person_id);
		} catch (Exception e) {
			e.printStackTrace();
			ld=null;
		}
		return ld;
	}

	@Override
	public void InsertPerson_user(person_user pu) {
		try {
			libraryMapper.InsertPerson_user(pu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<person_user> selectPerson_userByPer_bk(String person_id,String book_id) {
		List<person_user> pu = null;
		try {
			pu=libraryMapper.selectPerson_userByPer_bk(person_id, book_id);
		} catch (Exception e) {
			e.printStackTrace();
			pu=null;
		}
		return pu;
	}

	@Override
	public void updatePerson_user(String person_id, String book_id) {
		libraryMapper.updatePerson_user(person_id, book_id);
	}

	@Override
	public List<person_user> SelectAllPerson_UserInformations() {
		List<person_user> pu =null;
		try {
			pu=libraryMapper.SelectAllPerson_UserInformations();
		} catch (Exception e) {
			e.printStackTrace();
			pu=null;
		}
		return pu;
	}

	@Override
	public person_user selectPerson_userByPer_bk1(String person_id,String book_id) {
		person_user pu=null;
		try {
			pu=libraryMapper.selectPerson_userByPer_bk1(person_id, book_id);
		} catch (Exception e) {
			e.printStackTrace();
			pu=null;
		}
		return pu;
	}

	@Override
	public void DeletePerson_User(String person_id, String book_id) {
		libraryMapper.DeletePerson_User(person_id, book_id);
	}

	@Override
	public List<login_readperson> SelectUserByIdent(){
		List<login_readperson> ld=null;
		try {
			ld=libraryMapper.SelectUserByIdent();
		} catch (Exception e) {
			e.printStackTrace();
			ld=null;
		}
		return ld;
	}

	@Override
	public List<login_readperson> SelectUserById(String person_id) {
		List<login_readperson> lp=null;
		try {
			lp=libraryMapper.SelectUserById(person_id);
		} catch (Exception e) {
			e.printStackTrace();
			lp=null;
		}
		return lp;
	}

	@Override
	public void AlterPerson_User(login_readperson lp) {
		libraryMapper.AlterPerson_User(lp);
	}

	@Override
	public login_readperson SelectPerson_User(String person_id) {
		login_readperson lp=null;
		try {
			lp=libraryMapper.SelectPerson_User(person_id);
		} catch (Exception e) {
			e.printStackTrace();
			lp=null;
		}
		return lp;
	}

	@Override
	public void DeleteFromLogin_ReadPerson(String person_id) {
		libraryMapper.DeleteFromLogin_ReadPerson(person_id);
	}

	@Override
	public void DeleteFromBookPerson(String person_id) {
		libraryMapper.DeleteFromBookPerson(person_id);
	}
}
