package com.cs.cm;

public class CMFileHeader {
	private String InfoModelReferenced;
	private String DnPrefix;
	private String SenderName;
	private String VendorName;
	private String DateTime;
	public String getInfoModelReferenced() {
		return InfoModelReferenced;
	}
	public void setInfoModelReferenced(String infoModelReferenced) {
		InfoModelReferenced = infoModelReferenced;
	}
	public String getDnPrefix() {
		return DnPrefix;
	}
	public void setDnPrefix(String dnPrefix) {
		DnPrefix = dnPrefix;
	}
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
}
