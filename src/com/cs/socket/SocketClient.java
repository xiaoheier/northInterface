package com.cs.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String args[]) {
		try{
		 Socket socket=new Socket("127.0.0.1",4700);
		 //�򱾻���4700�˿ڷ����ͻ�����
		 System.out.println("this is client...............");
		 //��ϵͳ��׼�����豸����BufferedReader����
		 PrintWriter os=new PrintWriter(socket.getOutputStream());
		 //��Socket����õ��������������PrintWriter����
		 BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		 //��Socket����õ�����������������Ӧ��BufferedReader����
		 // String readline=is.readLine(); //��ϵͳ��׼�������һ�ַ���
		while(true){
			os.write("START\r\n");
			os.write("HEARTBEAT");
			os.write("END \r\n");
			os.flush();
			System.out.println("send data....");
			Thread.sleep(6000);
		}
		/* while(!readline.equals("bye")){
		 //���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��
			os.println(readline);
			//����ϵͳ��׼���������ַ��������Server
			os.flush();
			//ˢ���������ʹServer�����յ����ַ���
			System.out.println("Client:"+readline);
			//��ϵͳ��׼����ϴ�ӡ������ַ���
			System.out.println("Server:"+is.readLine());
			//��Server����һ�ַ���������ӡ����׼�����
			readline=sin.readLine(); //��ϵͳ��׼�������һ�ַ���
		 } //����ѭ��
	 os.close(); */	//�ر�Socket�����
		// is.close(); //�ر�Socket������
		// socket.close(); //�ر�Socket
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
		}
}
