package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hospital {
	
	// A common method to connect to the DB
		private Connection connect() {
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospitaldb?serverTimezone=UTC", "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}

		
		
		public String insertHospital(String hName, String hPhone, String hAddress, String hEmail, String hType) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = "insert into hospital (`hName`,`hPhone`,`hAddress`,`hEmail`,`hType`)"
						+ " values (?, ?, ?, ?, ?)";

				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				//preparedStmt.setInt(1, 0);
				preparedStmt.setString(1, hName);
				preparedStmt.setString(2, hPhone);
				preparedStmt.setString(3, hAddress);
				preparedStmt.setString(4, hEmail);
				preparedStmt.setString(5, hType);

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			} catch (Exception e) {
				output = "Error while inserting the hospital.";
				System.err.println(e.getMessage());
			}
			return output;
		}

		public String readHospitals()
		{
			String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for reading."; }
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Name</th><th>Phone</th>"
					+ "<th>Address</th>"
					+ "<th>Email</th><th>Type</th><th>Actions</th></tr>";
			
			String query = "select * from hospital";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next())
			{
			String hID = Integer.toString(rs.getInt("hID"));
			String hName = rs.getString("hName");
			String hPhone = rs.getString("hPhone");
			String hAddress = rs.getString("hAddress");
			String hEmail = rs.getString("hEmail");
			String hType = rs.getString("hType");

			// Add into the html table
			output += "<tr><td>" + hName + "</td>";
			output += "<td>" + hPhone + "</td>";
			output += "<td>" + hAddress + "</td>";
			output += "<td>" + hEmail + "</td>";
			output += "<td>" + hType + "</td>";
			
			// buttons
			output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\">"
			+ "<form method=\"post\" action=\"hospital.jsp\">"
			+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
			+ "<input name=\"hID\" type=\"hidden\" value=\"" + hID + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
			}
			catch (Exception e)
			{
			output = "Error while reading the hospitals.";
			System.err.println(e.getMessage());
			}
			return output;
		}

		public String updateHospital(Integer hID, String hName, String hPhone, String hAddress, String hEmail, String hType)
		{
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for updating."; }
				
				// create a prepared statement
				String query = "UPDATE hospital SET hName=?,hPhone=?,hAddress=?,hEmail=?,hType=? WHERE hID=?";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				//preparedStmt.setInt(1, 0);
				preparedStmt.setString(1, hName);
				preparedStmt.setString(2, hPhone);
				preparedStmt.setString(3, hAddress);
				preparedStmt.setString(4, hEmail);
				preparedStmt.setString(5, hType);
				preparedStmt.setInt(6, hID);
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
				}
				catch (Exception e)
				{
				output = "Error while updating the hospital.";
				System.err.println(e.getMessage());
				}
			return output;
		}

		public String deleteHospital(String hID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from hospital where hID=?";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(hID));
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";
			} catch (Exception e) {
				output = "Error while deleting the hospital!";
				System.err.println(e.getMessage());
			}
			return output;
		}
}
