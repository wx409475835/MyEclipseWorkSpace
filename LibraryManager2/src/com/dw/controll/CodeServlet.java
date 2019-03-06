package com.dw.controll;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.util.ValidateImageUtils;

/**
 * @author bigshuai
 *@date 2017年5月6日
 *
 */
public class CodeServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	//1 工具类获得code
	String code = ValidateImageUtils.getSecurityCode();
	//2 获得session对象 夸请求获取
	req.getSession().setAttribute("code", code);
	//3 获得图片
	BufferedImage bi = ValidateImageUtils.createImage(code);
	//4 输出
	ImageIO.write(bi, "png", res.getOutputStream());
}
}
