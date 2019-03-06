package com.nyist.cn.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listfileservlet")
public class ListFileServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//列出所有需要下载的文件
		//1.给出指定的文件下载路径
		String downpath = this.getServletContext().getRealPath("/WEB-INF/upload");				//找到文件的下载目录
		//2.将所有的文件列出来放到一个容器中
		Map map = new HashMap();																//使用map作为存放Servlet的容器
		//3.获得文件所有的文件递归添加到map容器中
		listfile(new File(downpath), map);
		//4.将map集合存在request作用域中,带给jsp页面进行显示
		request.setAttribute("map",map);
		request.getRequestDispatcher("/listfile.jsp").forward(request, response);
	}
	
	//多次递归共享同一个集合   解决递归资源统一放置的问题
	public void listfile(File file,Map map){
		if(!file.isFile()){
			File filechild[] = file.listFiles();												//如果不是文件,列出目录下的所有的文件
			for (File f : filechild) {
				listfile(f,map);
			}
		}else{
			String filename = file.getName().substring(file.getName().indexOf("_")+1);			//原始文件名
			map.put(file.getName(), filename);									//<a href="/servlet?filename=文件在服务器的名称">文件的原始文件名</a>
		}
	}
}
