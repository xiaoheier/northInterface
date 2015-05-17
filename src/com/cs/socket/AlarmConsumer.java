package com.cs.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class AlarmConsumer implements Runnable {
	private final BlockingQueue<Object> alarmQueue;
	private final Socket sock;
	public AlarmConsumer(BlockingQueue<Object> queue, Socket sock){
		alarmQueue=queue;
		this.sock=sock;
	}
	public void run() {
		try{
			while(true){
				sendAlarm(alarmQueue.take());
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
	
	public void sendAlarm(Object o){
		PrintWriter wtr = null;
		try {
			wtr = new PrintWriter(sock.getOutputStream());
			wtr.write("START\r\n");
			wtr.write("HEARTBEAT RESPONSE");
			wtr.write("END\r\n");
			wtr.flush();
			System.out.println("send data......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
