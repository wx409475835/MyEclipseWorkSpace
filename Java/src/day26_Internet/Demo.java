package day26_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Demo {

	public static void main(String[] args) throws IOException{
		//UDP 传输
		DatagramSocket socket = new DatagramSocket();			//创建Socket	-->相当于码头
		String buff = "Hello";
		//创建Packet --->相当于集装箱
		DatagramPacket packet = new DatagramPacket(buff.getBytes("UTF-8"),buff.getBytes().length,InetAddress.getByName("127.0.0.1"),8686);
		socket.send(packet);									//发送数据
		socket.close(); 										//发送完毕,关闭连接
	}
}
