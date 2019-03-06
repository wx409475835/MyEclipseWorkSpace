package com.nyist.Kvm.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyist.Kvm.Util.JavaLibvirtUtil;

@Controller
public class KvmLibvirtController {
	
	@RequestMapping("KvmLibvirtLogin")
	public String KvmLibvirtLogin(){
		return "KvmLibvirtLogin";
	}
	
	@RequestMapping("KvmLibvirtMain")
	public String KvmLibvirtMain(){
		return "KvmLibvirtMain";
	}
	
	@RequestMapping("KvmLibvirtCreate")
	public void KvmLibvirtCreate(HttpServletRequest request,HttpServletResponse response) throws IOException, LibvirtException, DocumentException{
		System.out.println("=======================================");
		System.out.println("访问成功!");
		System.out.println("=======================================");
		Domain domain = null;
		JavaLibvirtUtil javaLibvirtUtil = new JavaLibvirtUtil();
		domain = javaLibvirtUtil.DomainUtil();
		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("before: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "
					+ domain.getInfo().state);
			System.out.println();
		}
		domain.create();
		// domain.suspend();
		// domain.resume();
		// domain.destroy();

		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("after: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "
					+ domain.getInfo().state);
			System.out.println();
		}
		response.sendRedirect("/KvmLibvirtLogin.html");    
	}
	
	@RequestMapping("KvmLibvirtHangUp")
	public void KvmLibvirtHangUp(HttpServletRequest request,HttpServletResponse response) throws IOException, LibvirtException, DocumentException{
		Domain domain = null;
		JavaLibvirtUtil javaLibvirtUtil = new JavaLibvirtUtil();
		domain = javaLibvirtUtil.DomainUtil();
		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("before: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "+ domain.getInfo().state);
			System.out.println();
		}
		// domain.create();
		domain.suspend();
		// domain.resume();
		// domain.destroy();

		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("after: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "
					+ domain.getInfo().state);
			System.out.println();
		}
		response.sendRedirect("/KvmLibvirtLogin.html");
	}
	
	@RequestMapping("KvmLibvirtRecover")
	public void KvmLibvirtRecover(HttpServletRequest request,HttpServletResponse response) throws IOException, LibvirtException, DocumentException{
		JavaLibvirtUtil javaLibvirtUtil = new JavaLibvirtUtil();
		Domain domain = null;
		domain = javaLibvirtUtil.DomainUtil();
		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("before: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "+ domain.getInfo().state);
			System.out.println();
		}
		// domain.create();
		// domain.suspend();
		domain.resume();
		// domain.destroy();

		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("after: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "
					+ domain.getInfo().state);
			System.out.println();
		}
		response.sendRedirect("/KvmLibvirtLogin.html");
	}
	
	@RequestMapping("KvmLibvirtDestroy")
	public void KvmLibvirtDestroy(HttpServletRequest request,HttpServletResponse response) throws LibvirtException, DocumentException, IOException{
		JavaLibvirtUtil javaLibvirtUtil = new JavaLibvirtUtil();
		Domain domain = null;
		domain = javaLibvirtUtil.DomainUtil();
		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("before: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "+ domain.getInfo().state);
			System.out.println();
		}
		// domain.create();
		// domain.suspend();
		// domain.resume();
		domain.destroy();

		for (int id : javaLibvirtUtil.conn.listDomains()) {
			domain = javaLibvirtUtil.conn.domainLookupByID(id);
			System.out.println("after: id is " + domain.getID() + "   name is " + domain.getName() + "   state is "
					+ domain.getInfo().state);
			System.out.println();
		}
		response.sendRedirect("/KvmLibvirtLogin.html");
	}

	
	//Login  登陆
	@RequestMapping("LoginAction")
	public void LoginAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//获得前台表单提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		if(username.equals("root") || username.equals("lhg")){
			if(password.equals("lvhaoguang") || password.equals("lvhaoguang410923")){
				request.getRequestDispatcher("/KvmLibvirtMain.apex").forward(request, response);
			}else{
				out.print("<script type='text/javascript'>");
				out.print("alert('密码输入错误,请重新输入!');");
				out.print("window.location.href='KvmLibvirtLogin.apex'");
				out.print("</script>");
			}
		}else{
			out.print("<script type='text/javascript'>");
			out.print("alert('用户名输入错误,请重新输入!');");
			out.print("window.location.href='KvmLibvirtLogin.apex'");
			out.print("</script>");
		}
	}
}
