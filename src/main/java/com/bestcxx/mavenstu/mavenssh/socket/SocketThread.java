package com.bestcxx.mavenstu.mavenssh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketThread implements Runnable {

	
	
	private Socket socket=null;
	public SocketThread(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		InputStream inputStream=null;
		StringBuffer sbf=null;
		OutputStream outputStream=null;
		PrintWriter printWriter=null;
		
		try {
			//获取客户端输入流
			inputStream=socket.getInputStream();
			byte b[]=new byte[1024];
			sbf=new StringBuffer();
			for(int n;(n=inputStream.read(b))!=-1;){
				sbf.append(new String(b,0,n));				
			}
			System.out.println(System.currentTimeMillis()+" 客户端传递进来的信息为："+sbf.toString());
			socket.shutdownInput();
			
			//向客户端反馈信息
			outputStream=socket.getOutputStream();
			printWriter=new PrintWriter(outputStream);
			printWriter.write("我是服务端");
			printWriter.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				if(inputStream!=null){
					inputStream.close();					
				}
				if(printWriter!=null){
					printWriter.close();					
				}
				if(outputStream!=null){
					outputStream.close();					
				}
				if(socket!=null){
					socket.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
