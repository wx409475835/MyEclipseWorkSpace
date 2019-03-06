package com.nyist.cn.Listener;

import javax.servlet.ServletContextAttributeEvent;

public class ServletContextAttributeListener implements javax.servlet.ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("向servletContext中存了:"+name+"-"+value);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("从servletContext中删除了:"+scab.getName());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("ServletContext中 "+scab.getName() + "属性被替换了");
	}

}
