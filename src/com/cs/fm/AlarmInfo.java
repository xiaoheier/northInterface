package com.cs.fm;

public class AlarmInfo {
	private int id;
	private String deviceLabel;
	private String eventDate;
	private String eventTime;
	private String eventLabel ;

	private String eventStatus;
	private String perceivedSeverity;
	private String alarmSource;
	private int alarmRecordID;
	private String alarmType ;
	private String probableCause;
	private String proposedRepairActions;
	private String alarmTitle;
	private String alarmID;
	private String deviceID;
	private String objectClass;
	private String objectLocation;
	private String Vendor;
	private String substitute;
	private String monitorArea;
	private String monitorScope;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceLabel() {
		return deviceLabel;
	}
	public void setDeviceLabel(String deviceLabel) {
		this.deviceLabel = deviceLabel;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventLabel() {
		return eventLabel;
	}
	public void setEventLabel(String eventLabel) {
		this.eventLabel = eventLabel;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public String getPerceivedSeverity() {
		return perceivedSeverity;
	}
	public void setPerceivedSeverity(String perceivedSeverity) {
		this.perceivedSeverity = perceivedSeverity;
	}
	public String getAlarmSource() {
		return alarmSource;
	}
	public void setAlarmSource(String alarmSource) {
		this.alarmSource = alarmSource;
	}
	public int getAlarmRecordID() {
		return alarmRecordID;
	}
	public void setAlarmRecordID(int alarmRecordID) {
		this.alarmRecordID = alarmRecordID;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getProbableCause() {
		return probableCause;
	}
	public void setProbableCause(String probableCause) {
		this.probableCause = probableCause;
	}
	public String getProposedRepairActions() {
		return proposedRepairActions;
	}
	public void setProposedRepairActions(String proposedRepairActions) {
		this.proposedRepairActions = proposedRepairActions;
	}
	public String getAlarmTitle() {
		return alarmTitle;
	}
	public void setAlarmTitle(String alarmTitle) {
		this.alarmTitle = alarmTitle;
	}
	public String getAlarmID() {
		return alarmID;
	}
	public void setAlarmID(String alarmID) {
		this.alarmID = alarmID;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getObjectClass() {
		return objectClass;
	}
	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}
	public String getObjectLocation() {
		return objectLocation;
	}
	public void setObjectLocation(String objectLocation) {
		this.objectLocation = objectLocation;
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public String getSubstitute() {
		return substitute;
	}
	public void setSubstitute(String substitute) {
		this.substitute = substitute;
	}
	public String getMonitorArea() {
		return monitorArea;
	}
	public void setMonitorArea(String monitorArea) {
		this.monitorArea = monitorArea;
	}
	public String getMonitorScope() {
		return monitorScope;
	}
	public void setMonitorScope(String monitorScope) {
		this.monitorScope = monitorScope;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "eventDate:"+eventDate+" eventTime:"+eventTime+" eventLabel:"+eventLabel+" eventStatus:"+eventStatus+" perceivedSeverity:"+perceivedSeverity+" alarmSource:"+alarmSource+" alarmRecordID:"+alarmRecordID+" alarmType:"+alarmType;
	}
	public AlarmInfo() {
		
	}
	

}
