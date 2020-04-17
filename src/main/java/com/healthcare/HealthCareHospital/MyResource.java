package com.healthcare.HealthCareHospital;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Hospital;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	Hospital hObj = new Hospital();

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getIt() {

		return hObj.readHospitals();
		// return "Got it!";
	}
	
	@POST
	//@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insert(@FormParam("hName") String hName, @FormParam("hPhone") String hPhone, @FormParam("hAddress") String hAddress, @FormParam("hEmail") String hEmail, @FormParam("hType") String hType) {

		String output = hObj.insertHospital(hName, hPhone, hAddress, hEmail, hType);
		return output;
	}
	
	@PUT
	//@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(String hospitalData) {
		
		JsonObject hJsonObj = new JsonParser().parse(hospitalData).getAsJsonObject();
		
		Integer hID = hJsonObj.get("hID").getAsInt();
		String hName = hJsonObj.get("hName").getAsString();
		String hPhone = hJsonObj.get("hPhone").getAsString();
		String hAddress = hJsonObj.get("hAddress").getAsString();
		String hEmail = hJsonObj.get("hEmail").getAsString();
		String hType = hJsonObj.get("hType").getAsString();
		
		String output = hObj.updateHospital(hID, hName, hPhone, hAddress, hEmail, hType);
		
		return output;
	}
	
	@DELETE
	//@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(String hospitalData)
	{
		
	//Convert the input string to an XML document
	Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());
	
	//Read the value from the element <hID>
	String hID = doc.select("hID").text();
	
	String output = hObj.deleteHospital(hID);
	
	return output;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
