package com.healthcare.HealthCareWebAppplication;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("stock")
public class PharmaStoResource {
	
	PharmaStoRepository ps = new PharmaStoRepository();
	
	@GET 
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON })
    public ArrayList<PharmaSto> getSto() {
		System.out.println("You Got Your Item...");
        return ps.getSto();
    }

}
