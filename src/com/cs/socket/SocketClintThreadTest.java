package com.cs.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClintThreadTest implements Runnable{
	private  Socket socket;
	public SocketClintThreadTest( Socket socket){
		this.socket=socket;
	}
	public void run() {
		 try {
			BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String readline=is.readLine();
			
				while(readline!=null){
					System.out.println("get form server:"+readline);
					readline=is.readLine();
				}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
