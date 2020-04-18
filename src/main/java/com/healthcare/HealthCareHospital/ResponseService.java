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


import model.UserResponse;

@Path("responses")
public class ResponseService {

	UserResponse userObj = new UserResponse();

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getIt() {

		return userObj.getMsg();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insert(@FormParam("mName") String mName, @FormParam("mEmail") String mEmail, @FormParam("mPhone") String mPhone, @FormParam("mMsg") String mMsg) 
	{
		String output = userObj.addMsg(mName, mEmail, mPhone, mMsg);
		return output;
	}
	

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(String msgData) {
		
		JsonObject msgJsonObj = new JsonParser().parse(msgData).getAsJsonObject();
		
		Integer mID = msgJsonObj.get("mID").getAsInt();
		String mName = msgJsonObj.get("mName").getAsString();
		String mEmail = msgJsonObj.get("mEmail").getAsString();
		String mPhone = msgJsonObj.get("mPhone").getAsString();
		String mMsg = msgJsonObj.get("mMsg").getAsString();
		
		String output = userObj.updateMsg(mID, mName, mEmail, mPhone, mMsg);
		
		return output;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(String msgData)
	{
		
	//Convert the input string to an XML document
	Document doc = Jsoup.parse(msgData, "", Parser.xmlParser());
	
	//Read the value from the element <mID>
	String mID = doc.select("mID").text();
	
	String output = userObj.deleteMsg(mID);
	
	return output;
	}
}
