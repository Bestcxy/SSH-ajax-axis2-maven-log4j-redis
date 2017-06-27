package com.bestcxx.mavenstu.mavenssh.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 基于 UDP 的Socket 服务端
 * @author WuJieJecket
 *
 */
public class UDPServer {
	public static void main(String[] args) {
		try {
			//创建 DatagramSocket 
			DatagramSocket datagramSocket=new DatagramSocket(10000);
			
			//创建数据报,用于接收客户端传递的数据
			byte[] b=new byte[1024];
			DatagramPacket datagramPacket=new DatagramPacket(b,b.length);
			
			System.out.println(System.currentTimeMillis()+" 服务器端已经启动");
			//将客户端传递的数据保存到数据报中
			datagramSocket.receive(datagramPacket);//等待客户端连接
			
			//获取输入值
			String info=new String(b,0,datagramPacket.getLength());
			System.out.println(System.currentTimeMillis()+"客户端传递的值为："+info);
			
			//回复数据给客户端
			InetAddress address=datagramPacket.getAddress();//从数据报获取客户端地址
			int port=datagramPacket.getPort();//从数据报获取客户端的端口
			byte[] b2="我是服务端".getBytes();
			//创建数据报，填充必要信息
			DatagramPacket datagramPacket2=new DatagramPacket(b2, b2.length, address,port);
			
			//创建 DatagramSocket 对象
			DatagramSocket datagramSocket2=new DatagramSocket();
			
			//向客户端发送信息
			datagramSocket2.send(datagramPacket2);
						
			datagramSocket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

