package com.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	ServerSocket ss;
	public void start() throws Exception {
		ss = new ServerSocket(8000);
		//主线程, 监听客户端连接
		while(true){//不断的监听是否有客户端连接进来
			Socket s = ss.accept();
			//将客户端连接交给线程
			ClientHandler handler=new ClientHandler(s);
			Thread t = new Thread(handler);
			//启动客户端处理线程, 当前线程返回去监听
			t.start();//开启子线程, 主线程继续执行
		}
	}
	class ClientHandler implements Runnable{
		Socket socket;
		public ClientHandler(Socket s) {
			socket = s;
		}
		public void run() {
			try{
				InputStream in =
						socket.getInputStream();
				OutputStream out=
						socket.getOutputStream();
				BufferedReader reader =
						new BufferedReader(
								new InputStreamReader(in,"utf-8"));
				PrintWriter writer =
						new PrintWriter(
								new OutputStreamWriter(
										out,"utf-8"),true);
				String str = reader.readLine();
				System.out.println("从客户收到:"+str);
				writer.println("是你啦!");
				socket.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
			throws Exception{
		TcpServer server = new TcpServer();
		server.start();
	}
}
