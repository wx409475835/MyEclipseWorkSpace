package com.nyist.cn.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nyist.cn.model.Upfile;

public class WebUtils {
	
	public static Upfile doUpload(HttpServletRequest request,String path) throws IllegalAccessException, InvocationTargetException, IOException{
		Upfile upfile = new Upfile();
		//1.创建 文件上传工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String temppath = request.getSession().getServletContext().getRealPath("/WEB-INF/temp");
		File tempfile = new File(temppath);		
		if(!tempfile.exists()){
			tempfile.mkdirs();
		}
		factory.setRepository(tempfile); 				//设置临时文件上传缓冲区
		//2.创建request解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置文件监听器		生成进度条
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
					System.out.println("读取完毕,已经读取"+pBytesRead+"字节");
				}else{
					System.out.println("已经读取了"+ pBytesRead +"字节");
				}
			}
		});
		//设置单个文件上传大小
		upload.setFileSizeMax(1024*1024*500);
		//解决文件乱码
		upload.setHeaderEncoding("UTF-8");
		//定义一个保存文件的容器    通过解析requet获得保存文件的容器
			List<FileItem> items;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}  
			for (FileItem item : items) {
				if(item.isFormField()){
					String name = item.getFieldName();			//获得文件的名称
					String value = item.getString("UTF-8");		//获得值
					System.out.println(name+"="+value);
					BeanUtils.setProperty(upfile,name, value);
				}else{
					//是上传的文件数据
					//获得文件名称
					String filename = item.getName().substring(item.getName().lastIndexOf("\\")+1);
					//获得保存文件名称
					String savefilename = generateFilename(filename);
					//获得保存文件路径
					String savepath = generateSavepath(savefilename, path);
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(savepath+File.separator+savefilename);
					int len =0;
					byte buffer[] = new byte[1024];
					while((len = in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete();
					//生成对象
					upfile.setId(UUID.randomUUID().toString());
					upfile.setUuidname(savefilename);
					upfile.setFilename(filename);
					upfile.setSavepath(savepath);
					upfile.setUptime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					return upfile;
				}
			}
		return upfile;
	}
	
	private static String generateFilename(String filename){
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		return UUID.randomUUID().toString()+"."+ext;
	}
	
	private static String generateSavepath(String savefilename,String path){
		int hashCode = savefilename.hashCode();
		int dir1 = hashCode & 15;
		int dir2 = (hashCode>>4) & 0xf;
		String savepath = path+File.separator+dir1+File.separator+dir2;
		File file = new File(savepath);
		if(!file.exists()){
			file.mkdirs();
		}
		return savepath;
	}
}
