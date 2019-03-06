package day26_Internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

	/**
	 * TCP Server服务器
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8520);				//协议
		Socket socket = server.accept();							//接受客户端请求
		InputStream in = socket.getInputStream();					//获得客户端输入流
		OutputStream out = socket.getOutputStream();				//获得客户端输出流
		out.write("百度一下你就知道".getBytes());					//服务器向客户端写数据
		int len = in.read();
		byte[] arr = new byte[1024];
		System.out.println(new String(arr, 0, len));
		socket.close();
	}

}
