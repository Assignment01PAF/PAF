package com.healthcare.HealthCareWebAppplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PharmaStoRepository {
	
	Connection con = null;
	Statement statement ;
	PreparedStatement preStatement ;

	public PharmaStoRepository() {
		String dbURL = "jdbc:mysql://127.0.0.1:3306/pharma_db?useSSL=false" ;
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
	
	
	public ArrayList<PharmaSto> getSto() {
		ArrayList<PharmaSto> stoList = new ArrayList <>() ;
		
		try {
			String Excu_query2 = "select Iname, PackSize, Selling from stock";
			statement = con.createStatement();
			
			ResultSet customerResultSet = statement.executeQuery(Excu_query2) ;
			
			while(customerResultSet.next()) {
				PharmaSto sto = new PharmaSto();
				sto.setIname(customerResultSet.getString(1));
				sto.setPackSize(customerResultSet.getString(2));
				sto.setSelling(customerResultSet.getString(3));
				
				
				stoList.add(sto);
			}
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	return stoList ;
	}
	
	

}
