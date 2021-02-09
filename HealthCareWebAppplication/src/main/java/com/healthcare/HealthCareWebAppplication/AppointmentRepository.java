package com.healthcare.HealthCareWebAppplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AppointmentRepository {
	
	Connection con = null ;
	
	Statement statement ;
	
	PreparedStatement preStatement ;

	public AppointmentRepository() {
		
		 
			
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
	
	
	
	public ArrayList<Appointment> getAppointmnet() {
			
			ArrayList<Appointment> AppointmnetList = new ArrayList <>() ;
			
			try {
				String Excu_query1 = "select * from appointment ";
				statement = con.createStatement();
				
				ResultSet appoinmentResultSet = statement.executeQuery(Excu_query1) ;
				
				while(appoinmentResultSet.next()) {
					Appointment app = new Appointment();
					app.setAppointmnetID(appoinmentResultSet.getString(1));
					app.setAppointmentDate(appoinmentResultSet.getString(2));
					app.setAppoinementTime(appoinmentResultSet.getString(3));
					app.setcID(appoinmentResultSet.getString(4));
					app.setCname(appoinmentResultSet.getString(5));
					app.setdID(appoinmentResultSet.getString(6));
					app.setDname(appoinmentResultSet.getString(7));
					app.setDesease(appoinmentResultSet.getString(8));
					app.setHospitalID(appoinmentResultSet.getString(9));
					
					
					AppointmnetList.add(app);
				}
				
			}catch(Exception e)	{
				System.out.println(e);
				
			}
		return AppointmnetList;
		}


	//Insert Appointment
	public void addAppointment( Appointment appointment){
		
		try {
			String Insertquery = "insert into appointment(AppointmnetID, AppointmentDate, AppoinementTime, cID, Cname, dID, Dname, Desease, HospitalID, Check) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preStatement = con.prepareStatement(Insertquery);
			
			preStatement.setString(1, appointment.getAppointmnetID());
			preStatement.setString(2, appointment.getAppointmentDate());
			preStatement.setString(3, appointment.getAppoinementTime());
			preStatement.setString(4, appointment.getcID());
			preStatement.setString(5, appointment.getCname());
			preStatement.setString(6, appointment.getdID());
			preStatement.setString(7, appointment.getDname());
			preStatement.setString(8, appointment.getDesease());
			preStatement.setString(9, appointment.getHospitalID());
			preStatement.setBoolean(10, appointment.getCheck());
			
			preStatement.executeUpdate() ;	
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	}
	
	
	//Update appointment
	public void updateAppointmnet(String aId, Appointment appointmnet){
		
		try {
			String updateQuery = "update appointment as a set a.AppointmnetID = '"+appointmnet.getAppointmnetID()+"', "
					+ "a.AppointmentDate = '"+appointmnet.getAppointmentDate()+"', a.AppoinementTime = '"+appointmnet.getAppoinementTime()+"', "
					+ "a.cID = '"+appointmnet.getcID()+"', a.Cname = '"+appointmnet.getCname()+"', a.dID = '"+appointmnet.getdID()+"',"
							+ " a.Dname = '"+appointmnet.getDname()+"', a.Desease = '"+appointmnet.getDesease()+"', "
					+ "a.HospitalID = '"+appointmnet.getHospitalID()+"', a.Check = '"+appointmnet.getCheck()+"' where a.AppointmnetID = ?";
			
			preStatement = con.prepareStatement(updateQuery);
			preStatement.setString(1, aId);
			preStatement.executeUpdate();
			
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	}
	
	////Delete Item
	public void removeAppointmnet(String AppointmnetID){
		try {
			String deleteQuery = "delete from appointment where appointment.AppointmnetID = ?";
			preStatement = con.prepareStatement(deleteQuery);
			
			preStatement.setString(1, AppointmnetID);
			preStatement.executeUpdate();
			
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
		
		
	}
	
	
	
	

}
