package day26_Internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client extends Thread{
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		/**
		 * TCP编程
		 */
		Socket socket = new Socket("127.0.0.1",8520);
		InputStream in = socket.getInputStream();						//获得服务器输入流
		OutputStream out = socket.getOutputStream();					//获得客户端输出流
		out.write("你好啊?".getBytes());									//客户端向服务器写数据
		byte[] arr = new byte[1024];
		int len = in.read(arr);											//读取服务器发过来的数据
		System.out.println(new String(arr,0,len));

		socket.close();
	}
}
