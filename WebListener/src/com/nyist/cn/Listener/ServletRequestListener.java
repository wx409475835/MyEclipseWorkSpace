package com.nyist.cn.Listener;

import javax.servlet.ServletRequestEvent;

public class ServletRequestListener implements javax.servlet.ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("ServketRequest 被销毁!");
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("ServletRequest 被初始化创建了!");
	}

}
