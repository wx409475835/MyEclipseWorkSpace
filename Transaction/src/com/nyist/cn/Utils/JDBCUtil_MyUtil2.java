package com.nyist.cn.Utils;
import java.util.List;

import org.junit.Test;

import com.nyist.cn.domain.Account;
import com.nyist.cn.Utils.JDBCUtil_Union.BeanHandler;
import com.nyist.cn.Utils.JDBCUtil_Union.BeanListHandler;
//类似于  Dao 
public class JDBCUtil_MyUtil2 {
	
	@Test
	public void test1(){
		Account a = new Account();
		a.setName("vvvvvv");
		a.setMoney(1000);
		add(a);
	}
	
	@Test
	public void test2(){
		Account a = new Account();
		a.setId(4);
		delete(a);
	}
	
	@Test
	public void test3(){
		Account a = new Account();
		a.setMoney(1000);
		a.setName("aaaaaaaaaaa");
		a.setId(5);
		update(a);
	}
	
	@Test
	public void test4(){
		int id = 3;
		Account account = find(id);
		System.out.println("ID:"+account.getId());
		System.out.println("Name:"+account.getName());
		System.out.println("Money:"+account.getMoney());
	}
	
	@Test
	public void test5(){
		List list = getAll();
		System.out.println(list);
	}
	
	public void add(Account a){
		String sql = "insert into account(name,money) values(?,?)";
		Object params[] = {a.getName(),a.getMoney()};
		JDBCUtil_Union.update(sql, params); 
	}
	
	
	public void delete(Account a){
		String sql = "delete from account where id = ?"; 
		Object params[] = {a.getId()};
		JDBCUtil_Union.update(sql, params);
	}
	
	
	public void update(Account a){
		String sql = "update account set name = ? , money = ? where id = ?";
		Object params[] = {a.getName(),a.getMoney(),a.getId()};
		JDBCUtil_Union.update(sql, params);
	}
	
	
	public Account find(int id){
		String sql = "select * from account where id =?";
		Object params[]={id};
		return (Account) JDBCUtil_Union.Query(sql, params,new BeanHandler(Account.class));
	}
	
	public List getAll(){
		String sql = "select * from account";
		Object params[] = {};
		return (List) JDBCUtil_Union.Query(sql, params, new BeanListHandler(Account.class));
	}
}
