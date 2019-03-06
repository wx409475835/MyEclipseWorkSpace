package com.nyist.plantsystem.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swetake.util.Qrcode;

public class Encoder{
	public void encoderQRCode(HttpServletRequest request,String uuidname,String url,HttpServletResponse response) 
			throws IOException, ServletException{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");  
			System.out.println("********Url:"+url);
			System.out.println("********uuidname:"+uuidname);
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			System.out.println("bathPath:"+basePath);
		   String http = basePath+"temp/";
		   Qrcode qrcode = new Qrcode();
		   qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
		   qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
		   qrcode.setQrcodeVersion(10);//版本
		   //生成二维码中要存储的信息
		   String qrData = java.net.URLDecoder.decode(http+url,"UTF-8");
		   //String qrData = http+(String)request.getSession(true).getAttribute("uuidname_html");
		   System.out.println("qeData:"+qrData);
		   //设置一下二维码的像素
		   int width = 67 + 12*9;
		   int height = 67 + 12*9;
		   BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		   //绘图
		   Graphics2D gs = bufferedImage.createGraphics();
		   gs.setBackground(Color.WHITE);
		   gs.setColor(Color.BLACK);
		   gs.clearRect(0, 0, width, height);//清除下画板内容
		   
		   //设置下偏移量,如果不加偏移量，有时会导致出错。
		   int pixoff = 2;
		   
		   byte[] d = qrData.getBytes("UTF-8");
		   if(d.length > 0 && d.length <120){
			   boolean[][] s = qrcode.calQrcode(d);
			   for(int i=0;i<s.length;i++){
				   for(int j=0;j<s.length;j++){
					   if(s[j][i]){
						   gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
					   }
				   }
			   }
		   }
		   gs.dispose();
		   bufferedImage.flush();
		   
		   String temppath = request.getSession().getServletContext().getRealPath("downloadpictures");//tomcat下
		   
		   //数据备份
		   String downpath = request.getSession().getServletContext().getRealPath("");//tomcat下
	   	   File directory = new File(downpath);//设定为当前文件夹 
	   	   File file1 = new File(directory.getParentFile().toString()).getParentFile();
	   	   String temp = file1.toString() + File.separator + "downloadpictures";
	   	   File savepath = new File(temp);
	   	   if(!savepath.exists()){
	   		   savepath.mkdirs();
	   	   }
	   	   
		   String filename = uuidname + ".png";
		   File file2 = new File(temp,filename);
		   if(!file2.exists()){
			   file2.createNewFile();
		   }
		   File file3 = new File(temppath,filename);
		   if(!file3.exists()){
			   file3.createNewFile();
		   }
		   ImageIO.write(bufferedImage, "png",file2);
		   System.out.println("写入 downloadpirctures 成功！");
		   ImageIO.write(bufferedImage, "png",file3);
		   /*response.sendRedirect("add.do");*/
		   ServletOutputStream servletOutputStream = response.getOutputStream();
		   ImageIO.write(bufferedImage,"png",servletOutputStream);
		   servletOutputStream.close();
	}
}
