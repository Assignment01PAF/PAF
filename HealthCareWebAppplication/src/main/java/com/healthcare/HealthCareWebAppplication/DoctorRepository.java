package com.healthcare.HealthCareWebAppplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorRepository {
	
	Connection con = null ;
	
	Statement statement ;
	
	PreparedStatement preStatement ;

	public DoctorRepository() {
		
		String dbURL = "jdbc:mysql://127.0.0.1:3306/helthcare_db?useSSL=false" ;
		//String dbName = "" ;
		String dbUsername = "root" ;
		String dbPassword = "3edc$RFV";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,dbUsername , dbPassword);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Doctor> getDoctor() {
		
		ArrayList<Doctor> DoctortList = new ArrayList <>() ;
		
		try {
			String Excu_query1 = "select * from doctor_reg where doctor_reg.Check = '0'";
			statement = con.createStatement();
			
			ResultSet DoctorResultSet = statement.executeQuery(Excu_query1) ;
			
			while(DoctorResultSet.next()) {
				Doctor app = new Doctor();
				app.setFirstName(DoctorResultSet.getString(1));
				app.setLastName(DoctorResultSet.getString(2));
				app.setEmail(DoctorResultSet.getString(3));
				app.setDoctorID(DoctorResultSet.getString(4));
				app.setSpecialty(DoctorResultSet.getString(5));
				app.setNic(DoctorResultSet.getString(6));
				app.setPhoneNO(DoctorResultSet.getString(7));
				
				
				DoctortList.add(app);
			}
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	return DoctortList;
	}
	
	//Register Doctor
		public void DoctorRegister(String dId, Doctor doctor){
			
			try {
				String updateQuery = "update doctor_reg as dr set dr.Check = '1'  where dr.doctorID = ?";
				
				preStatement = con.prepareStatement(updateQuery);
				preStatement.setString(1, dId);
				preStatement.executeUpdate();
				
				
			}catch(Exception e)	{
				System.out.println(e);
				
			}
		}


		public void removeDoctor(String dId) {
			try {
				String deleteQuery = "delete from doctor_reg where doctor_reg.doctorID = ?";
				preStatement = con.prepareStatement(deleteQuery);
				
				preStatement.setString(1, dId);
				preStatement.executeUpdate();
				
				
			}catch(Exception e)	{
				System.out.println(e);
				
			}
			
		}
	
		
		
	
}
