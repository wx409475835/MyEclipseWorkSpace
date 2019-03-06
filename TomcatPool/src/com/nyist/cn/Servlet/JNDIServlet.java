package com.nyist.cn.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.Dao.JNDIDao;

@WebServlet("/servlet")
public class JNDIServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**配置Tomcat数据源的方法
	 * 1.在META-INF下面创建context.xml文件。
	 * 2.当Web容器启动的时候,会自动加载context.xml  生成DataSource 放到JNDI容器里边去
	 * 3.在Servlet程序中,我们通过  名称   获取在JNDI中相应的 数据源
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JNDIDao dao = new JNDIDao();
		try {
			dao.add();
		} catch (SQLException e) {
			throw  new RuntimeException(e);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
