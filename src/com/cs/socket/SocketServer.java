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
				// ����һ��ServerSocket�ڶ˿�4700�����ͻ�����

			} catch (Exception e) {
				System.out.println("can not listen to:" + e);
				// ������ӡ������Ϣ
			}
			Socket socket = null;
			try {
				socket = server.accept();
			     ServerThread th = new ServerThread(socket);  
			     th.start();
				// ʹ��accept()�����ȴ��ͻ������пͻ�
				// �����������һ��Socket���󣬲�����ִ��
			} catch (Exception e) {
				System.out.println("Error." + e);
				// ������ӡ������Ϣ
			}

		} catch (Exception e) {
			System.out.println("Error:" + e);
			// ������ӡ������Ϣ
		}

	}
}
