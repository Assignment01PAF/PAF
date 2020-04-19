package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserResponse {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userresponse?serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String addMsg(String mName, String mEmail, String mPhone, String mMsg) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			String query = "insert into message (`mName`,`mEmail`,`mPhone`,`mMsg`)"
					+ " values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setString(1, mName);
			preparedStmt.setString(2, mEmail);
			preparedStmt.setString(3, mPhone);
			preparedStmt.setString(4, mMsg);
			

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the response.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String getMsg()
	{
		String output = "";
	try
	{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for reading."; }
		
		
		output = "<table border=\"1\"><tr><th>Name</th><th>Email</th>"
				+ "<th>Phone</th>"
				+ "<th>Message</th>"
				+ "<th>Actions</th></tr>";
		
		String query = "select * from message";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next())
		{
		String mID = Integer.toString(rs.getInt("mID"));
		String mName = rs.getString("mName");
		String mEmail = rs.getString("mEmail");
		String mPhone = rs.getString("mPhone");
		String mMsg = rs.getString("mMsg");
		

		
		output += "<tr><td>" + mName + "</td>";
		output += "<td>" + mEmail + "</td>";
		output += "<td>" + mPhone + "</td>";
		output += "<td>" + mMsg + "</td>";
		
		
		
		output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\">"
		+ "<form method=\"post\" action=\"responses.jsp\">"
		+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
		+ "<input name=\"hID\" type=\"hidden\" value=\"" + mID + "\">" + "</form></td></tr>";
		}
		con.close();
		
		output += "</table>";
		}
		catch (Exception e)
		{
		output = "Error while reading the responses.";
		System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String updateMsg(Integer mID, String mName, String mEmail, String mPhone, String mMsg)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for updating."; }
			
			
			String query = "UPDATE message SET mName=?,mEmail=?,mPhone=?,mMsg=? WHERE mID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, mName);
			preparedStmt.setString(2, mEmail);
			preparedStmt.setString(3, mPhone);
			preparedStmt.setString(4, mMsg);
			preparedStmt.setInt(5, mID);
			
			
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
			}
			catch (Exception e)
			{
			output = "Error while updating the response.";
			System.err.println(e.getMessage());
			}
		return output;
	}
	
	public String deleteMsg(String mID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			String query = "delete from message where mID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, Integer.parseInt(mID));
			
			
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the response!";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
