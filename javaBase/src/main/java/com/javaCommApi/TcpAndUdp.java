package com.javaCommApi;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * Created by chenfengfu on 2018/1/28.
 */
public class TcpAndUdp {

    @Test
    public void socketTest() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = new Socket("127.0.0.1", 8088);
        System.out.println(socket.getLocalPort());
        System.out.println(socket.getLocalAddress());
        System.out.println(socket.getLocalSocketAddress());
        serverSocket.close();
    }

        public void udpClientStart() throws Exception {
            DatagramSocket client = new DatagramSocket();
            InetAddress address = InetAddress.getByName("127.0.0.1"); // 发送地址
            String msg = "hello world, i am client ";
            DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), address, 8088);
            client.send(sendPacket);

            byte[] bytes = new byte[100];
            DatagramPacket receivePacket = new DatagramPacket(bytes, bytes.length);
            client.receive(receivePacket);
            System.out.println(new String(receivePacket.getData()));
            client.close();
        }

        public void udpServerStart() throws Exception {
            DatagramSocket server = new DatagramSocket(8088); //监听固定的端口
            byte[] bytes = new byte[100];
            DatagramPacket receivePacket = new DatagramPacket(bytes, bytes.length);
            server.receive(receivePacket);
            System.out.println(new String(receivePacket.getData()));

            String msg = "hello, i am server";
            DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), receivePacket.getAddress(), receivePacket.getPort());
            server.send(sendPacket);
            server.close();
        }
    @Test
    public void udpTest()throws Exception{
        udpClientStart();
        udpServerStart();
    }



}
