package nyist.net.Library.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import nyist.net.Library.entity.book;
import nyist.net.Library.entity.bookperson;
import nyist.net.Library.entity.login_readperson;
import nyist.net.Library.entity.person_user;
import nyist.net.Library.entity.personread;

public interface LibraryService {
	/**
	 * 归还图书
	 * @param book_id
	 * @return
	 */
	public String ReturnBoooks(String book_count,String book_id);
	/**
	 * 查询所有图书的信息
	 * @return
	 */
	public List<book> SelectAllBook();
	/**
	 * 按照图书种类查询
	 * @param book_name
	 * @return
	 */
	public List<book> SelectAsBookType(String book_name);
	/**
	 * 添加/上架 图书信息
	 * @return
	 */
	public int InsertBooks(book bk);
	/**
	 * 下架/删除图书信息,
	 * @param book_id
	 * @return
	 */
	public int DeleteBooks(String book_id);
	/**
	 * 读者 登陆信息 的注册
	 * @param personname
	 * @param personpassword
	 * @return
	 */
	public int PersonRegister(bookperson bk);
	/**
	 * 注册
	 * @param login_readperson
	 * @return
	 */
	public int Register(login_readperson login_readperson);
	/**
	 * 读者的登陆
	 * @param usernam
	 * @param password
	 * @return
	 */
	public String Login(String username,String password,String ident);
	/**
	 * 读者的信息查询
	 * @param id
	 * @return
	 */
	public List<bookperson> SelectPerson(String id);
	/**
	 * 读者的借阅记录查询
	 * @return
	 */
	public List<personread> PersonReadInformation(String id);
	/**
	 * 读者 个人信息的注册
	 * @param bp
	 * @return
	 */
	public int InsertBookPersonInformation(bookperson bp);
	/**
	 * 借阅图书
	 * @param book_id
	 */
	public void BrrowBooks(String book_id);
	/**
	 * 按照ID查询图书
	 * @param book_id
	 * @return
	 */
	public book SelectBookAsId(String book_id); 
	/**
	 * 按照ID查询图书(返回List<book>)
	 * @param book_id
	 * @return
	 */
	public List<book> SelectBookAdId1(String book_id);
	/**
	 *个人借阅记录插入
	 * @param pd
	 * @return
	 */
	public void InsertPersonBrrowInfor(personread pd);
	/**
	 * 删除个人信息
	 * @param person_id
	 * @return
	 */
	public void DeleteMineInformation(String person_id);
	/**
	 * 修改个人信息
	 * @param bp
	 * @return
	 */
	public void AlterBookPersonInformations(bookperson bp);
	/**
	 * 修改用户名 和 密码
	 * @param username
	 * @param password
	 */
	public void AlterPassword(login_readperson lg);
	/**
	 * 查询单条借阅记录
	 */
	public personread SelectPersonOneBrrowInf(String book_id,String person_id);
	/**
	 * 生成借阅记录表
	 * @param book_id
	 */
	public void BrrowBooksInformation(String book_id,String person_id);
	/**
	 * 生成借阅记录表
	 * @param book_id
	 */
	public List<personread> SelectPersonOneBrrowInf1(String book_id);
	/**
	 * 修改图书信息
	 * @param bk
	 */
	public void updateBookInformation(book bk);
	/**
	 * 查找用户信息
	 * @param person_id
	 * @return
	 */
	public login_readperson SelectUser(String person_id);
	/**
	 * 插入信息到person_user
	 * @param pu
	 */
	public void InsertPerson_user(person_user pu);
	/**
	 * 通过person_id 和 book_id查找person_user中的记录
	 * @param person_id
	 * @param book_id
	 * @return
	 */
	public List<person_user> selectPerson_userByPer_bk(@Param("person_id")String person_id,@Param("book_id")String book_id);
	/**
	 * 修改 book_count属性,实现自加一
	 * @param person_id
	 * @param book_id
	 */
	public void updatePerson_user(@Param("person_id")String person_id,@Param("book_id")String book_id);
	/**
	 * 查询所有person_user中的信息
	 * @return
	 */
	public List<person_user> SelectAllPerson_UserInformations();
	/**
	 * 通过person_id 和 book_id查找person_user中的记录(返回person_user)
	 * @param person_id
	 * @param book_id
	 * @return
	 */
	public person_user selectPerson_userByPer_bk1(@Param("person_id")String person_id,@Param("book_id")String book_id);
	/**
	 * 删除 person_user中的信息
	 * @param person_id
	 * @param book_id
	 */
	public void DeletePerson_User(@Param("person_id")String person_id,@Param("book_id")String book_id);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<login_readperson> SelectUserByIdent();
	/**
	 * 通过person_id查找特定用户(u)的信息
	 * @param person_id
	 * @return
	 */
	public List<login_readperson> SelectUserById(String person_id);
	/**
	 * 修改用户
	 * @param person_id
	 */
	public void AlterPerson_User(login_readperson lp);
	/**
	 * 查询 用户 user
	 * @param person_id
	 * @return
	 */
	public login_readperson SelectPerson_User(String person_id);
	/**
	 * 从 login_readperson表通过person_id删除记录
	 * @param person_id
	 */
	public void DeleteFromLogin_ReadPerson(String person_id);
	/**
	 * 从 bookperson 表通过 主键删除记录
	 * @param person_id
	 */
	public void DeleteFromBookPerson(String person_id);
}
