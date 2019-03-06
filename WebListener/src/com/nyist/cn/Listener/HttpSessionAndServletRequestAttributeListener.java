package com.nyist.cn.Listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAndServletRequestAttributeListener
		implements HttpSessionAttributeListener, ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent sra) {
		String name = sra.getName();
		String value = (String) sra.getValue();
		//System.out.println("向ServletRequestAttribute中加入了 "+name + "-" +value);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent sra) {
		//System.out.println("ServletRequestAttribute中删除了"+sra.getName());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent sra) {
		//System.out.println("ServletRequestAttribute中替换了"+sra.getName()+"-"+sra.getValue());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent sra) {
		System.out.println("HttpSessionAttribute中添加了"+sra.getName()+"-"+sra.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent sra) {
		System.out.println("HttpSessionAttribute中删除了"+sra.getName()+"-"+sra.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent sra) {
		System.out.println("HttpSessionAttribute中替换了"+sra.getName()+"-"+sra.getValue());
	}

}
