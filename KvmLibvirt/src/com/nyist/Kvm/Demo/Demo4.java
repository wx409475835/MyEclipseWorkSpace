package com.nyist.Kvm.Demo;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;

import com.nyist.Kvm.Util.JavaLibvirtUtil;

@WebServlet("/Demo4")
public class Demo4 extends HttpServlet {




    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JavaLibvirtUtil javaLibvirtUtil = new JavaLibvirtUtil();
        Domain domain= null;
        try {
            domain = javaLibvirtUtil.DomainUtil();
            for (int id : javaLibvirtUtil.conn.listDomains()) {
                domain = javaLibvirtUtil.conn.domainLookupByID(id);
                System.out.println("before: id is " + domain.getID() + "   name is "
                        + domain.getName()+"   state is "+domain.getInfo().state);
                System.out.println();
            }
            //domain.create();
            //domain.suspend();
            //domain.resume();
            domain.destroy();

            for (int id : javaLibvirtUtil.conn.listDomains()) {
                domain = javaLibvirtUtil.conn.domainLookupByID(id);
                System.out.println("after: id is " + domain.getID() + "   name is "
                        + domain.getName()+"   state is "+domain.getInfo().state);
                System.out.println();
            }
            response.sendRedirect("/index.html");
        } catch (LibvirtException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
