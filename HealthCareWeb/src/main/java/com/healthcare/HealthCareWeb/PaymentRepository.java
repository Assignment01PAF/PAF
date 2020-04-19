package com.healthcare.HealthCareWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentRepository {

	Connection con = null; 
	Statement statement ;
	PreparedStatement preStatement ;
	
	
	public PaymentRepository() {
		
		String dbURL = "jdbc:mysql://127.0.0.1:3306/helth_db" ;
		//String dbName = "" ;
		String dbUsername = "root" ;
		String dbPassword = "kevinben10";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,dbUsername , dbPassword);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
public String ViewPayment() {
		
		String a = null;
		
		try {
			String sql = "SELECT * FROM payment";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); 
	         
					a = "<table>"
	     				+ "<tr>"
	     				+ "<th>payment ID<td>"	     				
	     				+ "<th>Hospital ID<td>"
	     				+ "<th>Patient ID<td>"
	     				+ "<th>Appointment ID<td>"
	     				+ "<th>type<td>"
	     				+ "<th>Amount<td>"
	     				+ "<th>Date<td>"
	     				+ "<th>CreditCard Number<td>"
	     				+ "<th>cvc<td>"
	     				+ "<th>CardHolder Name<td>"
	     				+ "<th>Request to cancel or not<td>"	     				 
	     				+ "</tr>";
					
					
			
	         while (rst.next()) {
             
	        	   a +=  "<tr>"
	     				+ "<td>"+rst.getInt("paymentID")+"<td>"
	     				+ "<td>"+rst.getInt("hospitalID")+"<td>"
	     				+ "<td>"+rst.getInt("patientID")+"<td>"
	     				+ "<td>"+rst.getInt("appointmentID")+"<td>"
	     				+ "<td>"+rst.getString("type")+"<td>"
	     				+ "<td>"+rst.getString("amount")+"<td>"
	     				+ "<td>"+rst.getString("date")+"<td>"
	    	     		+ "<td>"+rst.getString("creditCardNumber")+"<td>"
	    	     		+ "<td>"+rst.getInt("cvc")+"<td>"
	    	     		+ "<td>"+rst.getString("cardHolderName")+"<td>"
	     				+ "<td>"+rst.getString("req_stat_cancl")+"<td>"	     							 
	     				+ "</tr>";
	     		
	         }
	         
	         a += "</table>";
	         
	         
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
              
		
		return a;

	}

public String addPayment(Payment pay) {

	String e1 = null;

	try { 

		String sql = "INSERT INTO payment(hospitalID, patientID, appointmentID,type,amount,date, creditCardNumber ,cvc , cardHolderName ,req_stat_cancl) "
				+ "VALUE(?,?,?,?,?,?,?,?,?,?)";
		

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setInt(1, pay.getHospitalID());
		pst.setInt(2, pay.getPatientID());
		pst.setInt(3, pay.getAppointmentID());
		pst.setString(4, pay.getType());
		pst.setFloat(5, pay.getAmount());
		pst.setString(6, pay.getDate());
		pst.setString(7, pay.getCreditCardNumber());
		pst.setInt(8, pay.getCvc());
		pst.setString(9, pay.getCardHolderName());
		pst.setString(10, pay.getreq_stat_cancl());
		 
     	   

		pst.executeUpdate();

		e1 = "payment details inserted";

	} catch (SQLException e) {

		e.printStackTrace();
	}
	return e1;

	}

public String UpdatePayment(Payment pay) {

	String e = null;
	
	
	try {
		
		String sql = "UPDATE payment SET  hospitalID = ?,patientID = ?,appointmentID = ?,type = ?,amount = ?,date = ?,creditCardNumber = ?,cvc = ?, cardHolderName = ?,req_stat_cancl = ? WHERE paymentID =?";
					
	 

		PreparedStatement pst;
		pst = con.prepareStatement(sql);

		
		pst.setInt(1, pay.getHospitalID());
		pst.setInt(2, pay.getPatientID());
		pst.setInt(3, pay.getAppointmentID());
		pst.setString(4, pay.getType());
		pst.setFloat(5, pay.getAmount());
		pst.setString(6, pay.getDate());
		pst.setString(7, pay.getCreditCardNumber());
		pst.setInt(8, pay.getCvc());
		pst.setString(9, pay.getCardHolderName());
		pst.setString(10, pay.getreq_stat_cancl());
		pst.setInt(11, pay.getPaymentID());

		pst.executeUpdate();
		
		e = "payment details Updated";
		
		
	} catch (SQLException e1) {


		e1.printStackTrace();
	}

	

	return e;

	}

public String DeletePayment(int id) {
	
	String status = null; 	
	
	try {
		String sql = "DELETE FROM payment "
					+ "WHERE paymentID = ? ";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();			
		status = "payment "+id+" deleted ";
		
	} catch (SQLException e) {
		 
		e.printStackTrace();
	}
	 
	
	return status;

	}

public String ViewCancelPayment() {
	
	String a = null;
	
	try {
		String sql = "SELECT * FROM payment WHERE req_stat_cancl = 'cancel'";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rst = pst.executeQuery(); 
         
				a = "<table>"
     				+ "<tr>"
     				+ "<th>payment ID<td>"	     				
     				+ "<th>Hospital ID<td>"
     				+ "<th>Patient ID<td>"
     				+ "<th>Appointment ID<td>"
     				+ "<th>type<td>"
     				+ "<th>Amount<td>"
     				+ "<th>Date<td>"
     				+ "<th>CreditCard Number<td>"
     				+ "<th>cvc<td>"
     				+ "<th>CardHolder Name<td>"
     				+ "<th>Request to cancel or not<td>"	     				 
     				+ "</tr>";
				
				
		
         while (rst.next()) {
         
        	   a +=  "<tr>"
     				+ "<td>"+rst.getInt("paymentID")+"<td>"
     				+ "<td>"+rst.getInt("hospitalID")+"<td>"
     				+ "<td>"+rst.getInt("patientID")+"<td>"
     				+ "<td>"+rst.getInt("appointmentID")+"<td>"
     				+ "<td>"+rst.getString("type")+"<td>"
     				+ "<td>"+rst.getString("amount")+"<td>"
     				+ "<td>"+rst.getString("date")+"<td>"
    	     		+ "<td>"+rst.getString("creditCardNumber")+"<td>"
    	     		+ "<td>"+rst.getInt("cvc")+"<td>"
    	     		+ "<td>"+rst.getString("cardHolderName")+"<td>"
     				+ "<td>"+rst.getString("req_stat_cancl")+"<td>"	     							 
     				+ "</tr>";
     		
         }
         
         a += "</table>";
         
         
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
          
	
	return a;

	}
	
}
