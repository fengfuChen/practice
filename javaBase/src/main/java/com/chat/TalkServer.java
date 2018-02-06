package com.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TalkServer {
	private List<PrintWriter> users;
	private BlockingQueue<String> queue;
	private ServerSocket ss;
	/**
	 * 启动TCP监听, 和等待客户端连接 */
	public void start()throws Exception{
		users = new ArrayList<PrintWriter>();
		queue = new LinkedBlockingQueue<String>(100);
		ss = new ServerSocket(8000);
		//先启动小冰
		Thread bing = new Thread(new Bing());
		bing.start();
		//再进行客户连接监听
		while(true){
			Socket s = ss.accept();//等待用户的登录
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);//开启自动刷出
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			synchronized (users) {
				users.add(out);//已经登录的用户的输出流
			}
			//用户输入流交给ClientHanlder处理
			new Thread(new ClientHandler(in)).start();
		}
	}
	/** 负责接受每个用户的消息,保存到消息队列 */
	class ClientHandler implements Runnable{
		BufferedReader in;
		public ClientHandler(BufferedReader in) {
			this.in = in;
		}
		public void run() {
			while(true){
				try{
					//从客户端读取消息
					String str = in.readLine();
					//网络断开时候, readLine会返回null!
					if(str==null){break;}
					//发送到queue中
					queue.put(str);
				}catch(Exception e){
					e.printStackTrace();
					break;
				}
			}
			try{in.close();}catch(Exception e){}
		}
	}
	/** 小冰负责消息的转发,从队列取消息发送到users*/
	class Bing implements Runnable{//小冰
		public void run() {
			//从队列中读取消息转发给每个客户
			while(true){
				try{
					String msg = queue.take();
					synchronized (users) {
						for(PrintWriter out: users){
							out.println(msg);
						}
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args)
			throws Exception {
		TalkServer server = new TalkServer();
		//启动服务器
		server.start();
	}
}





