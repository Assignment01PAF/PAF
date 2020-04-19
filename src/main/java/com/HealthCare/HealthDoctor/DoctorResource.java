package com.HealthCare.HealthDoctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorResource {

	Connection con = null ;
	
	 Statement statement ;
	
	 PreparedStatement preStatement ;
	
	public DoctorResource() {
		
		String dbURL = "jdbc:mysql://127.0.0.1:3306/doctor" ;
		//String dbName = "" ;
		String dbUsername = "root" ;
		String dbPassword = "dila123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbURL,dbUsername , dbPassword);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public List<Doctor> getDoctors() {
		
		List<Doctor> doctors = new ArrayList<>();
		
		String sql = "SELECT * FROM doctor_reg";
		
	try {
		Statement st = con.createStatement();
		ResultSet dr = st.executeQuery(sql);
		
		while (dr.next()) {
			Doctor d = new Doctor();
			
			d.setFirstName(dr.getString(1));
			d.setLastName(dr.getString(2));
			d.setEmail(dr.getString(3));
			d.setPassword(dr.getString(4));
			d.setDoctorID(dr.getString(5));
			d.setSpecialty(dr.getString(6));
			d.setNIC(dr.getString(7));
			d.setPhoneNO(dr.getString(8));
			
			doctors.add(d);
			
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return doctors;

	}
	
	
	
	public boolean verifyUser(Doctor d1) {
		ResultSet number;
		String sql = "SELECT * FROM doctor.doctor_reg WHERE email=? AND password=?";
		
	try {
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, d1.getEmail());
		st.setString(2, d1.getPassword());
		
		number=st.executeQuery();
		
		if(number == null) {
			System.out.println("Done");
			return true;
			
		}
		
	
	} catch (Exception e) {
		System.out.println(e);
	}
		
		
		return false;
		
	}
	
	
	
	public void insert(Doctor d1) {
		
		String sql = "INSERT INTO doctor.doctor_reg(firstName,lastName,email,password,doctorID,specialty,nic,phoneNO) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, d1.getFirstName());
			st.setString(2, d1.getLastName());
			st.setString(3, d1.getEmail());
			st.setString(4, d1.getPassword());
			st.setString(5, d1.getDoctorID());
			st.setString(6, d1.getSpecialty());
			st.setString(7, d1.getNIC());
			st.setString(8, d1.getPhoneNO());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void delete(String doctorID) {
		String sql = "DELETE FROM doctor.doctor_reg WHERE doctorID=?;";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, doctorID);
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public void update(Doctor d1) {
		
		String sql = "UPDATE doctor.doctor_reg SET firstName =?, lastName = ?, email = ?, password = ?, doctorID = ?, specialty = ?, nic = ?, phoneNO =? WHERE doctorID = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, d1.getFirstName());
			st.setString(2, d1.getLastName());
			st.setString(3, d1.getEmail());
			st.setString(4, d1.getPassword());
			st.setString(5, d1.getDoctorID());
			st.setString(6, d1.getSpecialty());
			st.setString(7, d1.getNIC());
			st.setString(8, d1.getPhoneNO());
			st.setString(9, d1.getDoctorID());
			
			
			st.executeUpdate();
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	


	
	
	
}
