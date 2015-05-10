package com.cs.cm;

import java.util.List;

public class CMObjects {
   private String ObjectType;
   private List<CMFieldName> fieldName;
   private CMFieldValue fieldValue;
public String getObjectType() {
	return ObjectType;
}
public void setObjectType(String objectType) {
	ObjectType = objectType;
}
public List<CMFieldName> getFieldName() {
	return fieldName;
}
public void setFieldName(List<CMFieldName> fieldName) {
	this.fieldName = fieldName;
}
public CMFieldValue getFieldValue() {
	return fieldValue;
}
public void setFieldValue(CMFieldValue fieldValue) {
	this.fieldValue = fieldValue;
}
}
