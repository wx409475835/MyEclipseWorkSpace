package com.nyist.cn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.nyist.cn.Utils.WebUtils;
import com.nyist.cn.domain.upfile;
import com.nyist.cn.service.BusinessServiceDao;
import com.nyist.cn.service.impl.BusinessService;

@WebServlet("/upfileservlet")
public class UpfileServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/addfile.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(ServletFileUpload.isMultipartContent(request)){
				request.setAttribute("message","不支持的操作");
		}
		try {
			String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
			upfile upfile = WebUtils.doUpload(request, savepath);
			//将数据保存到数据库
			BusinessServiceDao service = new BusinessService();
			service.addfile(upfile);
			request.setAttribute("message","上传成功!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message","上传失败");
		}		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
}
