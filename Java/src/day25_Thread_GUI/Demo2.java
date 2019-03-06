package day25_Thread_GUI;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {

	public static void main(String[] args){
		//test1();
		//test2();
		
		
	}

	private static void test2() {
		//线程池ExecutorService
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(new MyRunable());
		executorService.submit(new MyRunable());
		executorService.shutdown();
	}

	private static void test1() {
		/**
		 * 线程组:线程改变到其他线程组
		 */
		ThreadGroup tg = new ThreadGroup("lhg");
		MyRunable myRunable = new MyRunable();
		Thread thread = new Thread(tg,myRunable,"张三");
		Thread thread1 = new Thread(tg,myRunable,"李四");
		System.out.println(thread.getThreadGroup().getName());
		System.out.println(thread1.getThreadGroup().getName());
	}
}

class MyRunable implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println(Thread.currentThread().getName()+"...."+i);
		}
	}
	
} 
