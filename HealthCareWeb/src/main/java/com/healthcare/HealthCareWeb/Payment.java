package com.healthcare.HealthCareWeb;

public class Payment {

	int paymentID;
	int hospitalID;
	int patientID;
	int appointmentID;
	String type;
	float amount;
	String date;
	String creditCardNumber;
	int cvc;
	String cardHolderName;
	String req_stat_cancl;
	
	public Payment() {
		 
	}
	
	public Payment(int paymentID, int hospitalID, int patientID, int appointmentID, String type, float amount,
			String date, String creditCardNumber, int cvc , String cardHolderName , String req_stat_cancl) {
		super();
		this.paymentID = paymentID;
		this.hospitalID = hospitalID;
		this.patientID = patientID;
		this.appointmentID = appointmentID;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.creditCardNumber = creditCardNumber;
		this.cvc = cvc;
		this.cardHolderName = cardHolderName;
		this.req_stat_cancl = req_stat_cancl;
	}
	
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getreq_stat_cancl() {
		return req_stat_cancl;
	}
	public void setreq_stat_cancl(String req_stat_cancl) {
		this.req_stat_cancl = req_stat_cancl;
	}
	
}
