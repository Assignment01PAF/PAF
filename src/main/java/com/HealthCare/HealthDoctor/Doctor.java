package com.HealthCare.HealthDoctor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {

	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private String DoctorID;
	private String Specialty;
	private String NIC;
	private String PhoneNO;
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDoctorID() {
		return DoctorID;
	}
	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	public String getSpecialty() {
		return Specialty;
	}
	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getPhoneNO() {
		return PhoneNO;
	}
	public void setPhoneNO(String phoneNO) {
		PhoneNO = phoneNO;
	}
	
	
}
