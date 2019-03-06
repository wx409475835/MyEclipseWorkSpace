package com.nyist.cn.Listener;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ListenerDemo1 {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(400,400);
		frame.setVisible(true);
		//注册时间监听器
		frame.addWindowListener(new MyListener());
	}

}


class MyListener implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//拿到时间源头
		Frame f = (Frame) e.getSource();
		//关闭窗口
		f.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("哈哈");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}