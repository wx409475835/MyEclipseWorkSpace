package com.nyist.cn.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SerlvetContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContext被销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ServletContent被创建");
	}

}
