package com.cs.socket;

import java.net.ServerSocket;
import java.net.Socket;

import com.cs.util.PropertiesUtil;

public class SocketServer { 
	public static void main(String args[]) {

		try {
			ServerSocket server = null;

			try {
				String port=PropertiesUtil.getInstance().getAttribute("socketPort");
				server = new ServerSocket(Integer.parseInt(port));
				// 创建一个ServerSocket在端口4700监听客户请求

			} catch (Exception e) {
				System.out.println("can not listen to:" + e);
				// 出错，打印出错信息
			}
			Socket socket = null;
			try {
				socket = server.accept();
			     ServerThread th = new ServerThread(socket);  
			     th.start();
				// 使用accept()阻塞等待客户请求，有客户
				// 请求到来则产生一个Socket对象，并继续执行
			} catch (Exception e) {
				System.out.println("Error." + e);
				// 出错，打印出错信息
			}

		} catch (Exception e) {
			System.out.println("Error:" + e);
			// 出错，打印出错信息
		}

	}
}
