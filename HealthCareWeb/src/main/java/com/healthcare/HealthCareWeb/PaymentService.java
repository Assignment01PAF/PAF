package com.healthcare.HealthCareWeb;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Payment")
public class PaymentService {

	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON) 

	public String View_Payment() {
		
		 PaymentRepository model = new  PaymentRepository();
		 String status = model.ViewPayment();

		
		return status;
	} 
	
	@GET
	@Path("/viewcncl")
	@Produces(MediaType.APPLICATION_JSON) 

	public String View_cancel_Payment() {
		
		 PaymentRepository model = new  PaymentRepository();
		 String status = model.ViewCancelPayment();

		
		return status;
	} 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Add_Payment(String details) {
		
		JsonObject PAYdetails = new JsonParser().parse(details).getAsJsonObject();
		
		int hospitaliD = PAYdetails.get("hospitalID").getAsInt();
		int patientiD = PAYdetails.get("patientID").getAsInt();
		int appointmentiD = PAYdetails.get("appointmentID").getAsInt();
		String type = PAYdetails.get("type").getAsString();
		float amount = PAYdetails.get("amount").getAsFloat();
		String date = PAYdetails.get("date").getAsString();
		String creditCardNum = PAYdetails.get("creditCardNumber").getAsString();
		int cvc = PAYdetails.get("cvc").getAsInt();
		String cardholderName = PAYdetails.get("cardHolderName").getAsString();
		String reqcancl = PAYdetails.get("req_stat_cancl").getAsString();
		 
		 
		Payment pay = new Payment();
		pay.setHospitalID(hospitaliD);
		pay.setPatientID(patientiD);
		pay.setAppointmentID(appointmentiD);
		pay.setType(type);
		pay.setAmount(amount);
		pay.setDate(date);
		pay.setCreditCardNumber(creditCardNum);
		pay.setCvc(cvc);
		pay.setCardHolderName(cardholderName);
		pay.setreq_stat_cancl(reqcancl);
		
		PaymentRepository model = new PaymentRepository();
		String status = model.addPayment(pay);
		
		
		
		return status;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String Update_Payment(String details) {
		
		JsonObject PAYdetails = new JsonParser().parse(details).getAsJsonObject();
		
		int paymentiD = PAYdetails.get("paymentID").getAsInt();
		int hospitaliD = PAYdetails.get("hospitalID").getAsInt();
		int patientiD = PAYdetails.get("patientID").getAsInt();
		int appointmentiD = PAYdetails.get("appointmentID").getAsInt();
		String type = PAYdetails.get("type").getAsString();
		float amount = PAYdetails.get("amount").getAsFloat();
		String date = PAYdetails.get("date").getAsString();
		String creditCardNum = PAYdetails.get("creditCardNumber").getAsString();
		int cvc = PAYdetails.get("cvc").getAsInt();
		String cardholderName = PAYdetails.get("cardHolderName").getAsString();
		String reqcancl = PAYdetails.get("req_stat_cancl").getAsString();
		 
		 
		Payment pay = new Payment();
		pay.setPaymentID(paymentiD);
		pay.setHospitalID(hospitaliD);
		pay.setPatientID(patientiD);
		pay.setAppointmentID(appointmentiD);
		pay.setType(type);
		pay.setAmount(amount);
		pay.setDate(date);
		pay.setCreditCardNumber(creditCardNum);
		pay.setCvc(cvc);
		pay.setCardHolderName(cardholderName);
		pay.setreq_stat_cancl(reqcancl);
		 
		PaymentRepository model = new PaymentRepository();
		String status = model.UpdatePayment(pay);
		
		
		return status;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	
	public String Delete_Payment(String id) {
		
		JsonObject P_details = new JsonParser().parse(id).getAsJsonObject();
		
		int id_1 = P_details.get("paymentID").getAsInt();
		
		PaymentRepository model = new PaymentRepository();
		String status = model.DeletePayment(id_1);
		
		
		
		return status;
	}
	
}
