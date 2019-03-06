package day26_Internet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GUI_Chat extends Frame{
	
	private TextArea viewArea;
	private TextArea sendArea;
	private TextField testField;
	private Button log;
	private Button send;
	private Button clear;
	private Button shake;
	private DatagramSocket socket;
	private BufferedWriter rw;
	
	public GUI_Chat(){
		init();
		southPanel();
		centerPanel();
		event();
	}

	private void event() {
		//设置窗体响应
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					rw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				socket.close();
				System.exit(0);
			}
		});
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					RecordLog();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewArea.setText("");
			}
		});
		
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//shake();
				try {
					send(new byte[]{-1},testField.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		sendArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try {
						send();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	private void shake() {
		int x = this.getLocation().x;						//获取横坐标位置
		int y = this.getLocation().y;						//获取纵坐标位置
		
		for(int i =0;i<20;i++){
			this.setLocation(x+10, y+10);
			this.setLocation(x+10, y-10);
			this.setLocation(x-10, y+10);
			this.setLocation(x-10, y-10);
			this.setLocation(x, y);
		}
	}
	
	private void RecordLog() throws IOException {
		rw.flush();										//刷新缓冲区
		FileInputStream in = new FileInputStream("config.txt");
		ByteArrayOutputStream bt = new ByteArrayOutputStream();			//创建内存缓冲区
		int len;
		byte[] arr = new byte[1024*8];
		while((len = in.read(arr))!=-1){
			bt.write(arr, 0, len);
		}				
		String s = bt.toString();
		viewArea.setText(s);
		in.close();
	}
	
	private void send(byte[] arr,String ip) throws IOException{
		DatagramPacket packet = new DatagramPacket(arr,arr.length,InetAddress.getByName(ip),9999);
		socket.send(packet);
	}
	
	private void send() throws IOException {
		String message = sendArea.getText();				//获取发送区域的内容
		String ip = testField.getText();					//获取IP地址
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;
		DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length,InetAddress.getByName(ip),9999);
		socket.send(packet);								//发送数据
		String time = getCurrentTime();						//创建当前日期对象
		String str = time+" 我对 "+(ip.equals("255.255.255.2555") ? "所有人" : ip)+" 说:\r\n"+message+"\r\n\r\n";
		viewArea.append(str);							//将信息添加到显示区域中
		rw.write(str);
		sendArea.setText(null); 							//清空发送数据
	}
	
	private String getCurrentTime() {
		Date date = new Date();								//获取当前日期
		SimpleDateFormat sdfDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdfDateFormat.format(date);					//将时间格式化返回
	}

	private void centerPanel() {
		Panel center = new Panel();							//创建中间的Panel
		viewArea = new TextArea();
		sendArea = new TextArea(5,1);
		center.setLayout(new BorderLayout());				//设置边界布局管理器
		center.add(sendArea,BorderLayout.SOUTH);			//发送区域在南边
		viewArea.setEditable(false);						//设置不可以编辑
		viewArea.setBackground(Color.WHITE);				//设置界面颜色
		center.add(viewArea,BorderLayout.CENTER);			//显示区域在中间
		sendArea.setFont(new Font("xxx",Font.PLAIN, 15));	//设置字体
		viewArea.setFont(new Font("xxx",Font.PLAIN, 15));	//设置字体
		this.add(center,BorderLayout.CENTER);
	}

	private void southPanel(){
		Panel south = new Panel();									//创建下边Panel
		testField = new TextField(15);
		testField.setText("127.0.0.1");								//设置显示输入框的默认值
		send = new Button("Send");									//设置Button的内容
		log = new Button("Record");									
		clear = new Button("Clear");
		shake = new Button("Shake");
		south.add(testField);										//将按钮添加到下部Panel位置
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		this.add(south,BorderLayout.SOUTH);							//将Panel放在Frame的南边
		
	}

	private void init() {
		this.setTitle("UDP聊天室");
		this.setLocation(800,150);									//设置窗体的位置
		new Receive().start();				
		this.setSize(400, 600);										//设置窗体大小
		try {
			socket = new DatagramSocket();							//创建Socket
			rw = new BufferedWriter(new FileWriter("config.txt",true));	//需要在尾部追加
		}catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);									//设置窗体可见属性
	}
	
	private class Receive extends Thread{
		
		public void run(){
			try {
				DatagramSocket socket = new DatagramSocket(9999);
				DatagramPacket packet = new DatagramPacket(new byte[1024*8],1024*8);
				while(true){
					socket.receive(packet);								//接收数据
					byte[] arr = packet.getData();
					int length = packet.getLength();
					if(arr[0]==-1&&length == 1){
						shake();
						continue;
					}
					
					String ip = packet.getAddress().getHostAddress();   //获得IP地址
					String time = getCurrentTime();						//获取时间
					String str = time+" "+ip+" 对我说:\r\n"+new String(arr, 0, length)+"\r\n\r\n";
					rw.write(str);
					viewArea.append(str);
				}			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		new GUI_Chat();
	}
}
