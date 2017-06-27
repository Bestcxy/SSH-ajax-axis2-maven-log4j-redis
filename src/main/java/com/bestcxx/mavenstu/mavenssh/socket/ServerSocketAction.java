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
public class ServerSocketAction {
	
	public static void main(String[] args) {
		try {
			//创建服务器端的 Socket
			ServerSocket serverSocket=new ServerSocket(10000);
			
			//开始监听服务器端的 Socket,一旦客户端调用 socket 就被实例化
			Socket socket=serverSocket.accept();
			
			//获取客户端输入流
			InputStream inputStream=socket.getInputStream();
			byte b[]=new byte[1024];
			StringBuffer sbf=new StringBuffer();
			for(int n;(n=inputStream.read(b))!=-1;){
				sbf.append(new String(b,0,n));				
			}
			System.out.println(System.currentTimeMillis()+"客户端传递进来的信息为："+sbf.toString());
			socket.shutdownInput();
			
			//向客户端反馈信息
			OutputStream outputStream=socket.getOutputStream();
			PrintWriter printWriter=new PrintWriter(outputStream);
			printWriter.write(System.currentTimeMillis()+"我是服务端");
			printWriter.flush();
			socket.shutdownOutput();
			
			//关闭资源
			
			inputStream.close();
			printWriter.close();
			outputStream.close();
			
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
