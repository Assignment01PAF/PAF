package com;

import model.Hospital;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("Hospital")
public class HospitalService {

	//Hospital hObj = new Hospital();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospitals() {
		
//		return hObj.readHospitals();
		return "Hospital Works!";
	}
}
