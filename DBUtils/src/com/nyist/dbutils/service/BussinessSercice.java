package com.nyist.dbutils.service;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import com.nyist.dbutils.Utils.JDBCUtil_c3p0;
import com.nyist.dbutils.dao.AccountDao;
import com.nyist.dbutils.model.Account;

public class BussinessSercice {
	
	@Test
	public void test1() throws SQLException{
		transfer2(2, 1, 200);
	}
	
	
	public void transfer1(int sourceid,int targerid,double money) throws SQLException{
		Connection conn = null;
		try{
			conn = JDBCUtil_c3p0.getConnection();				//拿到数据库链接
			conn.setAutoCommit(false); 							//开启事务
			
			AccountDao dao = new AccountDao(conn);
			Account saccount =dao.find(sourceid);
			Account taccount =dao.find(targerid);
			saccount.setMoney(saccount.getMoney()-money);
			taccount.setMoney(taccount.getMoney()+money);
			dao.update(taccount);
			dao.update(saccount);
			conn.commit();
		}finally{
			if(conn != null)
				conn.close();
		}
	}
	
	//用上ThreadLoca2
	public void transfer2(int sourceid,int targerid,double money) throws SQLException{
		try{
			//1.上来先开启事务
			JDBCUtil_c3p0.startTransaction();
			//2.调用Dao
			AccountDao dao = new AccountDao();
			Account saccount =dao.find(sourceid);
			Account taccount =dao.find(targerid);
			saccount.setMoney(saccount.getMoney()-money);
			taccount.setMoney(taccount.getMoney()+money);
			dao.update(taccount);
			dao.update(saccount);
			//3.提交事务
			JDBCUtil_c3p0.commitTransaction();
		}finally{
			//4.关闭连接
			JDBCUtil_c3p0.closeConnection();
		}
	}
}
