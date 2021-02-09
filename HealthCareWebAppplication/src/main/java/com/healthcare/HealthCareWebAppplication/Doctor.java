package com.healthcare.HealthCareWebAppplication;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {
	
	String firstName;
	String lastName;
	String email;
	String doctorID;
	String specialty;
	String nic;
	String PhoneNO;
	Boolean Check;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getPhoneNO() {
		return PhoneNO;
	}
	public void setPhoneNO(String PhoneNO) {
		this.PhoneNO = PhoneNO;
	}
	public Boolean getCheck() {
		return Check;
	}
	public void setCheck(Boolean check) {
		Check = check;
	}
	@Override
	public String toString() {
		return "Doctor [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", doctorID="
				+ doctorID + ", specialty=" + specialty + ", nic=" + nic + ", PhoneNO=" + PhoneNO + ", Check=" + Check
				+ "]";
	}
	
	
	

}
