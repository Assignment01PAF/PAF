package com.healthcare.HealthCareWebAppplication;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("customer")
public class CustomerResource {
	
	CustomerRepository cr = new CustomerRepository();
	
	@GET 
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON })
    public ArrayList<Customer> getCustomer() {
		System.out.println("You Got Your Customer...");
        return cr.getCustomer();
    }
	
	@POST
	@Path("updateCustomer/{id}")
    public Customer updateAppointmnet(@PathParam("id") String cId ,Customer customer) {
		System.out.println("Customer Update Successfully...");
        cr.CustomerRegister(cId, customer);
        return customer;
    }
	
	@POST
	@Path("deleteCustomer/{id}")
    public void deletePharma(@PathParam("id") String cId) {
		System.out.println("Customer Delete Successfully...");
        cr.removeCustomer(cId);
    }

}
