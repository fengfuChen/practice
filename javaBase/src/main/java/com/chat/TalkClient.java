package com.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TalkClient {
	Socket socket;
	/** 启动客户端:连接到服务器,启动两个线程 */
	public void start() throws Exception{
		socket = new Socket("localhost", 8000);
		new Sender(socket.getOutputStream()).start();
		new Receiver(socket.getInputStream()).start();
	}

	/** 从控制台读取消息, 发送到服务器 */
	class Sender extends Thread{
		OutputStream out;
		public Sender(OutputStream out) {
			this.out = out;
		}
		public void run() {
			//从控制台读取消息, 发送到服务器
			Scanner in = new Scanner(System.in);
			//out是发送到服务器的流
			PrintWriter out = new PrintWriter(this.out, true);
			String ip = socket.getLocalAddress().getHostAddress();
			while(true){
				String str = in.nextLine();
				out.println(ip+":"+str);
			}
		}
	}

	/** 从服务器接受消息, 写到控制台 */
	class Receiver extends Thread{
		InputStream in;
		public Receiver(InputStream in) {
			this.in = in;
		}
		public void run() {
			//从服务器接受消息, 写到控制台
			BufferedReader in = new BufferedReader(new InputStreamReader(this.in));
			while(true){
				try{
					String str = in.readLine();
					if(str==null){
						break;
					}//如果null,网络断了
					System.out.println(str);
				}catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
			try{
				socket.close();
			}catch(Exception e){

			}
		}
	}

	public static void main(String[] args)
			throws Exception{
		TalkClient client = new TalkClient();
		client.start();
	}
}
