package com.nyist.cn.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.nyist.cn.domain.upfile;
public class WebUtils {
	
	public static upfile doUpload(HttpServletRequest request,String uppath) throws Exception{
		upfile bean = new upfile();
		try {
			DiskFileItemFactory disk = new DiskFileItemFactory();
			File file = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp"));
			if(!file.exists()){
				file.mkdirs();
			}
			disk.setRepository(file);
			ServletFileUpload upload = new ServletFileUpload(disk);
			List<FileItem> fileItems = upload.parseRequest(request);
			for(FileItem fileItem : fileItems){
				if(fileItem.isFormField()){
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					BeanUtils.setProperty(bean, name, value);
				}else{
					//得到上传的文件名称
					String filename = fileItem.getName().substring(fileItem.getName().indexOf("\\")+1);
					//得到文件的保存名称
					String uuidname = generateFilename(filename);
					//得到文件的保存路径
					String savepath = generateSavePath(uppath, filename);
					InputStream in = fileItem.getInputStream();
					FileOutputStream out = new FileOutputStream(savepath+File.separator+uuidname);
					int len = 0;
					byte buffer[] = new byte[1024];
					while((len = in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					fileItem.delete();
					
					bean.setFilename(filename);
					bean.setId(UUID.randomUUID().toString());
					bean.setSavepath(savepath);
					bean.setUptime(new Date());
					bean.setUuidname(uuidname);
					return bean;
				}
			}
		}catch (FileUploadBase.FileSizeLimitExceededException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message","上传成功");
		}
		return bean;
	}
	
	//内部使用
	private static String generateFilename(String filename){
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		return UUID.randomUUID().toString()+"."+ext;
	}
	
	//解决目录上限(1000个最佳)问题
	private static String generateSavePath(String path,String filename){
		int hashcode = filename.hashCode(); 		//哈希值
		int dir1 = hashcode&15;						//一级目录
		//0x 代表16进制  16进制 0 1 2 . . . A(10) B C D E F(15) 则0xf = 1111 最高为补24位 0000 0000 0000 0000 0000 0000 1111 
		//hashcode>>4	哈希值向前移动4位 若原来为0101 1000 0010 0001 1111 1100 1010 1111 移动后为0101 1000 0010 0001 1111 1100 1010
		int dir2 = (hashcode>>4)& 0xf;				//二级目录   
		String savepath = path + File.separator + dir1 + File.separator + dir2;
		File file = new File(savepath);
		if(!file.exists()){
			file.mkdirs();
		}
		return savepath;
	}
}
