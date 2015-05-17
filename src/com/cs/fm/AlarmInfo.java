package com.cs.fm;

public class AlarmInfo {
	private String eventDate;
	private String eventTime;
	private String eventLabel ;

	private String eventStatus;
	private String perceivedSeverity;
	private String alarmSource;
	private String alarmRecordID;
	private String alarmType ;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "eventDate:"+eventDate+" eventTime:"+eventTime+" eventLabel:"+eventLabel+" eventStatus:"+eventStatus+" perceivedSeverity:"+perceivedSeverity+" alarmSource:"+alarmSource+" alarmRecordID:"+alarmRecordID+" alarmType:"+alarmType;
	}
	public AlarmInfo(String eventDate, String eventTime, String eventLabel,
			String eventStatus, String perceivedSeverity, String alarmSource,
			String alarmRecordID, String alarmType) {
		super();
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventLabel = eventLabel;
		this.eventStatus = eventStatus;
		this.perceivedSeverity = perceivedSeverity;
		this.alarmSource = alarmSource;
		this.alarmRecordID = alarmRecordID;
		this.alarmType = alarmType;
	}
	

}
