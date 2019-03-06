package com.nyist.cn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nyist.cn.domain.upfile;
import com.nyist.cn.service.BusinessServiceDao;
import com.nyist.cn.service.impl.BusinessService;

public class DownLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		BusinessServiceDao service = new BusinessService();
		upfile upfile = service.findupfile(id);
		File file = new File(upfile.getSavepath() + "\\" + upfile.getUuidname());
		if(!file.exists()){
			request.setAttribute("message", "上传失败");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(upfile.getFilename(),"UTF-8"));
		FileInputStream in = new FileInputStream(file);
		int len = 0;
		byte buffer[] = new byte[1024];
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
