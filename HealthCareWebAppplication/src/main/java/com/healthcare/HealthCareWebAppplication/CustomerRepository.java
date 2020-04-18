package com.healthcare.HealthCareWebAppplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;





public class CustomerRepository {
	
	 Connection con = null ;
	
	 Statement statement ;
	
	 PreparedStatement preStatement ;
	
	public CustomerRepository(){
		
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
	

	
	public ArrayList<Customer> getCustomer() {
		
		ArrayList<Customer> CustomerList = new ArrayList <>() ;
		
		try {
			String Excu_query2 = "select * from customer";
			statement = con.createStatement();
			
			ResultSet customerResultSet = statement.executeQuery(Excu_query2) ;
			
			while(customerResultSet.next()) {
				Customer cus = new Customer();
				cus.setCustomerID(customerResultSet.getString(1));
				cus.setFName(customerResultSet.getString(2));
				cus.setLName(customerResultSet.getString(3));
				cus.setMobile(customerResultSet.getString(4));
				cus.setNIC(customerResultSet.getString(5));
				cus.setAddress(customerResultSet.getString(6));
				cus.setGender(customerResultSet.getString(7));
				cus.setDOB(customerResultSet.getDate(8));
				cus.setRegister(customerResultSet.getBoolean(9));
				
				
				CustomerList.add(cus);
			}
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	return CustomerList ;
	}
	

}
