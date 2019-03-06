package day26_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MoreThread {

	public static void main(String[] args){
		new Thread(new Thread_Recv()).start();
		new Thread(new Thread_Send()).start();
	}
}

class Thread_Recv extends Thread{
	public void run(){
		try {
			// 接收来自服务端的消息
			DatagramSocket socket = new DatagramSocket(6969);
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

			while (true) {
				socket.receive(packet);
				byte[] arr = packet.getData();
				InetAddress ip = packet.getAddress();
				int length = packet.getLength();
				int port = packet.getPort();
				System.out.println(ip + ":" + port + "->" + new String(arr, 0, length, "UTF-8"));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Thread_Send extends Thread{
	public void run(){
		try {
			DatagramSocket socket = new DatagramSocket();
			Scanner scanner = new Scanner(System.in);
			while(true){
				String line = scanner.nextLine();
				if("exit".equals(line)){
					break;
				}
				DatagramPacket packet = new DatagramPacket(line.getBytes("UTF-8"),line.getBytes("UTF-8").length,InetAddress.getByName("127.0.0.1"),6969);
				socket.send(packet);
			}
			socket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
