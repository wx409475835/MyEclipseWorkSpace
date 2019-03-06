package nyist.net.Library.Dao;

import java.util.List;

import nyist.net.Library.entity.book;
import nyist.net.Library.entity.bookperson;
import nyist.net.Library.entity.login_readperson;
import nyist.net.Library.entity.person_user;
import nyist.net.Library.entity.personread;

import org.apache.ibatis.annotations.Param;

public interface LibraryMapper {
	/**
	 * 查询所有图书信息
	 * @return
	 */
	public List<book> QueryAllBookInformation();
	/**
	 * 按照书籍种类查询
	 * @return
	 */
	public List<book> QueryBookType(String book_type);
	/**
	 * 插入书籍信息
	 * @return
	 */
	public void InsertBookInformation(book bk);
	/**
	 * 删除 加入图书馆出错的图书信息
	 * @param book_id
	 */
	public void DeleteBookInformation(String book_id);
	/**
	 * 注册
	 * @param login_readperson
	 * @return
	 */
	public int Register(login_readperson login_readperson);
	/**
	 * 读者 用户登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public String Login(@Param(value="username")String username,@Param(value="pw")String pw,@Param(value="ident")String ident);
	/**
	 * 读者 用户的注册
	 * @param username
	 * @param pw
	 * @return
	 */
	public int PersonRegister(bookperson bk);
	/***
	 * 读者 查询个人信息
	 * @param id
	 * @return
	 */
	public List<bookperson> SelectMineInformation(String id);
	/**
	 * 读者 信息的插入
	 * @param bp
	 * @return
	 */
	public int InsertBookPersonInformation(bookperson bp);
	/**
	 * 修改读者信息
	 * @param bp
	 * @return
	 */
	public int AlterBookPersonInformations(bookperson bp);
	/**
	 * 归还图书
	 * @param book_id
	 * @return
	 */
	public void ReturnBookToLibrary(@Param("book_count")String book_count,@Param("book_id")String book_id);
	/**
	 * 借阅图书
	 * @param id
	 */
	public void BrrowBooks(String book_id);
	/**
	 * 按照Id 查询图书
	 * @param id
	 * @return
	 */
	public book SelectBookAsId(String book_id); 
	/**
	 * 按照ID 查询图书(返回book集合)
	 * @param book_id
	 * @return
	 */
	public List<book> SelectBookAsId1(String book_id); 
	/**
	 * 个人借阅记录
	 * @param person_id
	 */
	public List<personread> PersonBrrowRecord(String person_id);
	/**
	 * 个人借阅记录插入
	 * @return
	 */
	public void InsertPersonBrrowInformation(personread pd);
	
	/**
	 * 删除个人信息
	 * @param person_id
	 */
	public void DeleteMineInformation(String person_id);
	/**
	 * 修改用户名 和 密码
	 * @param lg
	 */
	public void AlterPassword(login_readperson lg);
	/**
	 * 通过id删除借阅记录
	 * @param person_id
	 */
	public void DeleteBrrowInformation(String book_id);
	/**
	 * 查询某条借阅记录
	 * @param book_id
	 * @param person_id
	 * @return
	 */
	public personread SelectPersonOneBrrowInf(@Param("book_id")String book_id,@Param("person_id")String person_id);
	/**
	 * 生成借阅记录表 
	 * @param book_id
	 */
	public void BrrowBooksInformation(@Param("book_id")String book_id,@Param("person_id")String person_id);
	/**
	 * 查询一条记录
	 * @param book_ik
	 */
	public List<personread> SelectPersonOneBrrowInf1(String book_ik);
	/**
	 * 修改图书信息
	 * @param bk
	 */
	public void updateBooksInformation(book bk);
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
	/**
	 * 联表person_user 更新操作
	 * @param username
	 * @param person_id
	 */
	public void UpdatePerson_UserUsernameAndPassword(@Param("username")String username,@Param("person_id")String person_id);
}
