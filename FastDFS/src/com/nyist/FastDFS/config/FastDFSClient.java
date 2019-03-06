package com.nyist.FastDFS.config;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {
	/***
	 *  Thread.currentThread().getContextClassLoader().getResource("/").getPath();
	 */
	private static final String CONF_FILENAME = "src/fastdfs_client.conf";
	//拿到stoageClient 可以操作 storage 存储节点的客户端
	private static StorageClient1 storageClient1 = null;
	// 开启日志 
	private static Logger logger = Logger.getLogger(FastDFSClient.class);
	
	//加载文件
	static{
		try {
//			System.out.println("CONF_FILENAME:"+CONF_FILENAME);
			//使用fastdfs 固有的加载方式   初始化存储节点客户端连接
			ClientGlobal.init(CONF_FILENAME);
			//拿到 操作跟踪器节点的客户端
			TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
			//获取可以操作 tracker 的服务器
			TrackerServer trackerServer = trackerClient.getConnection();
			if(trackerServer == null){
				logger.error("getConnection ReturnBuilder null");
			}
			//跟踪器 设置到存储节点中  返回存储节点
			StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
			if (storageServer == null) {
				logger.error("getConnection return null");
			}
			//返回可以操作 存储节点的client连接
			storageClient1 = new StorageClient1(trackerServer, storageServer);
		} catch (Exception e) {
			//将错误记录在日志中
			logger.error(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param file 文件
	 * @param path 路径
	 * @return 上传成功返回Id,失败返回null
	 */
	public static String upload(File file,String path){
		FileInputStream fls = null;
		try {
			NameValuePair[] meta_list = null;	//new NamedValuePair[0]
			fls = new FileInputStream(file);
			byte[] file_buff = null;
			
			if(fls!=null){
				int len = fls.available();
				file_buff = new byte[len];
				fls.read(file_buff);
			}
			
			String filedid = storageClient1.upload_file1(file_buff, getFileExt(path), meta_list);
			return filedid;
		} catch (Exception ex) {
			logger.error(ex);
			System.out.println("upload报错");
			return null;
		}finally {
			if(fls!=null){
				try {
					fls.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}
	
	/***
	 * <B>方法名称:</B>删除方法<BR>
	 * <B>概要说明:</B>根据组名和远程文件来删除一个文件<BR>
	 * @param groupName 例如 "group1"  如果不指定该值,默认为group1
	 * @param path 例如 group1/M00/00/00/wKgQglxC3L6AbnvLAAE0w5OGzwY518.jpg
	 * @return  删除成功返回 0,非0则操作失败,返回错误代码
	 */
	public static int delete(String groupName,String path){
		try {
			int result = storageClient1.delete_file(groupName == null?"group1":groupName,path);
			return result;
		} catch (Exception e) {
			logger.error(e);
			return 0;
		}
	}
	
	/***
	 * <B>方法名称:</B>删除方法<BR>
	 * <B>概要说明:</B>根据组名和远程文件来删除一个文件<BR>
	 * @param fileId fileId 文件Id
	 * @return  删除成功返回0,非0则操作失败,返回错误 代码
	 */
	public static int delete(String fileId){
		try {
			int result = storageClient1.delete_file1(fileId);
			System.out.println("result-0:"+result);
			if(result==22){
				result = storageClient1.delete_file1(fileId);
			}
			return result;
		} catch (Exception e) {
			logger.error(e);
			return 0;
		}
	}
	
	/**
	 * <B>方法名称:</B>删除方法<BR>
	 * <B>概要说明:</B>根据组名和远程文件来删除一个文件<BR>
	 * @param oldFileId  oldFileId 旧文件Id
	 * @param file	新文件
	 * @param path	新文件路径
	 * @return	上传成功返回id,失败返回null
	 */
	public static String modify(String oldFileId,File file,String path){
		String fileId = null;
		try {
			//先上传 文件  拿到fileId
			fileId = upload(file, path);
			if(fileId == null){
				return null;
			}
			
			//在删除旧文件
			int delResult = delete(oldFileId);
			if(delResult!=0){
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		return fileId;
	}
	
	/**
	 * 下载成功返回0 失败返回-1
	 * @param fileId
	 * @param file
	 * @return
	 */
	public static int download(String fileId,File file){
		InputStream inputStream=null;
		try {
			byte[] bytes = storageClient1.download_file1(fileId);
			if(bytes != null){
				inputStream = new ByteArrayInputStream(bytes);
				FileUtils.copyInputStreamToFile(inputStream, file);
			}else {
				System.out.println("bytes 为空");
			}
			return 0;
		} catch (Exception e) {
			System.out.println("下载报错！！！");
			logger.error(e);
			return -1;
		}
	}
	
	/**
	 * 
	 * @param fileName
	 * @return  如 "jpg","txt","zip"
	 */
	private static String getFileExt(String fileName){
		if(StringUtils.isBlank(fileName)||!fileName.contains(".")){
			return "";
		}else {
			return fileName.substring(fileName.lastIndexOf(".")+1);
		}
	}
}
