package day26_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Recv {
	
	public static void main(String[] args) throws IOException{
		/**
		 * 2.接收Receive
		 * 创建DatagramSocket,指定端口号
		 * 创建DatagramPacket,指定数组长度
		 * 使用DatagramSocket接收DatagramPacket
		 * 关闭DatagramSocket
		 * 从DatagramPacket中获得数据
		 */
		DatagramSocket socket = new DatagramSocket(8686);						//接收来自 6666 端口的
		DatagramPacket packet = new DatagramPacket(new byte[1024],1024);		//创建容纳器-->集装箱
		socket.receive(packet);
		byte[] brr = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(brr,0,len));
	}
}
