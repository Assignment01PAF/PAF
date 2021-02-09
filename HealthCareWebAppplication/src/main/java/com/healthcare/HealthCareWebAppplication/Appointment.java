package com.healthcare.HealthCareWebAppplication;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {
	
	String AppointmnetID;
	String AppointmentDate;
	String AppoinementTime;
	String cID;
	String Cname;
	String dID;
	String Dname;
	String Desease;
	String HospitalID;
	Boolean Check;
	public String getAppointmnetID() {
		return AppointmnetID;
	}
	public void setAppointmnetID(String appointmnetID) {
		AppointmnetID = appointmnetID;
	}
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getAppoinementTime() {
		return AppoinementTime;
	}
	public void setAppoinementTime(String appoinementTime) {
		AppoinementTime = appoinementTime;
	}
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getdID() {
		return dID;
	}
	public void setdID(String dID) {
		this.dID = dID;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getDesease() {
		return Desease;
	}
	public void setDesease(String desease) {
		Desease = desease;
	}
	public String getHospitalID() {
		return HospitalID;
	}
	public void setHospitalID(String hospitalID) {
		HospitalID = hospitalID;
	}
	public Boolean getCheck() {
		return Check;
	}
	public void setCheck(Boolean check) {
		Check = check;
	}
	@Override
	public String toString() {
		return "Appointment [AppointmnetID=" + AppointmnetID + ", AppointmentDate=" + AppointmentDate
				+ ", AppoinementTime=" + AppoinementTime + ", cID=" + cID + ", Cname=" + Cname + ", dID=" + dID
				+ ", Dname=" + Dname + ", Desease=" + Desease + ", HospitalID=" + HospitalID + ", Check=" + Check + "]";
	}
	
	
	
	

}
