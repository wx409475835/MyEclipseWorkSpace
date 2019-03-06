package com.nyist.dbutils.Demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.nyist.dbutils.Utils.JDBCUtil_c3p0;

public class Demo2 {
	
	/**
	 	ArrayHandler()
	 	Object:1
		Object:0aa@123.com
	 * @throws SQLException
	 */
	@Test
	public void test1() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user where id = ?";
		Object object[]=  (Object[]) runner.query(sql, 1, new ArrayHandler());
		System.out.println("Object:"+object[0]);
		System.out.println("Object:"+object[3]);
	}
	
	/**
	 	ArrayListHandler()
	 	List:[[Ljava.lang.Object;@57829d67, [Ljava.lang.Object;@19dfb72a, [Ljava.lang.Object;@17c68925]
	 * @throws SQLException
	 */
	@Test
	public void test2() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user";
		List list = (List)runner.query(sql,new ArrayListHandler());
		System.out.println("List:"+list);
	}
	
	/**
	 	ColumnListHandler()
	 	List:[0aa@123.com, 1aa@123.com, 2aa@123.com]
	 * @throws SQLException
	 */
	@Test
	public void test3() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user";
		List list = (List)runner.query(sql,new ColumnListHandler("email"));
		System.out.println("List:"+list);
	}
	
	/**
	 	KeyedHandler("key")
	 	ID:1
		birthday=2018-07-18
		password=123
		name=ccc
		id=1
		email=0aa@123.com
		ID:2
		birthday=2018-07-18
		password=123
		name=ccc
		id=2
		email=1aa@123.com
		ID:3
		birthday=2018-07-18
		password=123
		name=ccc
		id=3
		email=2aa@123.com
	 * @throws SQLException
	 */
	@Test
	public void test4() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user";
		Map<Integer,Map<String,Object>> map = (Map<Integer,Map<String,Object>>) runner.query(sql,new KeyedHandler("id"));
		for(Map.Entry<Integer,Map<String,Object>> me : map.entrySet()) {
			int id = me.getKey();
			System.out.println("ID:"+id);
			for(Map.Entry<String,Object> entry:me.getValue().entrySet()){
				String key = entry.getKey();
				Object object = entry.getValue();
				System.out.println(key + "=" +object);
			}
		}
	}
	
	/**
	 	MapHandler()
	 	birthday=2018-07-18
		password=123
		name=ccc
		id=3
		email=2aa@123.com
	 * @throws SQLException
	 */
	@Test
	public void test5() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user where id = ?";
		Map<String,Object> map = (Map) runner.query(sql,3,new MapHandler());
		for(Map.Entry<String,Object> me:map.entrySet()){
			String key = me.getKey();
			Object object = me.getValue();
			System.out.println(key+"="+object);
		}
	}
	
	/**
	 	MapListHandler()
	 	birthday=2018-07-18
		password=123
		name=ccc
		id=1
		email=0aa@123.com
		birthday=2018-07-18
		password=123
		name=ccc
		id=2
		email=1aa@123.com
		birthday=2018-07-18
		password=123
		name=ccc
		id=3
		email=2aa@123.com
	 * @throws SQLException
	 */
	@Test
	public void test6() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil_c3p0.getDataSource());
		System.out.println("runner:"+runner);
		String sql = "select * from user";
		List<Map<String,Object>> list = (List) runner.query(sql,new MapListHandler());
		for(int i=0;i<list.size();i++){
			Map<String,Object> map = list.get(i);
			for (Map.Entry<String,Object> entry:map.entrySet()) {
				String key = entry.getKey();
				Object object = entry.getValue();
				System.out.println(key+"="+object);
			}
		}
	}
}
