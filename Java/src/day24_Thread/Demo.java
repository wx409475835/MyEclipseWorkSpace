package day24_Thread;

public class Demo {

	private static String s1 = "筷子左";
	private static String s2 = "筷子右";
	
	public static void main(String[] args){
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();	
		//test8();
		//test9();
		//test10();
		//test11();
		//test12();
		
		/**
		 * 死锁
		 * 结果:
		 * 	Thread-0拿到-筷子左-等待-筷子右
			Thread-0拿到-筷子右-开吃
			Thread-0拿到-筷子左-等待-筷子右
			Thread-1拿到-筷子右-等待-筷子左
		 */
		new Thread(){
			
			@Override
			public void run() {
				while(true){
					synchronized(s1){
						System.out.println(getName()+"拿到-"+s1+"-等待-"+s2);
						synchronized (s2) {
							System.out.println(getName()+"拿到-"+s2+"-开吃");
						}
					}
				}
			}
		}.start();
		
		new Thread(){
			
			@Override
			public void run() {
				while(true){
					synchronized(s2){
						System.out.println(getName()+"拿到-"+s2+"-等待-"+s1);
						synchronized (s1) {
							System.out.println(getName()+"拿到-"+s1+"-开吃");
						}
					}
				}
			}
		}.start();
	}

	private static void test12() {
		//线程安全
		//2.实现Runable接口
		MyTicket mt = new MyTicket();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
	}

	private static void test11() {
		//线程安全
		//1.继承Thread
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
	}

	private static void test10() {
		//同步代码块
		final Printer printer = new Printer();
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					printer.print1();
				}
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					printer.print2();
				}
			}
		}.start();
	}

	private static void test9() {
		//setPriority(int newPriority) 				设置线程优先级
		Thread thread = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					System.out.println(getName()+"----11111111111");
				}
			}
		};
	
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					System.out.println(getName()+"================22222222");
				}
			}
		};
		
		thread.setPriority(10);							//为线程设置最大优先级
		thread1.setPriority(1);							//为线程设置最小优先级
		thread.start();
		thread1.start();
	}

	private static void test8() {
		final Thread thread = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println(this.getName()+"==================aaaa");
				}
			}
		};
		
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<15;i++){
					if(i==2){
						try {
							thread.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+"------bbb");
				}
			}
		};
		thread.start();
		thread1.start();
	}

	private static void test7() {
		//守护线程
		Thread thread = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<2;i++){
					System.out.println(this.getName()+"----aaa");
				}
			}
		};
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<50;i++){
					System.out.println(Thread.currentThread()+"---------------------==========vvvv");
				}
			}
		});
		
		thread2.setDaemon(true);						//setDaemon(true)		设置为true 等于将它设置为守护线程
		thread.start();
		thread2.start();
	}

	private static void test6() {
		//Thread.currentThread()
		new Thread(){
			@Override
			public void run() {
				System.out.println(this.getName()+"--------0-0-0-0-0");
			}
		}.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"--------------1-1-1-1");
			}
		}).start();
		
		
		System.out.println(Thread.currentThread());
	}

	private static void test5() {
		//设置线程名字和获取名字
		Thread threa1 = new Thread("lhg"){
			@Override
			public void run() {
				System.out.println(this.getName()+"------创建线程");
			}
		};
		
		new Thread("lxq"){
			@Override
			public void run() {
				System.out.println(this.getName()+"-----创建咯");
			}
		}.start();
		threa1.start();
	}

	private static void test4() {
		//使用内部类开启多线程
		new Thread(){								//1.new 一个匿名内部类
			@Override								
			public void run() {						//2.重写run方法
				for(int i = 0;i<1000;i++){
					System.out.println("aaaaa===========");
				}
			}
		}.start();									//3.开启新线程
		
		new Thread(new Runnable() {					//1.实现Runnable接口
			public void run() {						//2.覆盖run方法
				for(int i=0;i<1000;i++){
					System.out.println("bbbbb");
				}		
			}
		}).start();									//3.开启线程
	}

	private static void test3() {
		/**
		 * 	①实现Runnable接口
			②重写run方法
			🌂new Thread(Runnable targer) 将其弄成参数传递给Thread
		 */
		Thread thread = new Thread(new MyRunnable());
		thread.start();
		for(int j =0;j<1000;j++){
			System.out.println("main");
		}
	}

	private static void test2() {
		//多线程示例
		/**
		 * 1.继承Thread类
		 * 2.重写run方法
		 * 3.Thread.start()	开启线程
		 */
		MyThread thread = new MyThread();
		thread.start();							//开启线程
		for(int i = 0;i<1000;i++){
			System.out.println("main");
		}
	}

	private static void test1() {
		//证明Jvm虚拟机是多线程
		for(int i=0;i<100000;i++){
			new MoreThread();
		}
		for(int i=0;i<100000;i++){
			System.out.println("我是主线程");
		}
	}
}

class MoreThread{
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("线程垃圾回收被启动,开始清扫垃圾!");
	}
}

class MyThread extends Thread{
	@Override
	//重写Run之后  将需要执行的代码放到run方法中
	public void run() {
		for(int i =0;i<1000;i++){
			System.out.println("Run");
		}
	}
}


class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i =0;i<1000;i++){
			System.out.println("Run");
		}
	}
	
}

class Printer{
	Object lock = new Object();
	public void print1(){
		synchronized(lock){								//同步锁机制,锁对象不能使用匿名对象,因为匿名对象不是同一个对象
			System.out.print("南");
			System.out.print("阳");
			System.out.print("理");
			System.out.print("学");
			System.out.print("院");
			System.out.print("\r\n");	
		}
	}
	
	public void print2(){
		synchronized(lock){
			System.out.print("软");
			System.out.print("件");
			System.out.print("学");
			System.out.print("院");
			System.out.print("\r\n");
		}
	}
}


class Ticket extends Thread{
	private static int tickets = 100;
	private static Object lock = new Object();
	public void run() {
		while(true){
			//成员变量的所对象必须是静态的要保证唯一
			//private Object lock = new Object();	这种是不行的 因为每个new出来的类都有一个自己的非静态变量 不能保证唯一性
			//但是 private static Object lock = new Object(); 这样是可以的  static是全局变量  或者使用Ticket.class 也是唯一的
			synchronized (lock) {
				if(tickets == 0){
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName()+".....卖出第"+tickets--+"张票");
			}
		}
	};
}


class MyTicket extends Thread{
	private int tickets = 100;
	public void run() {
		while(true){
			
			synchronized (MyTicket.class) {
				if(tickets == 0){
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName()+".....卖出第"+tickets--+"张票");
			}
		}
	};
}