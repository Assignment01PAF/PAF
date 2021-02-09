package com.healthcare.HealthCareWebAppplication;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("appointment")
public class AppointmentResource {
	
	AppointmentRepository app = new AppointmentRepository();
	
	
	@GET 
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON })
    public ArrayList<Appointment> getAppointmnet() {
		System.out.println("You Got Your Appointmnet...");
        return app.getAppointmnet();
    }
	
	
	@POST
	@Path("addAppointmnet")
    public Appointment addAppointment(Appointment appointment) {
		System.out.println("Item Insert Successfully..." +"="+ appointment);
		app.addAppointment(appointment);
        return appointment;
    }
	
	@POST
	@Path("updateAppointment/{id}")
    public Appointment updateAppointmnet(@PathParam("id") String aId ,Appointment apointmnet) {
		System.out.println("Appointmnet Update Successfully...");
        app.updateAppointmnet(aId, apointmnet);
        return apointmnet;
    }
	
	@POST
	@Path("deleteAppointmnet/{id}")
    public void deletePharma(@PathParam("id") String aId) {
		System.out.println("Appointmnet Delete Successfully...");
        app.removeAppointmnet(aId);
    }
	
	

}
