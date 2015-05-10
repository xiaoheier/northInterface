package com.cs.cm;

import java.util.List;

public class CMFieldValueCM {
	private String Dn;
	private String UserLabel;
	private List<CMFileValueV> values;
	public String getDn() {
		return Dn;
	}
	public void setDn(String dn) {
		Dn = dn;
	}
	public String getUserLabel() {
		return UserLabel;
	}
	public void setUserLabel(String userLabel) {
		UserLabel = userLabel;
	}
	public List<CMFileValueV> getValues() {
		return values;
	}
	public void setValues(List<CMFileValueV> values) {
		this.values = values;
	}
}
