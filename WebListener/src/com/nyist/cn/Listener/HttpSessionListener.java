package com.nyist.cn.Listener;

import javax.servlet.http.HttpSessionEvent;

public class HttpSessionListener implements javax.servlet.http.HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("HttpSession 被创建! "+event);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("HttpSession 被销毁"+event);
	}

}
