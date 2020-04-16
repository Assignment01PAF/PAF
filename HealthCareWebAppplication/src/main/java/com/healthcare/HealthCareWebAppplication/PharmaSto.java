package com.healthcare.HealthCareWebAppplication;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PharmaSto {
	
	String Iname;
	String PackSize;
	String Selling;
	public String getIname() {
		return Iname;
	}
	public void setIname(String iname) {
		Iname = iname;
	}
	public String getPackSize() {
		return PackSize;
	}
	public void setPackSize(String packSize) {
		PackSize = packSize;
	}
	public String getSelling() {
		return Selling;
	}
	public void setSelling(String selling) {
		Selling = selling;
	}
	
	
	
	

}
