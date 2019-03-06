package com.nyist.cn.Test;

import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.nyist.cn.Utils.JDBCUtil_dbcp;

public class JDBCPool implements DataSource{
	
	//使用集合  保存 一批连接
	public static LinkedList<Connection> list = new LinkedList<Connection>(){

		/**
		 * 
		 */
	private static final long serialVersionUID = 1L;};
	private static Properties properties = new Properties();
	static{
		try {
			properties.load(JDBCUtil_dbcp.class.getClassLoader().getResourceAsStream("src/db.properties"));
			Class.forName(properties.getProperty("driver"));
			for(int i=0;i<10;i++){
				Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
				list.add(connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 使用包装设计模式增强对象的需要增强的方法
	 * ①定义一个类,实现与被增强类相同的接口.
	   ②在类中定义一个变量,记住增强对象.
	   ③定义一个构造函数,接收增强对象.
	   ④覆盖增强的方法
	   ⑤对于不想增强的方法,直接调用目标对象(被增强对象)的方法
	 */
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		
		if(list.size()<=0){
			throw new RuntimeException("数据库忙,请稍后再来！");
		}
		Connection connection = list.removeFirst();
		//conn.close()
		/**
		 * 1.用一个connecter子类,覆盖close方法,增强close方法		使用与父类没有什么信息封装的时候
		 * 2.用包装设计模式
		 * 3.用动态代理
		 */
		MyConnection con = new MyConnection(connection);
		return con;
	}

	class MyConnection implements Connection{
		private Connection connection = null;
		public MyConnection(Connection connection){
			this.connection=connection;
		}
		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			return this.connection.unwrap(iface);
		}
		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return this.connection.isWrapperFor(iface);
		}
		@Override
		public Statement createStatement() throws SQLException {
			return this.connection.createStatement();
		}
		@Override
		public PreparedStatement prepareStatement(String sql) throws SQLException {
			return this.connection.prepareStatement(sql);
		}
		@Override
		public CallableStatement prepareCall(String sql) throws SQLException {
			return this.connection.prepareCall(sql);
		}
		@Override
		public String nativeSQL(String sql) throws SQLException {
			return this.connection.nativeSQL(sql);
		}
		@Override
		public void setAutoCommit(boolean autoCommit) throws SQLException {
			this.connection.setAutoCommit(autoCommit);
		}
		@Override
		public boolean getAutoCommit() throws SQLException {
			return this.connection.getAutoCommit();
		}
		@Override
		public void commit() throws SQLException {
			this.connection.commit();
		}
		@Override
		public void rollback() throws SQLException {
			this.connection.rollback();
		}
		@Override
		public void close() throws SQLException {
			list.add(this.connection);
		}
		@Override
		public boolean isClosed() throws SQLException {
			return this.connection.isClosed();
		}
		@Override
		public DatabaseMetaData getMetaData() throws SQLException {	
			return this.connection.getMetaData();
		}
		@Override
		public void setReadOnly(boolean readOnly) throws SQLException {
			this.connection.setReadOnly(readOnly);
		}
		@Override
		public boolean isReadOnly() throws SQLException {
			return this.connection.isReadOnly();
		}
		@Override
		public void setCatalog(String catalog) throws SQLException {
			this.connection.setCatalog(catalog);
		}
		@Override
		public String getCatalog() throws SQLException {
			return this.connection.getCatalog();
		}
		@Override
		public void setTransactionIsolation(int level) throws SQLException {
			this.connection.setTransactionIsolation(level);
			
		}
		@Override
		public int getTransactionIsolation() throws SQLException {
			return this.connection.getTransactionIsolation();
		}
		@Override
		public SQLWarning getWarnings() throws SQLException {
			return this.connection.getWarnings();
		}
		@Override
		public void clearWarnings() throws SQLException {
			this.connection.clearWarnings();
		}
		@Override
		public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
			return this.connection.createStatement();
		}
		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return this.connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
		}
		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return null;
		}
		@Override
		public Map<String, Class<?>> getTypeMap() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setHoldability(int holdability) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public int getHoldability() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public Savepoint setSavepoint() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Savepoint setSavepoint(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void rollback(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Clob createClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Blob createBlob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public NClob createNClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public SQLXML createSQLXML() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isValid(int timeout) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void setClientInfo(String name, String value) throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setClientInfo(Properties properties) throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String getClientInfo(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Properties getClientInfo() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setSchema(String schema) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String getSchema() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void abort(Executor executor) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public int getNetworkTimeout() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		} 
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		
		return null;
	}
	
}
