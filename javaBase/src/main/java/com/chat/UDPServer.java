package com.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args)
			throws Exception{
		//创建空白空间
		byte[] buf = new byte[1024];
		//创建空接收数据包 如果收到数据会填充到数组
		DatagramPacket data =
				new DatagramPacket(buf, 1024);
		//开始准备接收数据
		DatagramSocket socket =
				new DatagramSocket(8899);
		//开始监听, Block方法, 有数据收到就结束Block
		socket.receive(data);
		//接收数据的数量
		int length = data.getLength();
		String str=new String(buf,0,length,"utf-8");
		System.out.println(str);
		//从接收到的数据包中获得客户端的IP和port
		InetAddress clientIP = data.getAddress();
		int port = data.getPort();
		System.out.println(clientIP+":"+port);
		//原路送回消息, 发送消息到客户端
		//准备数据
		buf = "我是小丽呀!".getBytes("utf-8");
		//封装信封, 地址是客户端地址
		data = new DatagramPacket(
				buf,buf.length,clientIP,port);
		//发送消息
		socket.send(data);
	}
}










