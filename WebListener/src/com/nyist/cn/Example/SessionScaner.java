package com.nyist.cn.Example;

import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Collections;
import java.util.LinkedList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//session扫描器
public class SessionScaner implements HttpSessionListener,ServletContextListener{

	//在有Session创建的时候,将session创建的链接放在一个集合中去
	//Collections  是集合的一个辅助工具类,之所以使用你Collections.synchronizedList()方法是因为该方法
	//可以实现线程安全  避免线程并发访问
	private List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
	private Object lock = new Object();
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//拿到Session链接
		HttpSession session = se.getSession();
		System.out.println(session+" 被创建了！");
		synchronized(this.lock){
			list.add(session);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = (HttpSession)se.getSession();
		System.out.println(session + "被销毁了！");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//Web应用启动的时候,定义一个定时器
		Timer time = new Timer();
		time.schedule(new MyTesk(list,lock),0,5*60*1000);
	}
}

//定义一个任务  座位参数传递给定时器让其每隔多长时间进行调度
class MyTesk extends TimerTask{
	
	private List list;
	private Object lock;
	public MyTesk(List list,Object lock){
		this.list = list;
		this.lock = lock;
	}
	
	//有线程并发访问异常 ，需要使用synchronized 放到同步代码块中,但是需要同步的代码位置不在一块的时候
	//这时候就需要使用 共享同一把锁了
	@Override
	public void run() {
		System.out.println("----定时器执行---");
		//这里使用共享锁  是因为防止线程并发执行 list.add()和以下run()方法
		synchronized (this.lock) {
			//这里之所以  使用listIterator()获得ListItrator迭代器,是因为如果使用Itrator这种迭代器
			//当我们在 对迭代器进行添加add()、删除remove()的时候,迭代器并不知道,所以会可能发生线程并发异常
			//使用ListItrator()这种迭代器 可以避免这种异常
			ListIterator it = list.listIterator();
			while(it.hasNext()){
				HttpSession session = (HttpSession)it.next();
				if(System.currentTimeMillis() - session.getLastAccessedTime() > 10*1000){
					session.invalidate();			//销毁session链接
					it.remove();
				}
			}
		}
	}
	
}