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
		 //向本机的4700端口发出客户请求
		 System.out.println("this is client...............");
		 //由系统标准输入设备构造BufferedReader对象
		 PrintWriter os=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));
		 //由Socket对象得到输出流，并构造PrintWriter对象
		 BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream(),"GBK"));
		 //由Socket对象得到输入流，并构造相应的BufferedReader对象
		 // String readline=is.readLine(); //从系统标准输入读入一字符串
		while(true){
			os.write("START\r\n");
			os.write("HEARTBEAT");
			os.write("END \r\n");
			os.flush();
			System.out.println("send data....");
			
			Thread.sleep(6000);
		}
		/* while(!readline.equals("bye")){
		 //若从标准输入读入的字符串为 "bye"则停止循环
			os.println(readline);
			//将从系统标准输入读入的字符串输出到Server
			os.flush();
			//刷新输出流，使Server马上收到该字符串
			System.out.println("Client:"+readline);
			//在系统标准输出上打印读入的字符串
			System.out.println("Server:"+is.readLine());
			//从Server读入一字符串，并打印到标准输出上
			readline=sin.readLine(); //从系统标准输入读入一字符串
		 } //继续循环
	 os.close(); */	//关闭Socket输出流
		// is.close(); //关闭Socket输入流
		// socket.close(); //关闭Socket
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
