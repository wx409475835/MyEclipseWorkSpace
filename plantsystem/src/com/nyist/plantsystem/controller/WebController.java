package com.nyist.plantsystem.controller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.nyist.plantsystem.model.PageBean;
import com.nyist.plantsystem.model.loginAccount;
import com.nyist.plantsystem.service.plantSystemService;

@Controller
public class WebController {
    @Autowired
    private plantSystemService plantSystemService;
    @RequestMapping("test")
    public String Test(){
    	return "test2";
    }
    //错误页面处理
    @RequestMapping("404")
    public String four(){
    	return "404";
    }
    @RequestMapping("400")
    public String fourZero(){
    	return "400";
    }
    @RequestMapping("500")
    public String five(){
    	return "500";
    }
    @RequestMapping("403")
    public String fourtothree(){
    	return "403";
    }
//    登陆页面访问入口
    @RequestMapping("Login")
    public String Login(){
        return "Login";
    }
    
    @RequestMapping("add1")
    public String add1(){
    	return "add1";
    }

    @RequestMapping("fileupload")
    public String upload(){
		return "upload";
    	
    }
		//  登陆页面访问入口
	  @RequestMapping("main")
	  public String add(){
	      return "main";
	  }
    
	  @RequestMapping("allFiles")
	  public String allFiles(){
		  return "allFiles";
	  }
	  
	  @RequestMapping("alterplant")
	  public String alterplant(){
		  return "alterplant";
	  }
	  
	  @RequestMapping("add")
	  public String addPage(){
		  return "add";
	  }
	  
	//登陆Action
    @RequestMapping("LoginAction")
    public void LoginAction(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException{
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
	    String id = plantSystemService.selectAccount(username, password);
          if(id == null){
        	out.print("<script>");
        	out.print("alert('用户名或密码错误,请核对后重新输入！');");
        	out.print("window.location.href='Login.do'");
        	out.print("</script>");
        	out.close();/*5+5646*/
          }else{
        	//将登陆标志 存放在session 作用域中
        	request.getSession(true).setAttribute("username", username);
        	//登陆成功  登陆到主页面
//        	request.getRequestDispatcher("/selectAllFiles.do").forward(request, response);
        	response.sendRedirect("selectAllFiles.do");
        	out.close();/*5+5646*/
        	System.out.println("登陆成功！");
          }
    }
   
    /**
     * 用户登陆模块
     * */
    @RequestMapping("insertLoginAccountAction")
    public void insertLoginAccountAction(){
        String id = "2";
        String username = "lhg";
        String password = "asdasd";
        loginAccount loginAccount = new loginAccount();
        loginAccount.setId(id);
        loginAccount.setUsername(username);
        loginAccount.setPassword(password);
        System.out.println("**********************************");
        plantSystemService.insertLoginAccount(loginAccount);
        System.out.println("添加用户成功");
    }
    
    /***
     * 删除  文件
     * @throws IOException 
     * @throws ServletException 
     */
    @RequestMapping("delete")
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String password = request.getParameter("password");
    	String uuidname = request.getParameter("uuidname");
    	System.out.println("UUid:"+uuidname);
    	String temppath = request.getSession().getServletContext().getRealPath("projects");//tomcat下
    	String projectspath = request.getSession().getServletContext().getRealPath("");//tomcat下
    	File directory = new File(projectspath);//设定为当前文件夹 
    	File file1 = new File(directory.getParentFile().toString()).getParentFile();
    	String projects = file1.toString() + File.separator + "projects";
    	String temp = file1.toString() + File.separator + "temp";
    	String downloadpictures = file1.toString() + File.separator + "downloadpictures";
    	
    	if(password.equals("2018nyist._")){
    		//删除备份 管理员修改文件
        	File delFile = new File(projects);
        	File[] delFiles = delFile.listFiles();
        	System.out.println("delFiles:"+delFiles.length);
        	if(delFiles.length>0){
        		for (File f : delFiles) {
        			if(f.getName().equals(uuidname)){
        				System.gc();
        				f.delete();				//删除
        			}
        		}
        	}
        	
        	//删除备份 扫码文件
        	File tempFile = new File(temp);
        	File[] tempFiles = tempFile.listFiles();
        	System.out.println("delFiles:"+tempFiles.length);
        	if(tempFiles.length>0){
        		for (File f : tempFiles) {
        			if(f.getName().equals(uuidname)){
        				System.gc();
        				f.delete();				//删除
        			}
        		}
        	}
        	
        	//删除备份 二维码
        	String uuidPNG = uuidname.split("\\.")[0]+".png";
        	File downloadpicturesFile = new File(downloadpictures);
        	File[] downloadpicturesFiles = downloadpicturesFile.listFiles();
        	System.out.println("delFiles:"+downloadpicturesFiles.length);
        	if(downloadpicturesFiles.length>0){
        		for (File f : downloadpicturesFiles) {
        			if(f.getName().equals(uuidPNG)){
        				System.gc();
        				f.delete();				//删除
        			}
        		}
        	}
        	
        	File delname = new File(temppath+File.separator+uuidname);
        	if(delname.exists()){
        		System.gc();
        	   delname.delete();
        	}
        	System.out.println("UUID:"+uuidname.toString());
        	//删除数据库信息
        	//String del = delname.toString().split("\\_")[1];
        	plantSystemService.deleteFileInfo(uuidname);
        	//request.getRequestDispatcher("/selectAllFiles.do").forward(request, response);
    	}
    	response.sendRedirect("selectAllFiles.do");
    	
    }
    
    
    
    /**
     * 修改 
     * @throws IOException 
     * @throws ServletException 
     */
    @RequestMapping("alter")
    public void alter(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	String uuidname = request.getParameter("uuidname");
    	System.out.println("uuidname:"+uuidname);
    	String tempath="projects";
    	String path = tempath +File.separator+uuidname;
    	System.out.println(path);
    	System.out.println("******************");
    	/*Desktop.getDesktop().open(new File(path));*/
    	String name = uuidname.substring(uuidname.lastIndexOf("_"));
    	String realname = name.split("\\.")[0];
    	request.getSession(true).setAttribute("name",realname);
    	//request.getSession(true).getServletContext().setAttribute("uuidname_alter",uuidname);
    	Gson gson = new Gson();
    	String jsonString = gson.toJson(uuidname);
    	out.print(jsonString);
    	//request.getSession(true).setAttribute("uuidname_alter",uuidname);
    	request.getRequestDispatcher(path).forward(request, response);
    	//response.sendRedirect("selectAllFiles.do");
    	out.close();
    }
    
    /***
     * 修改保存
     * @throws IOException 
     * @throws ServletException 
     */
    @RequestMapping("alters")
    public void alters(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String uuidname = request.getParameter("uuidname");
    	String filedata = request.getParameter("filedata");
    	filedata = URLDecoder.decode(request.getParameter("filedata"),"UTF-8");
    	System.out.println("uuidname:"+uuidname);
    	System.out.println("filedata:"+filedata);
    	//找到文件
    	String temppath = request.getSession().getServletContext().getRealPath("projects");
    	String tpath = request.getSession().getServletContext().getRealPath("temp");
    	File alterfile = new File(temppath);			//判断文件是否存在  不存在就创建
    	File[] files = alterfile.listFiles();
    	for (File file : files) {
			if(file.isFile()){
				if(file.getName().equals(uuidname)){
					file.delete();					   //删除文件
					File f = new File(file.getName());//再次创建文件
					f.createNewFile();
					//创建写入据
			    	byte[] data = filedata.getBytes();
			    	OutputStream o = new FileOutputStream(temppath+File.separator+f.toString());
			    	InputStream in = new ByteArrayInputStream(data);
			    	InputStream fiInputStream = new FileInputStream(tpath+File.separator+"html1.txt");
			    	InputStream fInputStream2 = new FileInputStream(tpath+File.separator+"html2.txt");
			    	byte[] buff = new byte[1024];
			    	int len=0;
			    	
			    	while((len=fiInputStream.read(buff))>0){
			    		o.write(buff,0,len);
			    	}
			    	
			    	while((len=in.read(buff))!=-1){
			    		o.write(buff,0,len);
			    		//outputStream.write(buff, 0, len);
			    	}
			    	
			    	while((len=fInputStream2.read(buff))>0){
			    		o.write(buff,0,len);
			    	}    	
			    	in.close();
			    	o.close();
			    	fiInputStream.close();
			    	fInputStream2.close();	
				}
			}
		}
    	
    	File tempfile = new File(tpath);
    	File[] files2 = tempfile.listFiles();
    	for (File file : files2) {
    		if(file.isFile()){
    			if(file.getName().equals(uuidname)){
    				file.delete();
    				File f = new File(file.getName());
    				f.createNewFile();
    				String ht = "<html><head><title>修改</title><meta charset='UTF-8'></head><body>"+filedata+"</body></html>";
    		    	byte[] datastr = ht.getBytes();
    		    	InputStream inputStream = new ByteArrayInputStream(datastr);
    		    	OutputStream outputStream = new FileOutputStream(tpath.toString()+File.separator+f.getName());
    		    	byte[] buff = new byte[1024];
    		    	int len=0;
    		    	while((len=inputStream.read(buff))!=-1){
    		    		outputStream.write(buff, 0, len);
    		    	}
    		    	inputStream.close();
    		    	outputStream.close();
    			}
    		}
		}
    	request.getRequestDispatcher("/selectAllFiles.do").forward(request, response);
    }
    
    @RequestMapping("addplant1")
    public void addplant1(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	//1.收集数据
    	String uuidname = java.net.URLDecoder.decode(request.getParameter("uuidname"),"UTF-8");		//文件名
    	String filedata = request.getParameter("filedata");		//文件内容
    	filedata = URLDecoder.decode(request.getParameter("filedata"),"UTF-8");
    	System.out.println("filedata:"+filedata);
    	
    	String temppath = request.getSession().getServletContext().getRealPath("projects");
    	String tpath = request.getSession().getServletContext().getRealPath("temp");
    	
    	String tomcartemppath = request.getSession().getServletContext().getRealPath("");
    	File directory = new File(tomcartemppath);//设定为当前文件夹 
    	File tomFile = new File(directory.getParentFile().toString()).getParentFile();
    	String webAppDirectory = tomFile.toString() + File.separator + "projects";
    	String webApptemp = tomFile.toString() + File.separator + "temp";
    	File filename = new File(temppath);
    	File[] files = filename.listFiles();
    	File f = null;
    	File f1 =null;
    	File projectsf = null;
    	File tempf =null;
    	for (File file : files) {
			if(file.isFile()){
				if(file.getName().equals(uuidname)){
					File delFile = new File(webAppDirectory,file.getName());
					System.out.println("projects-delFile:"+delFile);
					delFile.delete();
					file.delete();
					f = new File(temppath+File.separator+file.getName());
					f.createNewFile();
					projectsf = new File(webAppDirectory+File.separator+file.getName());
					projectsf.createNewFile();
				}
			}
		}
    	
    	File filename1 = new File(tpath);
    	File[] files1 = filename1.listFiles();
    	for (File file1 : files1) {
			if(file1.isFile()){
				if(file1.getName().equals(uuidname)){
					File delFile = new File(webAppDirectory,file1.getName());
					System.out.println("temp-delFile:"+delFile);
					delFile.delete();
					file1.delete();
					f1 = new File(tpath+File.separator+file1.getName());
					f1.createNewFile();
					tempf = new File(webApptemp+File.separator+file1.getName());
					tempf.createNewFile();
				}
			}
		}	
    	String nameString = uuidname.substring(uuidname.lastIndexOf("_")+1);
    	String altername = nameString.split("\\.")[0];								//标题名称  uuid_(2018-11-11_asd.html   asd
    	//将 filedata  写进文件
    	//String ht = "<html><head><title>"+altername+"</title><meta charset='UTF-8'></head><body>"+filedata+"</body></html>";
    	String ht = "<html><head><title>南阳理工学院后勤管理与服务中心植物识别系统</title><meta charset='UTF-8'></head><body style='margin:0px;padding:0px'><div style='width:100%; height:20%; z-index:-1; padding-top:0px;margin-left:0px;position:relative;z-index:5555;'><img alt='南阳理工后勤管理图片' src='2ee52dfa-48c1-4736-a227-739e9fde3394(2018-11-07_Head.png'  height='330px' width='100%'/></div>"+filedata+"</body></html>";
    	byte[] data = filedata.getBytes();
    	byte[] datastr = ht.getBytes();
    	OutputStream o = new FileOutputStream(f.toString());
    	InputStream in = new ByteArrayInputStream(data);
    	InputStream fiInputStream = new FileInputStream(tpath+File.separator+"html1.txt");
    	InputStream fInputStream2 = new FileInputStream(tpath+File.separator+"html2.txt");
    	OutputStream outputStream = new FileOutputStream(f1.toString());
    	InputStream inputStream = new ByteArrayInputStream(datastr);
    	
    	//备份文件
    	OutputStream projectOutputStream = new FileOutputStream(projectsf.toString());
    	OutputStream tempOutputStream = new FileOutputStream(tempf.toString());
    	byte[] buff = new byte[1024];
    	int len=0;
    	
    	while((len=fiInputStream.read(buff))>0){
    		o.write(buff,0,len);
    		projectOutputStream.write(buff, 0, len);
    	}
    	
    	while((len=in.read(buff))!=-1){
    		o.write(buff,0,len);
    		projectOutputStream.write(buff,0,len);;
    	}
    	
    	while((len=fInputStream2.read(buff))>0){
    		o.write(buff,0,len);
    		projectOutputStream.write(buff,0,len);
    	}
    	
    	while((len=inputStream.read(buff))!=-1){
    		outputStream.write(buff, 0, len);
    		tempOutputStream.write(buff, 0, len);
    	}
    	in.close();
    	inputStream.close();
    	o.close();
    	projectOutputStream.close();
    	tempOutputStream.close();
    	outputStream.close();
    	fiInputStream.close();
    	fInputStream2.close();
    	
    	/*Gson gson = new Gson();
    	String jsonString = gson.toJson(saveFileName);*/
    	//PrintStream printStream = new PrintStream(savepath+File.separator+saveFileName);
    	//printStream.print(0);
    	//out.print(jsonString);
    	System.out.println("写入文件成功!");
    	out.close();/*54564545*/
    }
    
    /**
     * 收集前端数据保存到文件
     * 保存本地 为html网页
     * @throws IOException 
     * */
    @RequestMapping("/addplant")
    public void addplant(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	//1.收集数据
    	String filename = request.getParameter("filename");		//文件名
    	System.out.println("filename:"+filename);
    	System.out.println("filedssssssssssata:"+request.getParameter("filedata"));
    	String filedata = URLDecoder.decode(request.getParameter("filedata"),"UTF-8");		//文件内容
    	System.out.println("filedata:"+filedata);
    	//filedata = URLDecoder.decode(filedata.replaceAll("%(?![0-9a-fA-F]{2})","%25"),"UTF-8");.replaceAll("%(?![0-9a-fA-F]{2})", "%25")
//    	filedata = filedata.replaceAll(" ","+");
//    	System.out.print("fa:"+filedata);
    	String temppath = request.getSession().getServletContext().getRealPath("projects");
    	
    	String tomcartemppath = request.getSession().getServletContext().getRealPath("");
    	File directory = new File(tomcartemppath);//设定为当前文件夹 
    	File tomFile = new File(directory.getParentFile().toString()).getParentFile();
    	String webAppDirectory = tomFile.toString() + File.separator + "projects";
    	String webApptemp = tomFile.toString() + File.separator + "temp";
    	System.out.println("temp:"+webAppDirectory);
    	File tomDirectoryprojects = new File(webAppDirectory);
    	if(!tomDirectoryprojects.exists()){
    		tomDirectoryprojects.mkdirs();
    	}
    	
    	File tomDirectorytemp = new File(webApptemp);
    	if(!tomDirectorytemp.exists()){
    		tomDirectorytemp.mkdirs();
    	}
    	System.out.println("temppath:"+temppath);
    	String tpath = request.getSession().getServletContext().getRealPath("temp");
    	
    	String saveFileName = generateFileName(filename);			//拿到保存的文件名
    	System.out.println("saveFilename:"+saveFileName);
    	File spath = new File(tpath,saveFileName+".html");
    	File saveFile = new File(temppath,saveFileName+".html");			//判断文件是否存在  不存在就创建
    	if(!saveFile.exists()){
    		saveFile.createNewFile();
    	}	
    	
    	//备份  生成备份文件
    	File projectFile = new File(webAppDirectory,saveFileName+".html");			//判断文件是否存在  不存在就创建
    	if(!projectFile.exists()){
    		projectFile.createNewFile();
    	}
    	
    	File tempFile = new File(webApptemp,saveFileName+".html");			//判断文件是否存在  不存在就创建
    	if(!tempFile.exists()){
    		tempFile.createNewFile();
    	}
    	
    	/*String filename2 = saveFileName.split("\\_")[1].split("\\.")[0];*/
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
    	PageBean pa = new PageBean();
    	pa.setDat(date);
		pa.setUuidname(saveFileName+".html");
		pa.setFilename(filename);
		System.out.println("pa:"+pa);
    	plantSystemService.insertFileInfo(pa);	
    	//读取
    	request.getSession(true).setAttribute("uuidname_html",saveFileName+".html");
    	//将 filedata  写进文件   /plantsystem/WebRoot/
    	//filename   保存的是 标题名称   
    	String ht = "<html><head><title>南阳理工学院后勤管理与服务中心植物识别系统</title><meta charset='UTF-8'></head><body style='margin:0px;padding:0px'><div style='width:100%; height:20%; z-index:-1; padding-top:0px;margin-left:0px;position:absoulte;z-index:5555;'><img alt='南阳理工后勤管理图片' src='2ee52dfa-48c1-4736-a227-739e9fde3394(2018-11-07_Head.png' height='330px' width='100%'/></div>"+filedata+"</body></html>";
    	byte[] data = filedata.getBytes();
    	byte[] datastr = ht.getBytes();
    	OutputStream o = new FileOutputStream(saveFile.toString());
    	InputStream in = new ByteArrayInputStream(data);
    	InputStream fiInputStream = new FileInputStream(tpath+File.separator+"html1.txt");
    	InputStream fInputStream2 = new FileInputStream(tpath+File.separator+"html2.txt");
    	OutputStream outputStream = new FileOutputStream(spath.toString());
    	InputStream inputStream = new ByteArrayInputStream(datastr);	
    	//备份文件
    	OutputStream projectsOutputStream = new FileOutputStream(projectFile.toString());
    	OutputStream tempOutputStream = new FileOutputStream(tempFile.toString());
    	byte[] buff = new byte[1024];
    	int len=0; 	
    	while((len=fiInputStream.read(buff))>0){
    		o.write(buff,0,len);
    		projectsOutputStream.write(buff, 0, len);
    	} 	
    	while((len=in.read(buff))!=-1){
    		o.write(buff,0,len);
    		projectsOutputStream.write(buff, 0, len);
    	}  	
    	while((len=fInputStream2.read(buff))>0){
    		o.write(buff,0,len);
    		projectsOutputStream.write(buff, 0, len);
    	}	
    	while((len=inputStream.read(buff))!=-1){
    		outputStream.write(buff, 0, len);
    		tempOutputStream.write(buff, 0, len);
    	}
    	in.close();
    	inputStream.close();
    	o.close();
    	projectsOutputStream.close();
    	tempOutputStream.close();
    	outputStream.close();
    	fiInputStream.close();
    	fInputStream2.close();
    	
    	Gson gson = new Gson();
    	String jsonString = gson.toJson(saveFileName);
    	//PrintStream printStream = new PrintStream(savepath+File.separator+saveFileName);
    	//printStream.print(0);
    	out.print(jsonString);
    	System.out.println("写入文件成功!");
    	out.close();/*54564545*/
    }
    
    //生成唯一的文件名
    public String generateFileName(String filename){
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	String date = simpleDateFormat.format(new Date());
    	return UUID.randomUUID().toString() + "(" +date + "_"+ filename;
    }
    
    
    //读取二维码 到前台
    @RequestMapping("/ShowImg")
    public void ShowImg(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	String uuidname = request.getParameter("uuidname");
        System.out.println("createQRCode-uuidname:"+uuidname);
        String temppath = request.getSession().getServletContext().getRealPath("");//tomcat下
    	File directory = new File(temppath);//设定为当前文件夹 
    	File file1 = new File(directory.getParentFile().toString()).getParentFile();
    	String temp = file1.toString() + File.separator + "picture";
    	File downloadpath = new File(temp+File.separator+uuidname);
    	System.out.println("fadf:"+downloadpath.toString());
    	FileInputStream inputStream = new FileInputStream(downloadpath);
    	byte data[]=new byte[1024*1024];   
        inputStream.read(data);  //读数据   
        response.setContentType("image/*"); //设置返回的文件类型   
        OutputStream outStream=response.getOutputStream(); //得到向客户端输出二进制数据的对象   
        outStream.write(data);  //输出数据      
        outStream.flush();  
        outStream.close();   
        inputStream.close();   
    }
   
    //模糊查询
    @RequestMapping("select")
    public void Select(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
    	//模糊查询
    	List<PageBean> list = plantSystemService.selectFileInfo(name);
		System.out.println("009:"+list);
    	request.getSession(true).setAttribute("map", list);
		request.getRequestDispatcher("/main.do").forward(request,response);

    }
    
    //查询/project下的所有的文件
    @RequestMapping("/selectAllFiles")
    public void selectAllFiles(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("UTF-8");
    	response. setCharacterEncoding("UTF-8");
    	//切换到指定的文件路径下
    	String temppath = request.getSession().getServletContext().getRealPath("projects");//tomcat下
    	String tpath = request.getSession().getServletContext().getRealPath("temp");//tomcat下
    	String downloadpath = request.getSession().getServletContext().getRealPath("downloadpictures");//tomcat下
    	File file = new File(temppath);
    	if(!file.exists()){
    		file.mkdirs();
    	}
    	System.out.println("--File:"+file);
    	System.out.println("File.length():"+file.length());
    	
    	File[] files = file.listFiles();
    	System.out.println("Files.length():"+files.length);
    	List<PageBean> list =new ArrayList<PageBean>();
    	if(files.length>0){
    		for(int i=0;i<files.length;i++){
        		if (files[i].isFile()) {
        			System.out.println("File:"+files[i]);
            		System.out.println("askjhdakshdsakdhk:"+files[i].getName());
            		String filename = files[i].toString();
            		//58fbc154-6a5b-44e8-8a29-015a71bd6620(2018-09-10_asd.txt
            		String uuidname = filename.substring(filename.indexOf("(")+1);			//58fbc154-6a5b-44e8-8a29-015a71bd6620_asd(2018-09-10.txt
//            		String realfilename = uuidname.substring(uuidname.lastIndexOf("_")+1);		//asd.txt
//            		String filename1 = realfilename.substring(0,realfilename.indexOf("."));			//asd
            		String[] realfilename = uuidname.split("\\_");
            		String realfilename1 = realfilename[1].substring(0,realfilename[1].indexOf("."));
            		System.out.println("uuidname:"+uuidname);
            		System.out.println("realfilename:"+realfilename[0]);
            		System.out.println("filename1:"+realfilename1);
            		PageBean pageBean = new PageBean();
            		pageBean.setDat(realfilename[0]);
            		pageBean.setFilename(realfilename1);
            		pageBean.setUuidname(files[i].getName());
            		list.add(pageBean);
    			}
        	}
    	}else{
    		System.out.println("444444444444444444444444444");
    		String tomdir = request.getSession(true).getServletContext().getRealPath("");
    		File directory = new File(tomdir);
    		File downpath = new File(directory.getParent().toString()).getParentFile();
    		String realdownloadpath = downpath.toString()+File.separator+"downloadpictures";
    		String realprojectspath = downpath.toString()+File.separator+"projects";
    		String realtempspath = downpath.toString()+File.separator+"temp";
    		InputStream downloadInputStream = null;
    		OutputStream downloadOutputStream = null;
    		File downFile = new File(realdownloadpath);
    		if(!downFile.exists()){
    			downFile.mkdirs();
    		}
    		File projectFile = new File(realprojectspath);
    		if(!projectFile.exists()){
    			projectFile.mkdirs();
    		}
    		File tempFile = new File(realtempspath);
    		if(!tempFile.exists()){
    			tempFile.mkdirs();
    		}
    		File[] downFiles = downFile.listFiles();
    		if(downFiles.length>0){
    			for (File f : downFiles) {
    				if(f.isFile()){
    					downloadInputStream = new FileInputStream(realdownloadpath+File.separator+f.getName());
    					File newFile = new File(downloadpath,f.getName());
    					if(!newFile.exists())
    						newFile.createNewFile();
    					downloadOutputStream = new FileOutputStream(newFile.toString());
    					int len = 0;
    					byte[] buffer = new byte[1024];
    					while((len = downloadInputStream.read(buffer))>0){
    						downloadOutputStream.write(buffer, 0, len);
    					}
    					System.out.println("PNG:"+f.getName());
    				}
    			}
    		}
    		
    		File[] projectsFiles = projectFile.listFiles();
    		if(projectsFiles.length>0){
    			for (File f : projectsFiles) {
        			if(f.isFile()){
    					downloadInputStream = new FileInputStream(realprojectspath+File.separator+f.getName());
    					File newFile = new File(temppath,f.getName());
    					if(!newFile.exists())
    						newFile.createNewFile();
    					downloadOutputStream = new FileOutputStream(newFile.toString());
    					int len = 0;
    					byte[] buffer = new byte[1024];
    					while((len = downloadInputStream.read(buffer))>0){
    						downloadOutputStream.write(buffer, 0, len);
    					}
    					System.out.println("Projects:"+f.getName());
    				}
    			}
    		}
    		
    		File[] tempFiles = tempFile.listFiles();
    		if(tempFile.length()>0){
    			for (File f : tempFiles) {
        			if(f.isFile()){
    					downloadInputStream = new FileInputStream(realtempspath+File.separator+f.getName());
    					File newFile = new File(tpath,f.getName());
    					if(!newFile.exists())
    						newFile.createNewFile();
    					downloadOutputStream = new FileOutputStream(newFile.toString());
    					int len = 0;
    					byte[] buffer = new byte[1024];
    					while((len = downloadInputStream.read(buffer))>0){
    						downloadOutputStream.write(buffer, 0, len);
    					}
    					System.out.println("Temp:"+f.getName());
    				}
    			}
    		}
    		downloadInputStream.close();
    		downloadOutputStream.close();
    	}
    	request.getSession(true).setAttribute("map", list);
    	request.getRequestDispatcher("/main.do").forward(request,response);
    	//response.sendRedirect("main.do");
    }
    
    /***
     * 文件上传
     * @throws IOException 
     * @throws ServletException 
     */
    @RequestMapping("upload")
    public void webupload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter outPrintWriter = response.getWriter();
    	System.out.println("********************************");
    	//1.创建一个工厂  默认缓冲区大小为10k
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.设置缓区大小为 1冲M 如果上传文件大于1M,则上传的文件将不再保存在缓冲区,
        //将会保存在临时文件中,读取数据的时候也会从临时文件中读取
        factory.setSizeThreshold(1024*1024*1024);
        //3.设置临时文件保存目录   / 代表web工程    将/temp设置为临时保存文件目录
        String tomcatdir = request.getSession(true).getServletContext().getRealPath("temp");
        //tomcat 下
        /*File dirfile = new File(tomcatdir.toString()).getParentFile().getParentFile();
        File file = new File(dirfile + File.separator+"temp");
        if(!file.exists()){
            file.mkdirs();
        }*/
        //设置文件目录  /tomcat 下
        factory.setRepository(new File(tomcatdir));
        ServletFileUpload upload = new ServletFileUpload(factory); //创建解析器

        //解决中文乱码问题
        upload.setHeaderEncoding("UTF-8");
        //限制单个文件上传大小   1G
        upload.setFileSizeMax(1024*1024*1024);
        //限制上传数据的类型
        List types = Arrays.asList("txt","avi","gif","jpg");
        if(!upload.isMultipartContent(request)){ //若果不是上传表单数据
            String nameString = request.getParameter("filename");
            System.out.println("name:"+nameString);
            return ;
        }
        try {
            List<FileItem> list = upload.parseRequest(request); //调用解析器解析request,得到并保存所有上传数据的List
            for (FileItem item : list) {
                if(item.isFormField()){ //判断是否为输入项
                    //为输入项
                    String inputName = item.getFieldName(); //获得文件的名称
                    String inputvalue = item.getString(); //获得文件的值
                    String inputValue = new String(inputvalue.getBytes("iso-8859-1"));
                    System.out.println(inputName+"="+inputValue);
                }else{
                	System.out.println("**************8888***************");
                    //代表输入项中封装的是文件
                	//String filename = item.getName().substring(item.getName().lastIndexOf("\\")+1); //获取到文件名称
                    String ext = item.getName().substring(item.getName().lastIndexOf(".")); 		  //获得文件的扩展名  .png .jpg
                    if(ext==null || ext.trim().equals("")){
                    	System.out.println("没有上传任何数据！！");
                        continue;
                    }
                    String prefix = "2ee52dfa-48c1-4736-a227-739e9fde3394(2018-11-07_Head";
                    String filename = prefix + ".png";
                    System.out.println("filename:"+ext);
                    InputStream in = item.getInputStream(); //获得inputStream流
                    //设置缓冲区
                    int len = 0;
                    byte buffer[] = new byte[1024];
//                    String saveFileName = generateFileName(filename); //调用gerenate函数 	生成唯一的文件名称
//                    System.out.println("saveFileName:"+saveFileName);
                    String temppath = request.getSession().getServletContext().getRealPath("temp");//tomcat下   
                    String tomdir = request.getSession(true).getServletContext().getRealPath("");
                    File tomFile = new File(tomdir);
                    File tempFile = new File(tomFile.getParentFile().toString()).getParentFile();
                    String realtempFile = tempFile.toString()+File.separator+"temp";
                    File tFile = new File(realtempFile);
                    if(!tFile.exists()){
                    	tFile.mkdirs();
                    }
                    System.out.println("tFile:"+tempFile.toString());
                    //在创建文件之前 首先删除同名文件
                    File t = new File(temppath);
                    File[] files = t.listFiles();
                    if(files.length>0){
                    	for (File f : files) {
							if(f.isFile()){
								if(f.getName().equals(prefix+".jpg")||f.getName().equals(prefix+".png")){
									System.gc(); 		//回收垃圾
									f.delete();
								}
							}
						}
                    }
                    
                    //删除 temp 文件
                  //在创建文件之前 首先删除同名文件
                    File t1 = new File(realtempFile);
                    File[] files1 = t.listFiles();
                    if(files1.length>0){
                    	for (File f : files1) {
							if(f.isFile()){
								if(f.getName().equals(prefix+".jpg")||f.getName().equals(prefix+".png")){
									System.gc(); 		//回收垃圾
									f.delete();
								}
							}
						}
                    }
                    
                    //创建文件
                    File newfile = new File(filename);
                    if (!newfile.exists()) {
						newfile.createNewFile();
					}
                    //在temp 创建文件
                    File tempFile2 = new File(tFile,filename);
                    if(!tempFile2.exists()){
                    	tempFile2.createNewFile();
                    }
                    FileOutputStream out = new FileOutputStream(temppath+File.separator+newfile); //指定目录下
                    FileOutputStream tempOutputStream = new FileOutputStream(tempFile2); 					  //指定 temp目录下
                    while((len = in.read(buffer)) > 0){
                        out.write(buffer,0,len);
                        tempOutputStream.write(buffer, 0, len);
                    }                               
                    in.close();
                    out.close();
                    tempOutputStream.close();
                    item.delete(); //删除上传完毕后的临时文件
                    request.getSession(true).setAttribute("upload_image",filename);               
                }
            }
        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("message","文件大小不能超过 5 M");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return ;
        }catch (FileUploadException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*response.sendRedirect("fileupload.do");*/
       
        Gson gson = new Gson();
        String jsontoString = gson.toJson("上传成功!");
        outPrintWriter.print(jsontoString);
        outPrintWriter.close();
    }

    
    /**
     * 文件下载
     * @throws IOException 
     * */
    @RequestMapping("download")
    public void webdownload(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	response.setCharacterEncoding("UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	response.reset();
    	//request.setCharacterEncoding("UTF-8");
    	//1.拿到服务器传过来的文件名称,改文件名成为UUID文件名称
    	String filename = java.net.URLDecoder.decode(request.getParameter("filename"),"UTF-8");
    	System.out.println("filename:"+filename);
    	//filename = new String(filename.getBytes("iso8859-1"),"UTF-8"); //解决get请求方式乱码
    	System.out.println("download-filename:"+filename);
    	//2.找出这个文件
    	String temppath = request.getSession().getServletContext().getRealPath("downloadpictures");//tomcat下
    	/*File directory = new File(temppath);//设定为当前文件夹 
    	File file1 = new File(directory.getParentFile().toString()).getParentFile();
    	String temp = file1.toString() + File.separator + "picture";*/
    	System.out.println("downpath:"+temppath);
    	//3.判断该文件是否存在
    	File file = new File(temppath + File.separator + filename);
    	System.out.println("File:"+file.toString());
    	if(!file.exists()){
	    	request.setAttribute("message","对不起,您要下载的资源已被删除!");
//	    	request.getRequestDispatcher("/message.jsp").forward(reqest, response);
	    	return ;
    	}
    	//得到下载文件的原始文件名
    	String oldname = file.getName().substring(file.getName().indexOf("_")+1);
    	//需要浏览器  以下载的方式打开一下发送的数据
    	System.out.println("oldname:"+oldname);
    	//response.setHeader("content-disposition","attachment;filename="+URLDecoder.decode(oldname,"UTF-8"));
    	System.out.println("URLDecoder:"+URLDecoder.decode(oldname,"UTF-8"));
    	response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(oldname,"UTF-8"));
    	//文件存在   创建FileInputStream流读取文件
    	FileInputStream in = new FileInputStream(file);
    	int len = 0 ;
    	byte buffer[] = new byte[1024];
    	OutputStream out = response.getOutputStream(); //将读取的数据输出到response流中去
    	while((len = in.read(buffer)) > 0){
    		out.write(buffer,0,len);
    	}
    	in.close(); //切记一定要关闭 FileInputStream 流 不必关闭out流,因为....
    	out.close();
    }
    
    /***
     * 修改文章
     * @throws IOException 
     * @throws ServletException 
     */
    @RequestMapping("/alterplantAction")
    public void alterplantinfo(HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	//1.首先 前台传进来一个文件名
    	String uuidname = request.getParameter("uuidname");
    	String savepath = request.getServletContext().getRealPath("projects");
    	File file = new File(savepath+File.separator);
    	File[] files = file.listFiles();
    	StringBuffer stringBuffer= new StringBuffer(); 	
    	for (File f : files) {
    		String realfilename = f.toString().substring(f.toString().lastIndexOf("\\")+1);
    		String filename = realfilename.substring(realfilename.indexOf("_")+1);
    		String fname = filename.substring(0,filename.indexOf("."));
    		System.out.println("realfilename:"+realfilename);
    		if(realfilename.equals(uuidname)){
    			InputStream in = new FileInputStream(f);
    			int len=0;
    			byte[] buffer = new byte[1024];			//缓冲区
    			while((len=in.read(buffer))!=-1){
    				System.out.println("**************************************************");
    				stringBuffer.append(buffer);
    			}
    			request.getSession(true).setAttribute("data",stringBuffer);
    			request.getSession(true).setAttribute("filename",fname);
    			System.out.println("StringBuffer:"+stringBuffer);
    			in.close();
			}	
		}
    	//request.getRequestDispatcher("/alterplant.do").forward(request, response);
    	response.sendRedirect("main.do");
    }
   
    @RequestMapping("exit")
    public void exit(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	request.getSession(true).removeAttribute("username");
    	request.getSession(true).removeAttribute("map");
    	request.getSession(true).removeAttribute("filename");
    	request.getSession(true).removeAttribute("data");
    	response.sendRedirect("Login.do");
    }
    
}
