package com.cs.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientTest {
	public static void main(String args[]) {
		 Socket socket=null;
		try{
		 socket=new Socket("127.0.0.1",4700);
		 new Thread(new SocketClintThreadTest(socket)).start();
		 //�򱾻���4700�˿ڷ����ͻ�����
		 System.out.println("this is client...............");
		 //��ϵͳ��׼�����豸����BufferedReader����
		 PrintWriter os=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));
		 //��Socket����õ��������������PrintWriter����
		 BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream(),"GBK"));
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
			try {
				if(socket!=null){
				   socket.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
}
