package com.bestcxx.mavenstu.mavenssh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于 TCP 协议的
 * 服务器端的Socket
 * @author WuJieJecket
 *
 */
public class ServerSocketByThreadAction {
	
	public static void main(String[] args) {
			int count=0;
			try {
				//创建服务器端的 Socket
				ServerSocket serverSocket=new ServerSocket(10000);
				System.out.println(System.currentTimeMillis()+" ---服务器端启动---");
				while(true){
					SocketThread socketThread=new SocketThread(serverSocket.accept());
					Thread thread=new Thread(socketThread);
					thread.start();
					count++;
					System.out.println(System.currentTimeMillis()+" 当前访问量="+count);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

