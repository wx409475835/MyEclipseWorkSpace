package day26_Internet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDP_Send {

	public static void main(String[] args) throws IOException{
		DatagramSocket socket = new DatagramSocket();
		Scanner scanner = new Scanner(System.in);
		while(true){
			String line = scanner.nextLine();
			if("exit".equals(line)){
				break;
			}
			DatagramPacket packet = new DatagramPacket(line.getBytes("UTF-8"),line.getBytes("UTF-8").length,InetAddress.getByName("127.0.0.1"),8686);
			socket.send(packet);
		}
		socket.close();
	}
}
