package com.cs.socket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.cs.db.SqlUtil;
import com.cs.fm.AlarmInfo;

public class AlarmProducer implements Runnable {
	private final BlockingQueue<AlarmInfo> alarmQueue;
	public AlarmProducer(BlockingQueue<AlarmInfo> queue){
		alarmQueue=queue;
	}
	public void run() {
		try{
			while(true){
				//AlarmInfo alarm=new AlarmInfo("test1","test2","test3","test4","test5","test6","test7","test8");
				List<AlarmInfo> alarmList=loadAlarmInfo();
				for(AlarmInfo alarm :alarmList){
					produceAlarm(alarm);
				}
			    Thread.sleep(60000);
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
	
	private void produceAlarm(AlarmInfo alarm) throws InterruptedException{
		alarmQueue.put(alarm);
	}
	
	
	private List<AlarmInfo> loadAlarmInfo(){
		List<AlarmInfo> alarmList=new ArrayList<AlarmInfo>();
		String sql="select * from alarminfo";
		ResultSet rs=SqlUtil.execut(sql);
		try {
			while(rs.next()){
				AlarmInfo alarm=new AlarmInfo();
				alarm.setId(rs.getInt("id"));
				alarm.setVendor(rs.getString("vendor"));
				alarm.setAlarmID(rs.getString("alarmid"));
				alarm.setAlarmRecordID(rs.getInt("alarmRecordID"));
				alarm.setAlarmSource(rs.getString("alarmSource"));
				alarm.setAlarmTitle(rs.getString("alarmTitle"));
				alarm.setAlarmType(rs.getString("alarmType"));
				alarm.setDeviceID(rs.getString("deviceID"));
				alarm.setDeviceLabel(rs.getString("deviceLabel"));
				alarm.setEventDate(rs.getString("eventDate"));
				alarm.setEventLabel(rs.getString("eventLabel"));
				alarm.setEventStatus(rs.getString("eventStatus"));
				alarm.setEventTime(rs.getString("eventTime"));
				alarmList.add(alarm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return alarmList;
	}

}
