package com.nyist.cn.Servlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//下载文件
@WebServlet("/downloadservlet")
public class DownloadServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		//1.拿到服务器传过来的文件名称,改文件名成为UUID文件名称
		String filename = reqest.getParameter("filename");
		filename = new String(filename.getBytes("iso8859-1"),"UTF-8");					//解决get请求方式乱码
		System.out.println("filename:"+filename);
		//2.找出这个文件
		String downpath = this.getServletContext().getRealPath("/WEB-INF/upload")+File.separator+getpath(filename);
		System.out.println("downpath:"+downpath);
		//3.判断该文件是否存在
		File file = new File(downpath + File.separator + filename);
		if(!file.exists()){
			reqest.setAttribute("message","对不起,您要下载的资源已被删除!");
			reqest.getRequestDispatcher("/message.jsp").forward(reqest, response);
			return ;
		}
		
		//得到下载文件的原始文件名
		String oldname = file.getName().substring(file.getName().indexOf("_")+1);
		//需要浏览器  以下载的方式打开一下发送的数据
		System.out.println("oldname:"+oldname);
		response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(oldname,"UTF-8"));
		//文件存在   创建FileInputStream流读取文件
		FileInputStream in = new FileInputStream(file);
		int len = 0 ;
		byte buffer[] = new byte[1024];
		OutputStream out = response.getOutputStream();								//将读取的数据输出到response流中去
		while((len = in.read(buffer)) > 0){
			out.write(buffer,0,len);
		}
		in.close(); 																//切记一定要关闭 FileInputStream 流 不必关闭out流,因为....
	}
	
	public String getpath(String filename){
		//上传文件的时候,使用哈希算法 打散文件上传,下载的时候同样要使用哈希算法进行查找
		int hashcode = filename.hashCode();						//拿到该文件在内存中对应的哈希编码
		int dir1 = hashcode&15;									//一级目录
		int dir2 = (hashcode>>4)&0xf;							//二级目录
		return dir1 + File.separator + dir2;					//3/5
	}
}
