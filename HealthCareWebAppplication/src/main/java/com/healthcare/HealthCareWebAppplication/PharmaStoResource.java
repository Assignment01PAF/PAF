package com.healthcare.HealthCareWebAppplication;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	
	@POST
	@Path("addItem")
    public PharmaSto addParma(PharmaSto pharmaSto) {
		System.out.println("Item Insert Successfully..." +"="+ pharmaSto);
        ps.addPharma(pharmaSto);
        return pharmaSto;
    }
	
	@POST
	@Path("updateItem/{code}")
    public PharmaSto updatePharma(@PathParam("code") String code ,PharmaSto pharmaSto) {
		System.out.println("Item Update Successfully...");
        ps.updateitem(code, pharmaSto);
        return pharmaSto;
    }
	
	@POST
	@Path("deleteItem/{code}")
    public void deletePharma(@PathParam("code") String code) {
		System.out.println("Item Delete Successfully...");
        ps.removeItem(code);
    }
 
}
