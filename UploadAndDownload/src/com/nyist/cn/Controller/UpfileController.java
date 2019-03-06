package com.nyist.cn.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyist.cn.Service.UpfileService;
import com.nyist.cn.Utils.WebUtils;
import com.nyist.cn.model.Upfile;
@Controller
public class UpfileController {
	
	@Autowired
	private UpfileService upfileService ;
	/**
	 *  后台 jsp 页面访问
	 * @return
	 */
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("message")
	public String message(){
		return "message";
	}
	
	@RequestMapping("head")
	public String head(){
		return "head";
	}
	
	@RequestMapping("upload")
	public String upload(){
		return "upload";
	}
	
	@RequestMapping("showdownload")
	public String showdownload(){
		return "showdownload";
	}
	
	
	@RequestMapping("UploadAction")
	public void Upload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, IllegalAccessException, InvocationTargetException{
		//拿到前台传进来的数据   首先判断是否为mutipart/form-data提交方式
		if(!ServletFileUpload.isMultipartContent(request)){
			request.setAttribute("message","上传的不是为有效的数据类型");
			request.getRequestDispatcher("/message.apex").forward(request, response);
			return ;
		}
		//得到保存文件 的目录
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		//制作WebUtils 工具类  封装request 和  savepath
		Upfile upfile = WebUtils.doUpload(request,path);
		upfileService.addfile(upfile);
		System.out.println("Upfile:"+upfile);
		request.setAttribute("message","上传成功！");
		request.getRequestDispatcher("/message.apex").forward(request, response);
	}
	
	@RequestMapping("listfileAction")
	public void listfile(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String method = request.getMethod();
		if("GET".equals(method)){
			List<Upfile> list = upfileService.getAllFile();
			request.setAttribute("list",list);
			request.getRequestDispatcher("/showdownload.apex").forward(request, response);
			return ;
		}
	} 
	
	@RequestMapping("DownLoadAction")
	public void DownLoad(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		//拿到前台数据
		String id = request.getParameter("id");
		Upfile upfile = upfileService.findUpfile(id);
		System.out.println("Upfile:"+upfile);
		File file = new File(upfile.getSavepath()+File.separator+upfile.getUuidname());
		System.out.println("File:"+file);
		if(!file.exists()){
			request.setAttribute("message","下载资源已被删除");
			request.getRequestDispatcher("/message.apex").forward(request, response);
			return ;
		}
		response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(upfile.getFilename(),"UTF-8"));
		try {
			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();
			int len =0;
			byte buffer[] = new byte[1024];
			while((len = in.read(buffer))>0){
				out.write(buffer, 0, len);
			}
			in.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
