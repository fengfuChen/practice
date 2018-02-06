package com.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args)
			throws Exception {
		//准备数据, 信件内容
		String str = "您好!";
		byte[] buf = str.getBytes("utf-8");
		//创建数据封包,包含发送到目标地址, 包信封
		InetAddress ip = InetAddress.getByName("localhost");
		DatagramPacket data = new DatagramPacket(buf,buf.length,ip,8899);
		//发送UDP数据, 投递
		DatagramSocket socket=new DatagramSocket();
		socket.send(data);
		//准备接受服务器返回的数据
		buf = new byte[1024];
		data = new DatagramPacket(buf, 1024);
		socket.receive(data);
		int length = data.getLength();
		str=new String(buf,0,length,"utf-8");
		System.out.println(str);
	}
}









