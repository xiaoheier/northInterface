package com.cs.socket;

import java.util.concurrent.BlockingQueue;

public class AlarmProducer implements Runnable {
	private final BlockingQueue<Object> alarmQueue;
	public AlarmProducer(BlockingQueue<Object> queue){
		alarmQueue=queue;
	}
	public void run() {
		try{
			Object o=new Object();
			produceAlarm(o);
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
	
	private void produceAlarm(Object o) throws InterruptedException{
		alarmQueue.put(o);
	}

}
