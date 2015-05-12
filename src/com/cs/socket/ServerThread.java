package com.cs.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	  Socket sk = null;  
	  BufferedReader rdr = null;  
	  PrintWriter wtr = null;  
      public ServerThread(Socket sk)  
      {  
          this.sk = sk;  
      }  
      public void run()  
      {  
          try  
          {  
              wtr = new PrintWriter(sk.getOutputStream());  
              rdr = new BufferedReader(new InputStreamReader(sk  
                      .getInputStream()));  
              String line = rdr.readLine();  
			while (line != null){
              System.out.println("�ӿͻ���������Ϣ��" + line);  
//            �ر��������ü���     ��\n��,  
              wtr.println("��ã��������Ѿ��յ�������Ϣ��'" + line + "'\n");  
              wtr.flush();  
              System.out.println("�Ѿ����ظ��ͻ��ˣ�");  
              line = rdr.readLine();  
              }
          }  
          catch (IOException e)  
          {  
              e.printStackTrace();  
          }  
            
      }       
  }  

