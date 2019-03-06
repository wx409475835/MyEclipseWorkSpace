package com.nyist.dbutils.dao;
import java.sql.Connection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.nyist.dbutils.Utils.JDBCUtil_c3p0;
import com.nyist.dbutils.model.Account;

public class AccountDao {
	
	private Connection conn;
	public AccountDao(Connection conn){
		this.conn=conn;
	}
	
	public AccountDao() {
		super();
	}

	public void update(Account a){
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "update account set money =? where id =?";
			System.out.println("D-money:"+a.getMoney());
			System.out.println("D-ID:"+a.getId());
			Object params[] = {a.getMoney(),a.getId()};
			//runner.update(conn, sql, params);
			runner.update(JDBCUtil_c3p0.getConnection(), sql,params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public Account find(int id){
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "select * from account where id = ?";
			//return (Account) runner.query(conn,sql,id,new BeanHandler(Account.class));
			//之前的那种方法从外部传进来一个数据库连接的做法已经不可取了,这里要手动获得Connection,获得的这个Connection也是当前线程绑定再
			//ThradLocal容器中Connection
			return (Account) runner.query(JDBCUtil_c3p0.getConnection(),sql,id,new BeanHandler(Account.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//从 a-->b转账100 元
		/*public void transfer() throws SQLException{
			Connection con = null;
			try{
				con = JDBCUtil_c3p0.getConnection();
				con.setAutoCommit(false);							//设置开启事务
				QueryRunner runner = new QueryRunner();
				String sql = "update account set money=money-100 where name='aaa'";
				runner.update(con,sql);
				
				String sql2 = "update account set money=money+100 where name='bbb'";
				runner.update(con,sql);
				con.commit();
				
			}finally{
				if(con!=null)
					con.close();
			}
		}*/
}
