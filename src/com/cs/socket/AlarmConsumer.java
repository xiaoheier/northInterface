package com.cs.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

import com.cs.fm.AlarmInfo;

public class AlarmConsumer implements Runnable {
	private final BlockingQueue<AlarmInfo> alarmQueue;
	private final Socket sock;
	public AlarmConsumer(BlockingQueue<AlarmInfo> queue, Socket sock){
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
	
	public void sendAlarm(AlarmInfo alarm){
		PrintWriter wtr = null;
		try {
			wtr = new PrintWriter(sock.getOutputStream());
			wtr.write(alarm.toString());
			wtr.flush();
			System.out.println("send data......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
