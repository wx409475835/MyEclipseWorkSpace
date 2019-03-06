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
 *@date 2017��5��6��
 *
 */
public class CodeServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	//1 ��������code
	String code = ValidateImageUtils.getSecurityCode();
	//2 ���session���� �������ȡ
	req.getSession().setAttribute("code", code);
	//3 ���ͼƬ
	BufferedImage bi = ValidateImageUtils.createImage(code);
	//4 ���
	ImageIO.write(bi, "png", res.getOutputStream());
}
}
