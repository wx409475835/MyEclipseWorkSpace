package com.nyist.FastDFS.test;

import java.io.File;

import org.junit.Test;

import com.nyist.FastDFS.config.FastDFSClient;

public class TestFastDFS {
	/**
	 * 上传
	 * @throws Exception/FastDFS/WebRoot/source
	 */
	@Test
	public void upload() throws Exception{
		//String path = System.getProperty("user.dir")+File.separatorChar + "source" + File.separatorChar + "006.jpg";
		String path = "WebRoot/source/zookeeper-3.4.10.zip";
		System.out.println("path:"+path);
		File file = new File(path);
		String fileId = FastDFSClient.upload(file, path);
		System.out.println("本地文件:"+path+",上传成功！文件ID为:"+fileId);
	}
	
	/**
	 * 下载
	 * @throws Exception
	 */
	@Test
	public void download() throws Exception{
		String fileId = "group2/M00/00/00/wKgQhFxEUa6AH9fzABuqHExVuZ4881.pdf";
		String path = "WebRoot/receive/1.pdf";
		int i = FastDFSClient.download(fileId,new File(path));
		System.out.println("asd:"+i);
	}
	
	@Test
	public void delete(){
		String fileid = "group2/M00/00/00/wKgQhFxEUa6AH9fzABuqHExVuZ4881.pdf";
		int i = FastDFSClient.delete(fileid);
		
		System.out.println(i==0?"删除成功！":"删除失败！Code:"+i+"");
	}
	
	//测试文件上传
	@Test
	public void update(){
		String oldFile = "group2/M00/00/00/wKgQhFxEUc6AC5-QAApAKjCSakU852.pdf";
		String newfile = "WebRoot/source/zookeeper-3.4.10.zip";
		File file = new File(newfile);
		String fileId = FastDFSClient.modify(oldFile,file,newfile);
		System.out.println("旧文件:"+oldFile+"-已被删除！！！");
		System.out.println("新文件:"+newfile+"-已经上传！！！===FileId:"+fileId);
	}
}
