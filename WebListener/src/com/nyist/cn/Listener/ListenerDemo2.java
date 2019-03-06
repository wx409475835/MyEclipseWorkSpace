package com.nyist.cn.Listener;

import com.nyist.cn.Model.Person;

public class ListenerDemo2 {
	public static void main(String[] args){
		Person p  = new Person();
		p.registerListener(new MyPersonListener());
		p.eat();
		p.run();	
	}
}

class MyPersonListener implements PersonListener{

	@Override
	public void dorun(PersonEvent e) {
		Person p = e.getPerson();
		System.out.println(p+"吃过饭,不能跑步！");
	}

	@Override
	public void doeat(PersonEvent e) {
		Person p = e.getPerson();
		System.out.println(p+"吃太多,容易造成肥胖!");
	}
}
