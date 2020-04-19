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
	
	
	
	///Retrieve Stock
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
	
	
	///Insert Stock
	public void addPharma( PharmaSto pharmaSto){
		
		try {
			String Insertquery = "insert into stock(LineNo, Icode, PackSize, Iname, SupPrice, SupDiscount, CostPrice, Selling, WholeSalePrice, Date) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preStatement = con.prepareStatement(Insertquery);
			
			preStatement.setString(1, pharmaSto.getLineNo());
			preStatement.setString(2, pharmaSto.getIcode());
			preStatement.setString(3, pharmaSto.getPackSize());
			preStatement.setString(4, pharmaSto.getIname());
			preStatement.setString(5, pharmaSto.getSupPrice());
			preStatement.setString(6, pharmaSto.getSupDiscount());
			preStatement.setString(7, pharmaSto.getCostPrice());
			preStatement.setString(8, pharmaSto.getSelling());
			preStatement.setString(9, pharmaSto.getWholeSalePrice());
			preStatement.setString(10, pharmaSto.getDate());
			
			preStatement.executeUpdate() ;	
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	}
	
	
	///Update Stock
	public void updateitem(String iCode, PharmaSto pharmaSto){
		
		try {
			String updateQuery = "update stock as s set s.LineNo = '"+pharmaSto.getLineNo()+"', "
					+ "s.Icode ='"+pharmaSto.getIcode()+"', s.PackSize ='"+pharmaSto.getPackSize()+"'"
					+ ", s.Iname = '"+pharmaSto.getIname()+"', s.SupPrice ='"+pharmaSto.getSupPrice()+"', "
							+ "s.SupDiscount ='"+pharmaSto.getSupDiscount()+"',"
					+ " s.CostPrice ='"+pharmaSto.getCostPrice()+"', s.Selling ='"+pharmaSto.getSelling()+"',"
							+ " s.WholeSalePrice ='"+pharmaSto.getWholeSalePrice()+"', s.Date='"+pharmaSto.getDate()+"' where s.Icode = ?";
			
			preStatement = con.prepareStatement(updateQuery);
			preStatement.setString(1, iCode);
			preStatement.executeUpdate();
			
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
	}
	
	////Delete Item
	public void removeItem(String iCode){
		try {
			String deleteQuery = "delete from stock where stock.Icode = ?";
			preStatement = con.prepareStatement(deleteQuery);
			
			preStatement.setString(1, iCode);
			preStatement.executeUpdate();
			
			
		}catch(Exception e)	{
			System.out.println(e);
			
		}
		
		
	}
	
	

}
