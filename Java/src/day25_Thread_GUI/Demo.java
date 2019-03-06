package day25_Thread_GUI;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException {
		//test1();
		//test2();
		//test3();
		//test4();
		
		/**
		 * 线程的等待唤醒机制
		 * wait()	或	 notify()
		 */
		/*final Printer printer = new Printer();
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer.print1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer.print2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();*/
		
		final Printer printer = new Printer();
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer.print1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer.print2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer.print3();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@SuppressWarnings({ "unused", "deprecation" })
	private static void test4() throws InterruptedException {
		//Timer.schedule()	定时器
		Timer timer = new Timer();
		timer.schedule(new MyTask(),new Date(118,6,29,17,45,38),3000);
		while(true){
			Thread.sleep(1000);
			System.out.println(new Date());
		}
	}

	@SuppressWarnings("unused")
	private static void test3() throws IOException {
		//Runtime.getRuntime	Runtime.exec(String command)
		Runtime run = Runtime.getRuntime();					//获取运行时对象
		//run.exec("shutdown -s -t 300");
		run.exec("shutdown -a");
	}

	@SuppressWarnings("unused")
	private static void test2() {
		//懒汉式
		Singalton1 s = Singalton1.getInstance();
		Singalton1 s1 = Singalton1.getInstance();
		System.out.println(s1 == s);
	}

	@SuppressWarnings("unused")
	private static void test1() {
		//饿汉式
		Singalton s1 = Singalton.getInstance();
		Singalton s2 = Singalton.getInstance();
		System.out.println(s1==s2);
	}

}

class Singalton{

	public Singalton() {}
	
	private static Singalton singalton = new Singalton();
	
	public static Singalton getInstance(){
		return singalton;
	}
}

class Singalton1{

	public Singalton1() {}
	
	private static Singalton1 s = null;
	
	public static Singalton1 getInstance(){
		if(s==null){
			s=new Singalton1();
		}
		return s;
	}
}

class MyTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("日常早起学习英语!");
	}
	
}

class Printer{
	private int flag = 1;								//设置一个标识位
	private ReentrantLock reentrantLock = new ReentrantLock();
	private Condition c1 = reentrantLock.newCondition();
	private Condition c2 = reentrantLock.newCondition();
	private Condition c3 = reentrantLock.newCondition();
	
	public void print1() throws InterruptedException{
		reentrantLock.lock();							//互斥锁 上锁
			if(this.flag != 1){
				c1.await();
			}
			System.out.print("南");
			System.out.print("阳");
			System.out.print("理");
			System.out.print("学");
			System.out.print("院");
			System.out.print("\r\n");
			this.flag = 2;
			c2.signal();								 
		reentrantLock.unlock();
	}
	
	public void print2() throws InterruptedException{
		reentrantLock.lock();
			if(this.flag != 2){
				c2.await();
			}
			System.out.print("软");
			System.out.print("件");
			System.out.print("学");
			System.out.print("院");
			System.out.print("\r\n");
			this.flag = 3;
			c3.signal();
		reentrantLock.unlock();
	}
	
	public void print3() throws InterruptedException{
		reentrantLock.lock();
			if(this.flag != 3){
				c3.await();
			}
			System.out.print("l");
			System.out.print("h");
			System.out.print("g");
			System.out.print("\r\n");
			this.flag = 1;
			c1.signal();
		reentrantLock.unlock();
	}
}
