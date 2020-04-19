package com.HealthCare.HealthDoctor;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("doctor")
public class DoctorRepository {
	
	DoctorResource docrepo = new DoctorResource();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Doctor> getDoctors() {
		return docrepo.getDoctors();
	}
	
	
	@POST
	@Path("/ver")
	@Produces(MediaType.APPLICATION_XML)
	public boolean verify(Doctor d1) {
		System.out.println(d1);
		return docrepo.verifyUser(d1);
	}
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public void insert(Doctor d1) {
		System.out.println(d1);
		docrepo.insert(d1);
	}
	
	@DELETE
	@Path("/{doctorID}")
	public void delete(@PathParam("doctorID") String doctorID) {
		docrepo.delete(doctorID);
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	public void update(Doctor d1) {
		System.out.println(d1);
		docrepo.update(d1);
	}
	
	

}
