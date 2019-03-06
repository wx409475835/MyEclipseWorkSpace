package com.nyist.SpringData.Repostiory;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.nyist.SpringData.Entity.Person;
/*
 * 1.Repositiory 是一个空接口,即是一个标记接口。
 * 2.若我们的接口继承了Repository,则该接口会被IOC容器识别为一个Repository Bean
 * 纳入到IOC容器中,进而可以在该接口中定义满足一定的规范方法。
 * 3.实际上  也可以通过一个注解 @RepositoryDefinition 来代替继承Repository 接口
 */
//Repostiory<Person,Integer> 需要处理的类型  主键类型
//@RepositoryDefinition(domainClass=Person.class,idClass=Integer.class)
/**
 * 在 Repository 子接口中声明方法
 * 1.不是随便声明的,而需要符合一定的规范
 * 2.按照 Spring Data 的规范，查询方法以 find | read | get 开头， 
 * 3.涉及条件查询时，条件的属性用条件关键字连接，
 * 4.要注意的是：条件属性以首字母大写。 
 * 5.若当前类又符合条件的属性优先使用,而不是用级联属性,若需要使用级联属性,则属性之间使用 _ 连接
 * @author LHG
 *
 */
public interface PersonRepostory extends Repository<Person,Integer>{
	//使用SpringData的给定的关键字  来查询
	Person getByLastName(String lastName);

	//WHERE lastName Like ?% And id < ?
	List<Person> getByLastNameStartingWithAndIdLessThan(String lastName,Integer id);
	
	//WHERE lastName Like %? and id < ?
	List<Person> getByLastNameEndingWithAndIdGreaterThan(String lastName,Integer id);
	
	//WHERE email IN(?,?,?) OR birth < ?
	List<Person> getByEmailInOrBirthLessThan(String email,Date birth);
	
	//WHERE a.id>?
	//级联属性  AddressId 首先在Person类中 找AddressId 如果找不到 去Address下找ID  级联属性
	List<Person> getByAddress_IdGreaterThan(Integer id);
	
	//查询ID值最大的那个Person
	//使用@Query注解 可以自定义JPQL 语句以实现更灵活的查询
	@Query("SELECT p FROM Person p WHERE p.id=(SELECT max(p2.id) FROM Person p2)")
	Person getMaxIdPerson();
	
	//为Qeury 注解传递参数的方式 ：使用占位符 
	@Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
	List<Person> testQueryAnnotationParms(String lastName,String email);
	
	//为Query 注解传递参数的方式:命名参数的方式
	@Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
	List<Person> testQueryAnnotationParms1(@Param("email") String email,@Param("lastName") String lastName);
	
	
	//SpringData 允许在占位符上添加%% 实际上也可以是命名参数
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email LIKE %?2%")
	List<Person> testQueryAnnotationLikeParm(String lastName,String email);
	
	//SpringData 允许在占位符上添加  命名参数的形式
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %:lastName% OR p.email LIKE %:email%")
	List<Person> testQueryAnnotationLikeParm2(@Param("email")String email,@Param("lastName")String lastName);
	
	//本地SQL查询
	//设置 nativeQuer=true 即可以使用原生的SQL查询
	@Query(value="SELECT count(id) FROM jpa_person",nativeQuery=true)
	long getTotalCount();
	
	
	//Modifying 标明 要做修改
	//可以通过自定义的JPQL　完成　UPDATE　和　DELETE　操作,注意：JPQL 不支持使用INSERT 
	//在Query注解中编写JPQL语句　但必须使用Modifying 注解,这是update 或 delete 操作
	//在 update 或 delete 操作时候需要使用事务,次似需要定义Service 层,在Service层的方法上添加事务操作。
	//默认情况下 SpringData 的每个方法上有事务,但都是只读事务,他们不能完成修改操作。
	@Modifying
	@Query("update Person p set p.email = :email where p.id = :id")
	void updatePersonEmail(@Param("id")Integer id,@Param("email")String email);
}
