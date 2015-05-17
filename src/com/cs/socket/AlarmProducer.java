package com.cs.socket;

import java.util.concurrent.BlockingQueue;

import com.cs.fm.AlarmInfo;

public class AlarmProducer implements Runnable {
	private final BlockingQueue<AlarmInfo> alarmQueue;
	public AlarmProducer(BlockingQueue<AlarmInfo> queue){
		alarmQueue=queue;
	}
	public void run() {
		try{
			while(true){
				AlarmInfo alarm=new AlarmInfo("test1","test2","test3","test4","test5","test6","test7","test8");
			    produceAlarm(alarm);
			    Thread.sleep(60000);
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
	
	private void produceAlarm(AlarmInfo alarm) throws InterruptedException{
		alarmQueue.put(alarm);
	}

}
