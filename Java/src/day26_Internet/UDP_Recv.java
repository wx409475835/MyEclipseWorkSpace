package day26_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Recv {

	public static void main(String[] args) throws IOException{
		//接收来自服务端的消息
		DatagramSocket socket = new DatagramSocket(8686);
		DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
		
		while(true){
			socket.receive(packet);
			byte[] arr = packet.getData();
			InetAddress ip = packet.getAddress();
			int length = packet.getLength();
			int port = packet.getPort();
			System.out.println(ip+":"+port+"->"+new String(arr, 0, length,"UTF-8"));
		}
	}
}
