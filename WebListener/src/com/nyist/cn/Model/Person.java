package com.nyist.cn.Model;

import com.nyist.cn.Listener.PersonEvent;
import com.nyist.cn.Listener.PersonListener;

//使用观察者设计模式  设置监听器
public class Person {
	
	private PersonListener listener;
	public void eat(){
		if(listener!=null){
			this.listener.doeat(new PersonEvent(this));
		}
		System.out.println("eat!");
	}
	
	public void run(){
		if(listener!=null){
			this.listener.dorun(new PersonEvent(this));
		}
		System.out.println("run!");
	}
	
	//需要给顶一个监听器对象 
	public void registerListener(PersonListener listener){
		this.listener = listener;
	}
	
}

