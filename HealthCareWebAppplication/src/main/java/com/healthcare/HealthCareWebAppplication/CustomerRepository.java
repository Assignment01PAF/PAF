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
			String Excu_query2 = "select * from customer where customer.Register = '0'";
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



	public void CustomerRegister(String cId, Customer customer) {
		// TODO Auto-generated method stub
		try {
			String updateQuery = "update customer as c set c.Register = '1'  where c.CustomerID = ?";
			
			preStatement = con.prepareStatement(updateQuery);
			preStatement.setString(1, cId);
			preStatement.executeUpdate();
			
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
		
	}



	public void removeCustomer(String cId) {
		// TODO Auto-generated method stub
		try {
			String deleteQuery = "delete from customer where customer.CustomerID = ?";
			preStatement = con.prepareStatement(deleteQuery);
			
			preStatement.setString(1, cId);
			preStatement.executeUpdate();
			
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	}
	

}
