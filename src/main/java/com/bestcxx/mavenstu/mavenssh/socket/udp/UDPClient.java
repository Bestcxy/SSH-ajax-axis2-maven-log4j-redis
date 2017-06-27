package com.bestcxx.mavenstu.mavenssh.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 基于 UDP 的Socket 客户端
 * @author WuJieJecket
 *
 */
public class UDPClient {
	public static void main(String[] args) {
		//定义服务器地址、端口以及发送的数据
		try {
			InetAddress address=InetAddress.getByName("localhost");
			int port=10000;
			byte[] b="你好，我是客户端".getBytes();
			
			//创建数据报，填充必要信息
			DatagramPacket datagramPacket=new DatagramPacket(b, b.length, address,port);
			
			//创建 DatagramSocket 对象
			DatagramSocket datagramSocket=new DatagramSocket();
			
			//向服务器端发送信息
			datagramSocket.send(datagramPacket);
			
			//接受服务器端的回馈信息
			//创建数据报,用于接收服务器端传递的数据
			byte[] b2=new byte[1024];
			DatagramPacket datagramPacket2=new DatagramPacket(b2,b2.length);
			//将服务器端传递的数据保存到数据报中
			datagramSocket.receive(datagramPacket2);//等待客户端连接
			
			//获取输入值
			String info=new String(b2,0,datagramPacket2.getLength());
			System.out.println(System.currentTimeMillis()+"客户端传递的值为："+info);
			
			datagramSocket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

