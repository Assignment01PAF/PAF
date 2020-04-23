package com.healthcare.HealthCareWebAppplication;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("doctor")
public class DoctorResource {
	
	DoctorRepository dr = new DoctorRepository();
	
	@GET 
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON })
    public ArrayList<Doctor> getAppointmnet() {
		System.out.println("You Got Your Doctors...");
        return dr.getDoctor();
    }
	
	@POST
	@Path("updateDoctor/{id}")
    public Doctor updateAppointmnet(@PathParam("id") String dId ,Doctor doctor) {
		System.out.println("Appointmnet Update Successfully...");
        dr.DoctorRegister(dId, doctor);
        return doctor;
    }
	
	@POST
	@Path("deleteDoctor/{id}")
    public void deletePharma(@PathParam("id") String dId) {
		System.out.println("Doctor Delete Successfully...");
        dr.removeDoctor(dId);
    }

}
