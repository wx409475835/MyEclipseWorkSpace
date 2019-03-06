package com.nyist.cn.Servlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//处理上传数据
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();					//创建一个工厂  默认缓冲区大小为10k
		//设置缓冲区大小为 1 M  如果上传文件大于1M,则上传的文件将不再保存在缓冲区,将会保存在临时文件中,读取数据的时候也会从临时文件中读取
		factory.setSizeThreshold(1024*1024);										  
		//设置临时文件保存目录   / 代表web工程    将/temp设置为临时保存文件目录
		String temppath = this.getServletContext().getRealPath("/temp");
		System.out.println("temppath:"+temppath);
		File file = new File(temppath);
		if(!file.exists()){
			file.mkdirs();
		}
		factory.setRepository(new File(temppath));
		ServletFileUpload upload = new ServletFileUpload(factory);					//创建解析器
		
		//在解析数据之前  做后台页面数据生成进度条
		upload.setProgressListener(new ProgressListener() {
			private long megaBytes = -1 ;
			@Override
			public void update(long pBytesRead, long pContentLength, int pItems) {
				long mBytes = pBytesRead / 1000000;			
				if(mBytes == -1){
					return ;
				}
				megaBytes = mBytes;
				System.out.println("已经读取文件个数:"+pItems);
				if(pContentLength == -1){
					System.out.println("已经读取"+pBytesRead+"字节");
				}else{
					System.out.println("读取了"+ pBytesRead +"字节");
				}
			}
		});
		
		//解决中文乱码问题
		upload.setHeaderEncoding("UTF-8");
		//限制单个文件上传大小   100 M
		upload.setFileSizeMax(1024*1024*100);
		//限制上传数据的类型
		List types = Arrays.asList("txt","avi","gif","jpg");
		if(!upload.isMultipartContent(request)){									//若果不是上传表单数据
			String nameString = request.getParameter("username");
			System.out.println("name:"+nameString);
			return ;
		}
		try {
			System.out.println("//////////////////////////////////");
			System.out.println(this.getServletContext().getRealPath("/WEB-INF/upload"));
			System.out.println("----------------------------------");
			List<FileItem> list = upload.parseRequest(request);						//调用解析器解析request,得到并保存所有上传数据的List
			for (FileItem item : list) {
				if(item.isFormField()){												//判断是否为输入项
					//为输入项
					String  inputName = item.getFieldName();													//获得文件的名称
					String  inputvalue = item.getString();														//获得文件的值
					String  inputValue = new String(inputvalue.getBytes("iso8859-1"),"UTF-8");
					System.out.println(inputName+"="+inputValue);
				}else{
					//代表输入项中封装的是文件
					String filename = item.getName().substring(item.getName().lastIndexOf("\\")+1);				//获取到文件名称
					String ext = filename.substring(filename.lastIndexOf(".")+1);								//获得文件的扩展名
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					/*if(!types.contains(ext)){
						request.setAttribute("message","本系统不支持上传"+ext+"文件类型");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return ;
					}*/
					System.out.println("filename:"+filename);
					InputStream in = item.getInputStream();														//获得inputStream流
					//设置缓冲区
					int len = 0;
					byte buffer[] = new byte[1024];					
					String saveFileName = generateFileName(filename);											//调用gerenate函数 生成唯一的文件名称
					String savepath = generateSavePath(this.getServletContext().getRealPath("/WEB-INF/upload"),saveFileName);
					//File.separator   常量分隔符   /		
					FileOutputStream out = new FileOutputStream(savepath + File.separator + saveFileName);		//指定目录下
					while((len = in.read(buffer)) > 0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete(); 																				//删除上传完毕后的临时文件
				}
			}
		}catch (FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("message","文件大小不能超过 5 M");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		}catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
	
	//解决同名文件覆盖问题
	public String generateFileName(String filename){
		//UUID.randomUUID().toString()		74e59732-f339-4546-bf91-42c6c83696ea	全球唯一标识
		return UUID.randomUUID().toString() + "_" + filename;
	}
	
	//解决目录上限(1000个最佳)问题
	public String generateSavePath(String path,String filename){
		int hashcode = filename.hashCode(); 		//哈希值
		int dir1 = hashcode&15;						//一级目录
		//0x 代表16进制  16进制 0 1 2 . . . A(10) B C D E F(15) 则0xf = 1111 最高为补24位 0000 0000 0000 0000 0000 0000 1111 
		//hashcode>>4	哈希值向前移动4位 若原来为0101 1000 0010 0001 1111 1100 1010 1111 移动后为0101 1000 0010 0001 1111 1100 1010
		int dir2 = (hashcode>>4) & 0xf;				//二级目录   
		String savepath = path + File.separator + dir1 + File.separator + dir2;
		File file = new File(savepath);
		if(!file.exists()){
			file.mkdirs();
		}
		return savepath;
	}
}
