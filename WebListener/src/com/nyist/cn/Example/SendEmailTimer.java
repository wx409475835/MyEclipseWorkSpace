package com.nyist.cn.Example;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SendEmailTimer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Timer time = new Timer();
		Calendar cal = Calendar.getInstance();			//获得当前系统日期时间
		cal.set(2018, 6, 16, 16,27,30);
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("发送邮件!");
			}
		},cal.getTime());
	}

}
